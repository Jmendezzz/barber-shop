package barber.gerard.backend.application.ports.out;

import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.domain.models.CutService;

import java.util.List;
import java.util.Optional;

public interface CutServiceRepository {
    CutService save(CutService cutService);
    Optional<CutService> findById(Long id);
    List<CutService> findAll();
    Optional<CutService> update(CutService cutService);
    CutService deleteById(Long id);
}
