package barber.gerard.backend.infraestructure.security.filters;

import barber.gerard.backend.infraestructure.security.utils.JwtUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collection;

@AllArgsConstructor
public class JwtTokenValidatorFilter extends OncePerRequestFilter {
  private JwtUtil jwtUtil;
  @Override
  protected void doFilterInternal(@NonNull HttpServletRequest request,
                                  @NonNull HttpServletResponse response,
                                  @NonNull FilterChain filterChain) throws ServletException, IOException {

  String token = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (token != null && token.startsWith("Bearer ")) {

      token = token.substring(7);

      DecodedJWT decodedJWT = jwtUtil.validateToken(token); // Throws an exception if the token is invalid

      String username = jwtUtil.extractUsername(decodedJWT);
      String stringAuthorities = jwtUtil.extractClaim(decodedJWT, "authorities").asString();

      Collection<? extends GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(stringAuthorities);

      SecurityContext context = SecurityContextHolder.getContext();

      Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, grantedAuthorities);

      context.setAuthentication(authentication);

      SecurityContextHolder.setContext(context);
    }

    filterChain.doFilter(request, response);
  }
}
