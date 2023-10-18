package barber.gerard.backend.infraestructure.adapters.out.repository.imp;

import barber.gerard.backend.domain.models.Appointment;
import barber.gerard.backend.infraestructure.adapters.out.repository.JpaAppointmentRepository;
import barber.gerard.backend.infraestructure.commons.mapping.appointment.AppointmentMapper;
import barber.gerard.backend.infraestructure.entities.AppointmentEntity;
import barber.gerard.backend.infraestructure.ports.out.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class AppointmentRepositoryImp implements AppointmentRepository {
  private JpaAppointmentRepository jpaAppointmentRepository;
  private AppointmentMapper appointmentMapper;
  @Override
  public Appointment save(Appointment appointment) {
    AppointmentEntity appointmentEntity = appointmentMapper.domainToEntity(appointment);
    AppointmentEntity appointmentSaved = jpaAppointmentRepository.save(appointmentEntity);

    return appointmentMapper.entityToDomain(appointmentSaved);
  }

  @Override
  public Optional<Appointment> findById(Long id) {
    Optional<AppointmentEntity> appointmentEntity = jpaAppointmentRepository.findById(id);

    return appointmentEntity
            .map(app-> appointmentMapper.entityToDomain(app));
  }

  @Override
  public List<Appointment> findAll() {
    return appointmentMapper.entityListToDomainList(jpaAppointmentRepository.findAll());
  }

  @Override
  public Optional<Appointment> update(Appointment appointment) {
    if(jpaAppointmentRepository.existsById(appointment.getId())) {
      AppointmentEntity appointmentEntity = appointmentMapper.domainToEntity(appointment);
      AppointmentEntity appointmentUpdated = jpaAppointmentRepository.save(appointmentEntity);

      return Optional.of(appointmentMapper.entityToDomain(appointmentUpdated));
    }
    return Optional.empty();
  }

  @Override
  public Appointment delete(Long id) {
    //TODO: Check if exists
    AppointmentEntity appointmentEntity = jpaAppointmentRepository.findById(id).get();
    jpaAppointmentRepository.deleteById(id);
    return appointmentMapper.entityToDomain(appointmentEntity);
  }
}
