package barber.gerard.backend.infraestructure.adapters.in.http;

import barber.gerard.backend.domain.models.Appointment;
import barber.gerard.backend.infraestructure.commons.mapping.appointment.AppointmentMapper;
import barber.gerard.backend.infraestructure.commons.mapping.appointment.CreateAppointmentDTO;
import barber.gerard.backend.infraestructure.commons.mapping.appointment.UpdateAppointmentDTO;
import barber.gerard.backend.infraestructure.ports.in.AppointmentInputPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/appointments")
public class AppointmentController {

  private AppointmentInputPort appointmentInputPort;
  private AppointmentMapper appointmentMapper;
  @PostMapping("/create")
  public ResponseEntity<Appointment> createAppointment(CreateAppointmentDTO createAppointmentDTO){
    Appointment appointment = appointmentMapper.createAppointmentDTOToDomain(createAppointmentDTO);
    Appointment appointmentCreated = appointmentInputPort.createAppointment(appointment);

    return new ResponseEntity<>(
            appointmentCreated,
            HttpStatus.CREATED);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id){
    Optional<Appointment> appointment = appointmentInputPort.getAppointmentById(id);

    return appointment.map(app -> new ResponseEntity<>(
                                    app,
                                    HttpStatus.OK))
            .orElseThrow(()-> new RuntimeException("No se encontró el APPOINTMENT"));
  }
  @PutMapping("/update")
  public ResponseEntity<Appointment> updateAppointment(@RequestBody UpdateAppointmentDTO updateAppointmentDTO){
    Appointment appointmentDomainUpdated = appointmentMapper.updateAppointmentDTOToDomain(updateAppointmentDTO);
    Optional<Appointment> appointment = appointmentInputPort.updateAppointment(appointmentDomainUpdated);

    return appointment.map(app-> new ResponseEntity<>(
                                    app,
                                    HttpStatus.OK))
            .orElseThrow(()-> new RuntimeException("No se encontró el APPOINTMENT"));
  }

  @DeleteMapping("delete/{id}")
  public ResponseEntity<Appointment> deleteAppointmentById(@PathVariable Long id){
    Appointment appointmentDeleted = appointmentInputPort.deleteAppointmentById(id);

    return new ResponseEntity<>(
            appointmentDeleted,
            HttpStatus.OK
    );
  }
}
