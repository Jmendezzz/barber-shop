package barber.gerard.backend.application.services;

import barber.gerard.backend.domain.models.Appointment;
import barber.gerard.backend.infraestructure.ports.in.AppointmentInputPort;
import barber.gerard.backend.infraestructure.ports.out.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppointmentService implements AppointmentInputPort {
  private AppointmentRepository appointmentRepository;
  @Override
  public Appointment createAppointment(Appointment appointment) {
    return appointmentRepository.save(appointment);
  }

  @Override
  public List<Appointment> getAllAppointments() {
    return appointmentRepository.findAll();
  }

  @Override
  public Optional<Appointment> getAppointmentById(Long id) {
    return appointmentRepository.findById(id);
  }

  @Override
  public Optional<Appointment> updateAppointment(Appointment appointmentUpdated) {
    return appointmentRepository.update(appointmentUpdated);
  }

  @Override
  public Appointment deleteAppointmentById(Long id) {
    return appointmentRepository.delete(id);
  }
}
