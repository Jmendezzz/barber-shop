package barber.gerard.backend.infraestructure.adapters.in.http;

import barber.gerard.backend.domain.models.Barber;
import barber.gerard.backend.infraestructure.commons.exceptions.BarberException;
import barber.gerard.backend.infraestructure.commons.mapping.barber.BarberMapper;
import barber.gerard.backend.infraestructure.commons.mapping.barber.CreateBarberDTO;
import barber.gerard.backend.infraestructure.commons.mapping.barber.PublicBarberInfoDTO;
import barber.gerard.backend.infraestructure.commons.mapping.barber.UpdateBarberDTO;
import barber.gerard.backend.infraestructure.commons.validator.ObjectValidator;
import barber.gerard.backend.application.ports.in.BarberInputPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static barber.gerard.backend.infraestructure.commons.exceptions.messages.BarberExceptionMessage.BARBER_NOT_FOUND;

@RestController
@AllArgsConstructor
@RequestMapping("/barbers")
public class BarberController {
    private BarberInputPort barberInputPort;
    private BarberMapper barberMapper;
    private ObjectValidator objectValidator;

    @PostMapping("/create")
    public ResponseEntity<PublicBarberInfoDTO> createBarber(@RequestBody CreateBarberDTO createBarberDTO){
        objectValidator.validate(createBarberDTO);

        Barber barberDomain = barberMapper.createBarberDTOToDomain(createBarberDTO);
        Barber barberCreated = barberInputPort.createBarber(barberDomain);

        return new ResponseEntity<>(
                barberMapper.domainToPublicBarberInfoDTO(barberCreated),
                HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<PublicBarberInfoDTO>> getAllBarbers(){
        List<PublicBarberInfoDTO> barbers = barberMapper.domainListToPublicBarberInfoDTOList(barberInputPort.getAllBarbers());
        return new ResponseEntity<>(
                barbers,
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicBarberInfoDTO> getBarberById(@PathVariable Long id){
        return barberInputPort.getBarberById(id)
                .map(barber -> new ResponseEntity<>(
                        barberMapper.domainToPublicBarberInfoDTO(barber),
                        HttpStatus.OK))
                .orElseThrow(()-> new BarberException(BARBER_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update")
    public ResponseEntity<PublicBarberInfoDTO> updateBarber(@RequestBody UpdateBarberDTO updateBarberDTO){
        objectValidator.validate(updateBarberDTO);

        Barber barberDomainUpdated = barberMapper.updateBarberDTOToDomain(updateBarberDTO);

        return barberInputPort.updateBarber(barberDomainUpdated)
                .map(barber -> new ResponseEntity<>(
                        barberMapper.domainToPublicBarberInfoDTO(barber),
                        HttpStatus.OK))
                .orElseThrow(()-> new BarberException(BARBER_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PublicBarberInfoDTO> deleteBarberById(@PathVariable Long id){
        Barber barberDeleted = barberInputPort.deleteBarberById(id);
        return new ResponseEntity<>(
                barberMapper.domainToPublicBarberInfoDTO(barberDeleted),
                HttpStatus.OK);
    }

}
