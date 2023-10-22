package barber.gerard.backend.infraestructure.adapters.in.http;

import barber.gerard.backend.domain.models.Appointment;
import barber.gerard.backend.infraestructure.commons.exceptions.AppointmentException;
import barber.gerard.backend.infraestructure.commons.mapping.appointment.AppointmentDTO;
import barber.gerard.backend.infraestructure.commons.mapping.appointment.AppointmentMapper;
import barber.gerard.backend.infraestructure.commons.mapping.appointment.CreateAppointmentDTO;
import barber.gerard.backend.infraestructure.commons.mapping.appointment.UpdateAppointmentDTO;
import barber.gerard.backend.infraestructure.ports.in.AppointmentInputPort;
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
  @PostMapping("/create")
  public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody CreateAppointmentDTO createAppointmentDTO){
    System.out.println(createAppointmentDTO);
    Appointment appointment = appointmentMapper.createAppointmentDTOToDomain(createAppointmentDTO);
    System.out.println(appointment);
    Appointment appointmentCreated = appointmentInputPort.createAppointment(appointment);

    return new ResponseEntity<>(
            appointmentMapper.domainToAppointmentDTO(appointmentCreated),
            HttpStatus.CREATED
    );
  }
  @GetMapping("")
  public ResponseEntity<List<AppointmentDTO>> getAllAppointments(){
    List<Appointment> appointments = appointmentInputPort.getAllAppointments();

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
}
