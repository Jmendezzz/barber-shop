package barber.gerard.backend.application.services;

import barber.gerard.backend.domain.models.CutService;
import barber.gerard.backend.application.ports.in.services.CutServiceInputPort;
import barber.gerard.backend.application.ports.out.CutServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CutServiceService implements CutServiceInputPort {
    private CutServiceRepository cutServiceRepository;
    @Override
    @CacheEvict(value = "cutServices", allEntries = true)
    public CutService createCutService(CutService cutService) {return cutServiceRepository.save(cutService);}

    @Override
    @Cacheable("cutServices")
    public List<CutService> getAllCutServices() {return cutServiceRepository.findAll();}

    @Override
    @Cacheable("cutServices")
    public List<CutService> getAllCutServicesPaginated(int page, int size) {
        return cutServiceRepository.findPaginated(page,size);
    }

    @Override
    @Cacheable("cutServices")
    public Optional<CutService> getCutServiceById(Long id) {return cutServiceRepository.findById(id);}

    @Override
    @CacheEvict(value = "cutServices", allEntries = true)
    public Optional<CutService> updateCutService(CutService cutService) {return cutServiceRepository.update(cutService);}

    @Override
    @CacheEvict(value = "cutServices", allEntries = true)
    public CutService deleteCutServiceById(Long id) {return cutServiceRepository.deleteById(id);}
}
