package barber.gerard.backend.application.constraints;

import barber.gerard.backend.application.ports.in.constraints.AppointmentConstraint;
import barber.gerard.backend.infraestructure.commons.exceptions.AppointmentException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static barber.gerard.backend.infraestructure.commons.exceptions.messages.AppointmentExceptionMessage.*;

@Component
@AllArgsConstructor
public class AppointmentConstraintImp implements AppointmentConstraint {
  private final int MINIMUM_APPOINTMENT_RESERVATION_ADVANCE_HOURS = 2;
  private final LocalTime OPENING_TIME = LocalTime.of(10,0);
  private final LocalTime CLOSING_TIME = LocalTime.of(19,0);


  @Override
  public void validateAppointmentDateTime(LocalDateTime dateTime) throws AppointmentException {
    if (dateTimeExceedsReservationTime(dateTime)) {
      throw new AppointmentException(APPOINTMENT_TIME_EXCEEDED, HttpStatus.BAD_REQUEST);
    }
    if(dateTimeIsBeforeOpeningTime(dateTime)){
      throw new AppointmentException(APPOINTMENT_TIME_BEFORE_OPENING_TIME, HttpStatus.BAD_REQUEST);
    }
    if(dateTimeIsAfterClosingTime(dateTime)){
      throw new AppointmentException(APPOINTMENT_TIME_AFTER_CLOSING_TIME, HttpStatus.BAD_REQUEST);
    }
  }

  private boolean dateTimeExceedsReservationTime(LocalDateTime dateTime) {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime dateTimeWithMinimumAdvance = now.plusHours(MINIMUM_APPOINTMENT_RESERVATION_ADVANCE_HOURS);
    return dateTime.isBefore(dateTimeWithMinimumAdvance);
  }

  private boolean dateTimeIsBeforeOpeningTime(LocalDateTime dateTime){
    LocalTime time = dateTime.toLocalTime();
    return time.isBefore(OPENING_TIME);
  }

  private boolean dateTimeIsAfterClosingTime(LocalDateTime dateTime){
    LocalTime time = dateTime.toLocalTime();
    return time.isAfter(CLOSING_TIME);
  }
}
