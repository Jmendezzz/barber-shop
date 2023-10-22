package barber.gerard.backend.infraestructure.commons.exceptions;

import org.springframework.http.HttpStatus;

public class UserException extends CustomHttpException{
  public UserException(String message, HttpStatus httpStatus) {
    super(message, httpStatus);
  }
}
