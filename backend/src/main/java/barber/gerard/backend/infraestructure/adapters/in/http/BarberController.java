package barber.gerard.backend.infraestructure.adapters.in.http;

import barber.gerard.backend.domain.models.Barber;
import barber.gerard.backend.infraestructure.mapping.barber.BarberMapper;
import barber.gerard.backend.infraestructure.mapping.barber.CreateBarberDTO;
import barber.gerard.backend.infraestructure.mapping.barber.PublicBarberInfoDTO;
import barber.gerard.backend.infraestructure.mapping.barber.UpdateBarberDTO;
import barber.gerard.backend.infraestructure.ports.in.BarberInputPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/barbers")
public class BarberController {
    private BarberInputPort barberInputPort;
    private BarberMapper barberMapper;

    @PostMapping("/create")
    public ResponseEntity<PublicBarberInfoDTO> createBarber(@RequestBody CreateBarberDTO createBarberDTO){
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
                .orElseThrow(()-> new RuntimeException("No se encontró el BARBER"));
    }

    @PutMapping("/update")
    public ResponseEntity<PublicBarberInfoDTO> updateBarber(@RequestBody UpdateBarberDTO updateBarberDTO){
        Barber barberDomainUpdated = barberMapper.updateBarberDTOToDomain(updateBarberDTO);
        return barberInputPort.updateBarber(barberDomainUpdated)
                .map(barber -> new ResponseEntity<>(
                        barberMapper.domainToPublicBarberInfoDTO(barber),
                        HttpStatus.OK))
                .orElseThrow(()-> new RuntimeException("No se encontró el BARBER"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PublicBarberInfoDTO> deleteBarberById(@PathVariable Long id){
        Barber barberDeleted = barberInputPort.deleteBarberById(id);
        return new ResponseEntity<>(
                barberMapper.domainToPublicBarberInfoDTO(barberDeleted),
                HttpStatus.OK);
    }

}
