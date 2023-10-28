package barber.gerard.backend.application.ports.in.constraints;

import barber.gerard.backend.infraestructure.commons.exceptions.AppointmentException;

import java.time.LocalDateTime;

public interface AppointmentConstraint {
  void validateAppointmentDateTime(LocalDateTime dateTime) throws AppointmentException;
}
