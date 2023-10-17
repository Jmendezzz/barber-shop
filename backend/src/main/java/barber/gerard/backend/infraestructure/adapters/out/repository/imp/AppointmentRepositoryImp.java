package barber.gerard.backend.infraestructure.adapters.out.repository.imp;

import barber.gerard.backend.domain.models.Appointment;
import barber.gerard.backend.infraestructure.ports.out.AppointmentRepository;

import java.util.List;
import java.util.Optional;

public class AppointmentRepositoryImp implements AppointmentRepository {
  @Override
  public Appointment save(Appointment appointment) {
    return null;
  }

  @Override
  public Optional<Appointment> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public List<Appointment> findAll() {
    return null;
  }

  @Override
  public Optional<Appointment> update(Appointment appointment) {
    return Optional.empty();
  }

  @Override
  public Appointment delete(Long id) {
    return null;
  }
}
