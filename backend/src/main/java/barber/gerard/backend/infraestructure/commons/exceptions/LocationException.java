package barber.gerard.backend.infraestructure.commons.exceptions;

import org.springframework.http.HttpStatus;

public class LocationException extends CustomHttpException{
  public LocationException(String message, HttpStatus httpStatus) {
    super(message, httpStatus);
  }
}
