package barber.gerard.backend.infraestructure.commons.exceptions.config;

import barber.gerard.backend.infraestructure.commons.exceptions.CustomHttpException;
import barber.gerard.backend.infraestructure.commons.exceptions.LocationException;
import barber.gerard.backend.infraestructure.commons.exceptions.ObjectNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice

public class GlobalExceptionHandler  {

  @ExceptionHandler(ObjectNotValidException.class)
  public ResponseEntity<ExceptionResponse> handleObjectNotValidException(ObjectNotValidException exception){
    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setMessage(String.join("|",exception.getErrorMessages()));
    exceptionResponse.setTimestamp(LocalDateTime.now());

    return ResponseEntity.badRequest().body(exceptionResponse);
  }

  @ExceptionHandler(CustomHttpException.class)
  public ResponseEntity<ExceptionResponse> handleHttpException(CustomHttpException exception){
    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setMessage(exception.getMessage());
    exceptionResponse.setTimestamp(LocalDateTime.now());

    return ResponseEntity.status(exception.getHttpStatus()).body(exceptionResponse);
  }

  @ExceptionHandler(AuthenticationException.class)
  public ResponseEntity<ExceptionResponse> handleAuthenticationException(AuthenticationException exception){
    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setMessage(exception.getMessage());
    exceptionResponse.setTimestamp(LocalDateTime.now());

    return ResponseEntity.status(401).body(exceptionResponse);
  }
}
