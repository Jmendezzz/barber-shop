package barber.gerard.backend.application.services;

import barber.gerard.backend.application.ports.in.constraints.AppointmentConstraint;
import barber.gerard.backend.domain.enums.Status;
import barber.gerard.backend.domain.models.Appointment;
import barber.gerard.backend.application.ports.in.services.AppointmentInputPort;
import barber.gerard.backend.application.ports.out.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
  @CacheEvict(value = "appointments", allEntries = true)
  public Appointment createAppointment(Appointment appointment) {
    appointmentConstraint.validateAppointmentDateTime(appointment.getDate());

    return appointmentRepository.save(appointment);
  }

  @Override
  @Cacheable("appointments")
  public List<Appointment> getAllAppointments() {
    return appointmentRepository.findAll();
  }

  @Override
  @Cacheable("appointments")
  public List<Appointment> getPaginatedAppointments(int page, int size) {
    return appointmentRepository.findPaginated(page,size);
  }

  @Override
  @Cacheable("appointments")
  public Optional<Appointment> getAppointmentById(Long id) {
    return appointmentRepository.findById(id);
  }

  @Override
  @CacheEvict(value = "appointments", allEntries = true)
  public Optional<Appointment> updateAppointment(Appointment appointmentUpdated) {
    return appointmentRepository.update(appointmentUpdated);
  }

  @Override
  @CacheEvict(value = "appointments", allEntries = true)
  public Appointment deleteAppointmentById(Long id) {
    return appointmentRepository.delete(id);
  }

  @Override
  @Scheduled(cron = "0 */5 * * * *")
  public void cancelUnconfirmedAppointments() {
    List<Appointment> appointmentsToCancel = getAppointmentsToCancel();
    appointmentsToCancel.forEach(appointment -> {
      appointment.setStatus(Status.CANCELED);
      appointmentRepository.update(appointment);
    });
  }

  @Override
  @CacheEvict(value = "appointments", allEntries = true)
  public Appointment acceptAppointment(Appointment appointment) {
    appointmentConstraint.doesAppointmentExist(appointment.getId());

    appointment.setStatus(Status.ACCEPTED);
    return appointmentRepository.update(appointment).get();
    //TODO: Notifications
  }

  @Override
  @CacheEvict(value = "appointments", allEntries = true)
  public Appointment rejectAppointment(Appointment appointment) {
    appointmentConstraint.doesAppointmentExist(appointment.getId());

    appointment.setStatus(Status.REJECTED);
    return appointmentRepository.update(appointment).get();
  }


  private List<Appointment> getAppointmentsToCancel(){
    List<Appointment> appointments = appointmentRepository.findByAnyField("status", Status.BOOKED);
    LocalDateTime localDateTimeToCancel = LocalDateTime.now().minusHours(1).minusMinutes(30);
    return appointments.stream()
                        .filter(appointment-> appointment.getDate().isBefore(localDateTimeToCancel))
                        .collect(Collectors.toList());
  }
}
