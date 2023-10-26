package barber.gerard.backend.application.ports.out;

import barber.gerard.backend.domain.models.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {
  Appointment save(Appointment appointment);
  Optional<Appointment> findById(Long id);
  List<Appointment> findAll();
  Optional<Appointment> update(Appointment appointment);
  Appointment delete(Long id);

}
