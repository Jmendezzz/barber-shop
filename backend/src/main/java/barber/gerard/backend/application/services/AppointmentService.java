package barber.gerard.backend.application.services;

import barber.gerard.backend.application.ports.in.constraints.AppointmentConstraint;
import barber.gerard.backend.domain.enums.Status;
import barber.gerard.backend.domain.models.Appointment;
import barber.gerard.backend.application.ports.in.services.AppointmentInputPort;
import barber.gerard.backend.application.ports.out.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

  @Override
  @Scheduled(cron = "0 */5 * * * *")
  public void cancelUnconfirmedAppointments() {
    System.out.println("executing cron job");
    List<Appointment> appointmentsToCancel = getAppointmentsToCancel();

    appointmentsToCancel.forEach(appointment -> {
      appointment.setStatus(Status.CANCELED);
      appointmentRepository.update(appointment);
    });
  }

  private List<Appointment> getAppointmentsToCancel(){
    List<Appointment> appointments = appointmentRepository.findByAnyField("status", Status.BOOKED);
    LocalDateTime localDateTimeToCancel = LocalDateTime.now().minusHours(1).minusMinutes(30);
    return appointments.stream()
                        .filter(appointment-> appointment.getDate().isBefore(localDateTimeToCancel))
                        .collect(Collectors.toList());
  }
}
