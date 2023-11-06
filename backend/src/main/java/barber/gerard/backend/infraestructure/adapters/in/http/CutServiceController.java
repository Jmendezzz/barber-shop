package barber.gerard.backend.infraestructure.adapters.in.http;

import barber.gerard.backend.domain.models.CutService;
import barber.gerard.backend.infraestructure.commons.exceptions.CutServiceException;
import barber.gerard.backend.infraestructure.commons.mapping.cutService.CreateCutServiceDTO;
import barber.gerard.backend.infraestructure.commons.mapping.cutService.CutServiceMapper;
import barber.gerard.backend.infraestructure.commons.mapping.cutService.UpdateCutServiceDTO;
import barber.gerard.backend.application.ports.in.services.CutServiceInputPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static barber.gerard.backend.infraestructure.commons.exceptions.messages.CutServiceExceptionMessage.CUT_SERVICE_NOT_FOUND;

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
    public ResponseEntity<List<CutService>> getAllCutServices(@RequestParam Optional<Integer> page,
                                                              @RequestParam Optional<Integer> size){
        List<CutService> cutServices;
        if(page.isPresent() && size.isPresent()){
            cutServices = cutServiceInputPort.getAllCutServicesPaginated(page.get(), size.get());
        }

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
                .orElseThrow(()-> new CutServiceException(CUT_SERVICE_NOT_FOUND, HttpStatus.NOT_FOUND));

    }

    @PutMapping("/update")
    public ResponseEntity<CutService> updateCutService(@RequestBody UpdateCutServiceDTO updateCutServiceDTO){
        CutService cutServiceDomainUpdated = cutServiceMapper.updateCutServiceDTOToDomain((updateCutServiceDTO));
        Optional<CutService> cutServiceUpdated = cutServiceInputPort.updateCutService(cutServiceDomainUpdated);
        return cutServiceUpdated
                .map(loc -> new ResponseEntity<>(
                        loc,
                        HttpStatus.OK))
                .orElseThrow(()-> new CutServiceException(CUT_SERVICE_NOT_FOUND, HttpStatus.NOT_FOUND));
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
