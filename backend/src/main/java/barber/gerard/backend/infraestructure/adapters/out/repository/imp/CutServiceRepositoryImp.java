package barber.gerard.backend.infraestructure.adapters.out.repository.imp;

import barber.gerard.backend.domain.models.CutService;
import barber.gerard.backend.infraestructure.adapters.out.repository.JpaCutServiceRepository;
import barber.gerard.backend.infraestructure.entities.AdminEntity;
import barber.gerard.backend.infraestructure.entities.CutServiceEntity;
import barber.gerard.backend.infraestructure.entities.LocationEntity;
import barber.gerard.backend.infraestructure.mapping.cutService.CutServiceMapper;
import barber.gerard.backend.infraestructure.ports.out.CutServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CutServiceRepositoryImp implements CutServiceRepository {
    private JpaCutServiceRepository jpaCutServiceRepository;
    private CutServiceMapper cutServiceMapper;
    @Override
    public CutService save(CutService cutService) {
        CutServiceEntity cutServiceEntity = cutServiceMapper.domainToEntity(cutService);
        CutServiceEntity entitySaved =  jpaCutServiceRepository.save(cutServiceEntity);
        return cutServiceMapper.entityToDomain(entitySaved);
    }

    @Override
    public Optional<CutService> findById(Long id) {
        Optional<CutServiceEntity> cutServiceEntity = jpaCutServiceRepository.findById(id);

        return cutServiceEntity
                .map(cut-> cutServiceMapper.entityToDomain(cut));
    }

    @Override
    public List<CutService> findAll() {
        return cutServiceMapper.entityListToDomainList(jpaCutServiceRepository.findAll());
    }

    @Override
    public Optional<CutService> update(CutService cutServiceUpdated) {
        if(jpaCutServiceRepository.existsById(cutServiceUpdated.getId())){
            CutServiceEntity cutServiceEntity = cutServiceMapper.domainToEntity(cutServiceUpdated);
            CutServiceEntity entityUpdated = jpaCutServiceRepository.save(cutServiceEntity);
            return Optional.of(cutServiceMapper.entityToDomain(entityUpdated));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public CutService deleteById(Long id) {
        Optional<CutServiceEntity> cutService =  jpaCutServiceRepository.findById(id);
        //TODO: Handle exception.
        return cutService
                .map(cut -> cutServiceMapper.entityToDomain(cut))
                .orElseThrow(()-> new RuntimeException());

    }


}
