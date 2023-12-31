package barber.gerard.backend.application.ports.out;

import barber.gerard.backend.domain.models.Appointment;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {
  Appointment save(Appointment appointment);
  Optional<Appointment> findById(Long id);
  List<Appointment> findAll();
  List<Appointment> findPaginated(int page, int size);
  Optional<Appointment> update(Appointment appointment);
  Appointment delete(Long id);
  <T> List<Appointment> findByAnyField (String fieldName, T fieldValue);
  List<Appointment> finByDateRange(LocalDateTime startDate, LocalDateTime endDate);

  boolean appointmentExistsById(Long appointmentId);
}
