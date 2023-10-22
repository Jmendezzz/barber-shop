package barber.gerard.backend.infraestructure.commons.exceptions;

import org.springframework.http.HttpStatus;

public class AdminException extends CustomHttpException{
  public AdminException(String message, HttpStatus httpStatus) {
    super(message, httpStatus);
  }
}
