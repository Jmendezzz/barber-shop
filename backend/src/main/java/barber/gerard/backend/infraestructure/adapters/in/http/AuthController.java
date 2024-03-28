package barber.gerard.backend.infraestructure.adapters.in.http;

import barber.gerard.backend.infraestructure.commons.mapping.auth.AuthLoginRequest;
import barber.gerard.backend.infraestructure.commons.mapping.auth.AuthResponse;
import barber.gerard.backend.infraestructure.commons.mapping.auth.AuthSignUpRequest;
import barber.gerard.backend.infraestructure.commons.validator.ObjectValidator;
import barber.gerard.backend.infraestructure.security.services.UserDetailServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
  private ObjectValidator objectValidator;
  private UserDetailServiceImp userDetailServiceImp;


  @PostMapping("/log-in")
  public ResponseEntity<AuthResponse> login(@RequestBody AuthLoginRequest request) {
    objectValidator.validate(request);

    return new ResponseEntity<>(userDetailServiceImp.login(request), HttpStatus.OK);
  }

  @PostMapping("/sign-up")
  public ResponseEntity<AuthResponse> signup(@RequestBody AuthSignUpRequest request) {
    objectValidator.validate(request);

    return new ResponseEntity<>(userDetailServiceImp.signUp(request), HttpStatus.OK);
  }

}
