package barber.gerard.backend.infraestructure.commons.mapping.appointment;

import barber.gerard.backend.domain.enums.Status;
import barber.gerard.backend.domain.models.Appointment;
import barber.gerard.backend.infraestructure.entities.AppointmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
  Appointment entityToDomain(AppointmentEntity appointmentEntity);
  AppointmentEntity domainToEntity(Appointment appointment);
  List<Appointment> entityListToDomainList(List<AppointmentEntity> appointmentEntities);

  @Mapping(target = "status", expression = "java(setBookedStatus())")
  Appointment createAppointmentDTOToDomain(CreateAppointmentDTO createAppointmentDTO);

  default Status setBookedStatus(){
    return Status.BOOKED;
  }
}
