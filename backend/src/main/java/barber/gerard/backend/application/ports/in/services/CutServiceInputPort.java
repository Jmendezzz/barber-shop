package barber.gerard.backend.application.ports.in.services;

import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.domain.models.CutService;

import java.util.List;
import java.util.Optional;

public interface CutServiceInputPort {
    CutService createCutService(CutService cutService);
    List<CutService> getAllCutServices();
    List<CutService> getAllCutServicesPaginated(int page, int size);
    Optional<CutService> getCutServiceById(Long id);
    Optional<CutService> updateCutService(CutService cutService);
    CutService deleteCutServiceById(Long id);

}
