package barber.gerard.backend.application.services;

import barber.gerard.backend.application.ports.in.constraints.AppointmentConstraint;
import barber.gerard.backend.domain.models.Appointment;
import barber.gerard.backend.application.ports.in.services.AppointmentInputPort;
import barber.gerard.backend.application.ports.out.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppointmentService implements AppointmentInputPort {
  private AppointmentRepository appointmentRepository;
  private AppointmentConstraint appointmentConstraint;
  @Override
  public Appointment createAppointment(Appointment appointment) {
    appointmentConstraint.validateAppointmentDateTime(appointment.getDate());

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
