package barber.gerard.backend.infraestructure.ports.in;

import barber.gerard.backend.domain.models.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentInputPort {
  Appointment createAppointment(Appointment appointment);
  List<Appointment> getAllAppointments();
  Optional<Appointment> getAppointmentById(Long id);
  Optional<Appointment> updateAppointment(Appointment appointmentUpdated);
  Appointment deleteAppointmentById(Long id);

}
