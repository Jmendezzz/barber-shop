package barber.gerard.backend.infraestructure.commons.exceptions;

import org.springframework.http.HttpStatus;

public class AppointmentException extends CustomHttpException{
  public AppointmentException(String message, HttpStatus httpStatus) {
    super(message, httpStatus);
  }

}
