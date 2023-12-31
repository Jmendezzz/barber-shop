package barber.gerard.backend.infraestructure.adapters.in.http;

import barber.gerard.backend.domain.models.Appointment;
import barber.gerard.backend.infraestructure.commons.exceptions.AppointmentException;
import barber.gerard.backend.infraestructure.commons.mapping.appointment.AppointmentDTO;
import barber.gerard.backend.infraestructure.commons.mapping.appointment.AppointmentMapper;
import barber.gerard.backend.infraestructure.commons.mapping.appointment.CreateAppointmentDTO;
import barber.gerard.backend.infraestructure.commons.mapping.appointment.UpdateAppointmentDTO;
import barber.gerard.backend.infraestructure.commons.validator.ObjectValidator;
import barber.gerard.backend.application.ports.in.services.AppointmentInputPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import static barber.gerard.backend.infraestructure.commons.exceptions.messages.AppointmentExceptionMessage.APPOINTMENT_NOT_FOUND;

@RestController
@AllArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {
  private AppointmentInputPort appointmentInputPort;
  private AppointmentMapper appointmentMapper;
  private ObjectValidator objectValidator;
  @PostMapping("/create")
  public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody CreateAppointmentDTO createAppointmentDTO){
    objectValidator.validate(createAppointmentDTO);
    Appointment appointment = appointmentMapper.createAppointmentDTOToDomain(createAppointmentDTO);
    Appointment appointmentCreated = appointmentInputPort.createAppointment(appointment);

    return new ResponseEntity<>(
            appointmentMapper.domainToAppointmentDTO(appointmentCreated),
            HttpStatus.CREATED
    );
  }
  @GetMapping("")
  public ResponseEntity<List<AppointmentDTO>> getAllAppointments(@RequestParam Optional<Integer> page,
                                                                 @RequestParam Optional<Integer> size){
    List<Appointment> appointments;

    if(page.isPresent() && size.isPresent()){
      appointments = appointmentInputPort.getPaginatedAppointments(page.get(), size.get());
    }else{
      appointments = appointmentInputPort.getAllAppointments();
    }

    return new ResponseEntity<>(
            appointmentMapper.domainListToAppointmentDTOList(appointments),
            HttpStatus.OK
    );
  }
  @GetMapping("/{id}")
  public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable Long id){
    Optional<Appointment> appointment = appointmentInputPort.getAppointmentById(id);

    return appointment.map(app -> new ResponseEntity<>(
                                    appointmentMapper.domainToAppointmentDTO(app),
                                    HttpStatus.OK))
            .orElseThrow(()-> new AppointmentException(APPOINTMENT_NOT_FOUND,HttpStatus.NOT_FOUND));
  }
  @PutMapping("/update")
  public ResponseEntity<AppointmentDTO> updateAppointment(@RequestBody UpdateAppointmentDTO updateAppointmentDTO){
    objectValidator.validate(updateAppointmentDTO);
     
    Appointment appointmentDomainUpdated = appointmentMapper.updateAppointmentDTOToDomain(updateAppointmentDTO);
    Optional<Appointment> appointment = appointmentInputPort.updateAppointment(appointmentDomainUpdated);

    return appointment.map(app-> new ResponseEntity<>(
                                    appointmentMapper.domainToAppointmentDTO(app),
                                    HttpStatus.OK))
            .orElseThrow(()-> new AppointmentException(APPOINTMENT_NOT_FOUND,HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("delete/{id}")
  public ResponseEntity<AppointmentDTO> deleteAppointmentById(@PathVariable Long id){
    Appointment appointmentDeleted = appointmentInputPort.deleteAppointmentById(id);

    return new ResponseEntity<>(
            appointmentMapper.domainToAppointmentDTO(appointmentDeleted),
            HttpStatus.OK
    );
  }

  @PostMapping("/accept")
  public ResponseEntity<AppointmentDTO> acceptAppointment(@RequestBody AppointmentDTO appointmentDTO){
    Appointment appointment = appointmentMapper.appointmentDTOToDomain(appointmentDTO);
    Appointment appointmentAccepted = appointmentInputPort.acceptAppointment(appointment);

    return new ResponseEntity<>(
            appointmentMapper.domainToAppointmentDTO(appointmentAccepted),
            HttpStatus.OK
    );
  }
  @PostMapping("/reject")
  public ResponseEntity<AppointmentDTO> rejectAppointment(@RequestBody AppointmentDTO appointmentDTO){
    Appointment appointment = appointmentMapper.appointmentDTOToDomain(appointmentDTO);
    Appointment appointmentRejected = appointmentInputPort.rejectAppointment(appointment);

    return new ResponseEntity<>(
            appointmentMapper.domainToAppointmentDTO(appointmentRejected),
            HttpStatus.OK
    );
  }
}
