package barber.gerard.backend.infraestructure.commons.exceptions;

import org.springframework.http.HttpStatus;

public class BarberException extends CustomHttpException{
  public BarberException(String message, HttpStatus httpStatus) {
    super(message, httpStatus);
  }
}
