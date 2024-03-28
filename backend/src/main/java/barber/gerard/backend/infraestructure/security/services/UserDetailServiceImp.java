package barber.gerard.backend.infraestructure.security.services;

import barber.gerard.backend.application.ports.in.constraints.UserConstraint;
import barber.gerard.backend.application.ports.out.UserRepository;
import barber.gerard.backend.domain.enums.Role;
import barber.gerard.backend.domain.models.User;
import barber.gerard.backend.infraestructure.commons.mapping.auth.AuthLoginRequest;
import barber.gerard.backend.infraestructure.commons.mapping.auth.AuthMapper;
import barber.gerard.backend.infraestructure.commons.mapping.auth.AuthResponse;
import barber.gerard.backend.infraestructure.commons.mapping.auth.AuthSignUpRequest;
import barber.gerard.backend.infraestructure.security.utils.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserDetailServiceImp implements UserDetailsService {
  private final UserRepository userRepository;

  private final JwtUtil jwtUtil;

  private PasswordEncoder passwordEncoder;

  private final UserConstraint userConstraint;

  private final AuthMapper authMapper;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user =  userRepository.findByEmail(username)
            .orElseThrow(()-> new UsernameNotFoundException("User not found"));

    List<GrantedAuthority> role = new ArrayList<>();
    role.add(new SimpleGrantedAuthority("ROLE".concat(user.getRole().name())));

    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), role);
  }

  public AuthResponse login(AuthLoginRequest authLoginRequest){
    String email = authLoginRequest.username();
    String password = authLoginRequest.password();

    Authentication authentication = authenticate(email, password);

    String token = jwtUtil.generateToken(authentication);

    return new AuthResponse(email,"User logged in",token,true);

  }

  private Authentication authenticate(String email, String password) {

    UserDetails userDetails = loadUserByUsername(email);

    if(userDetails == null){
      throw new BadCredentialsException("Invalid username or password");
    }

    if(!passwordEncoder.matches(password, userDetails.getPassword())){
      throw new BadCredentialsException("Invalid username or password");
  }

    return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
  }

  public AuthResponse signUp(AuthSignUpRequest authSignUpRequest){
    User user = authMapper.signUpRequestToUser(authSignUpRequest);
    user.setRole(Role.CUSTOMER);

    userConstraint.validateUserEmail(user.getEmail());
    userConstraint.validateCellphone(user.getCellphoneNumber());

    User userCreated = userRepository.save(user);

    List<GrantedAuthority> role = new ArrayList<>();
    role.add(new SimpleGrantedAuthority("ROLE".concat(userCreated.getRole().name())));

    Authentication authentication = new UsernamePasswordAuthenticationToken(userCreated.getEmail(), userCreated.getPassword(), role);

    String token = jwtUtil.generateToken(authentication);
    return new AuthResponse(user.getEmail(),"User created",token,true);
  }
}
