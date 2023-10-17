package barber.gerard.backend.infraestructure.adapters.in.http;

import barber.gerard.backend.domain.models.CutService;
import barber.gerard.backend.infraestructure.commons.mapping.cutService.CreateCutServiceDTO;
import barber.gerard.backend.infraestructure.commons.mapping.cutService.CutServiceMapper;
import barber.gerard.backend.infraestructure.commons.mapping.cutService.UpdateCutServiceDTO;
import barber.gerard.backend.infraestructure.ports.in.CutServiceInputPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/cut-services")
public class CutServiceController {
    private CutServiceInputPort cutServiceInputPort;
    private CutServiceMapper cutServiceMapper;
    @PostMapping("/create")
    public ResponseEntity<CutService> createCutService(@RequestBody CreateCutServiceDTO createCutServiceDTO){
        CutService cutService = cutServiceMapper.createCutServiceDTOToDomain(createCutServiceDTO);
        CutService cutServiceCreated = cutServiceInputPort.createCutService(cutService);
        return new ResponseEntity<>(
                cutServiceCreated,
                HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<CutService>> getAllCutServices(){
        return new ResponseEntity<>(
                cutServiceInputPort.getAllCutServices(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CutService> getCutServiceById(@PathVariable Long id){
        Optional<CutService> cutService = cutServiceInputPort.getCutServiceById((id));
        return cutService
                .map(cut -> new ResponseEntity<>(
                        cut,
                        HttpStatus.OK))
                .orElseThrow(()-> new RuntimeException("No se encontró el servicio de corte"));

    }

    @PutMapping("/update")
    public ResponseEntity<CutService> updateCutService(@RequestBody UpdateCutServiceDTO updateCutServiceDTO){
        CutService cutServiceDomainUpdated = cutServiceMapper.updateCutServiceDTOToDomain((updateCutServiceDTO));
        Optional<CutService> cutServiceUpdated = cutServiceInputPort.updateCutService(cutServiceDomainUpdated);
        return cutServiceUpdated
                .map(loc -> new ResponseEntity<>(
                        loc,
                        HttpStatus.OK))
                .orElseThrow(()-> new RuntimeException("No se encontró la servicio de corte"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CutService> deleteCutService(@PathVariable Long id){
        CutService cutServiceDeleted = cutServiceInputPort.deleteCutServiceById((id));
        return new ResponseEntity<>(
                cutServiceDeleted,
                HttpStatus.OK
        );
    }
}
