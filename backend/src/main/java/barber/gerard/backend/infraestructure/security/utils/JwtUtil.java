package barber.gerard.backend.infraestructure.security.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class JwtUtil {
  @Value("${security.jwt.key }")
  private String key;

  @Value("${security.jwt.userGenerator}")
  private String userGenerator;

  @Value("${security.jwt.expiration}")
  private long expiration;


  public String generateToken(Authentication authentication) {
    Algorithm algorithm = Algorithm.HMAC256(key);

    String username = (String) authentication.getPrincipal();

    String authorities = authentication.getAuthorities()
              .stream()
              .map(GrantedAuthority::getAuthority)
              .collect(Collectors.joining());

    String jwtToken = JWT.create()
              .withIssuer(userGenerator)
              .withSubject(username)
              .withClaim("authorities", authorities)
              .withIssuedAt(new Date())
              .withExpiresAt(new Date(System.currentTimeMillis() + expiration * 1000)) // Expiration time
              .withJWTId(UUID.randomUUID().toString()) // Unique identifier for the token
              .withNotBefore(new Date(System.currentTimeMillis())) // Time before which the token must not be accepted for processing
              .sign(algorithm);



    return jwtToken;
  }
}
