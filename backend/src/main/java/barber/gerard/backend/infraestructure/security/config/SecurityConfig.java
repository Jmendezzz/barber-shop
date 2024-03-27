package barber.gerard.backend.infraestructure.security.config;

import barber.gerard.backend.infraestructure.security.filters.JwtTokenValidatorFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
  private final JwtTokenValidatorFilter jwtTokenValidatorFilter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

    return httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeRequests(http->{
              http.requestMatchers("/auth/*").permitAll();
              http.anyRequest().authenticated();
            })
            .addFilterBefore(jwtTokenValidatorFilter, BasicAuthenticationFilter.class)
            .build();



  }

}
