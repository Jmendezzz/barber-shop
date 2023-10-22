package barber.gerard.backend.infraestructure.commons.exceptions;

import org.springframework.http.HttpStatus;

public class CutServiceException extends CustomHttpException{
  public CutServiceException(String message, HttpStatus httpStatus) {
    super(message, httpStatus);
  }
}
