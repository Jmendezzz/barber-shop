package barber.gerard.backend.infraestructure.commons.config;

import barber.gerard.backend.infraestructure.commons.exceptions.ExceptionResponse;
import barber.gerard.backend.infraestructure.commons.exceptions.ObjectNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice

public class GlobalExceptionHandler  {

  @ExceptionHandler(ObjectNotValidException.class)
  public ResponseEntity<ExceptionResponse> handleObjectNotValidException(ObjectNotValidException exception){
    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setMessage(exception.getErrorMessages().toString());
    exceptionResponse.setTimestamp(LocalDateTime.now());

    return ResponseEntity.badRequest().body(exceptionResponse);
  }


}