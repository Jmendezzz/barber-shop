package barber.gerard.backend.infraestructure.commons.exceptions;

import org.springframework.http.HttpStatus;

public class CustomerException extends CustomHttpException{
  public CustomerException(String message, HttpStatus httpStatus) {
    super(message, httpStatus);
  }
}
