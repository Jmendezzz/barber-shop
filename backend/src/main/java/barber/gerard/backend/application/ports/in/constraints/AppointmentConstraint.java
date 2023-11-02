package barber.gerard.backend.application.ports.in.constraints;

import barber.gerard.backend.infraestructure.commons.exceptions.AppointmentException;

import java.time.LocalDateTime;

public interface AppointmentConstraint {
  void doesAppointmentExist(Long appointmentId) throws AppointmentException;
  void validateAppointmentDateTime(LocalDateTime dateTime) throws AppointmentException;
}
