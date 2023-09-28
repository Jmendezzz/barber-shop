package barber.gerard.backend.infraestructure.adapters.out.repository;

import barber.gerard.backend.domain.models.Barber;
import barber.gerard.backend.infraestructure.entities.BarberEntity;
import barber.gerard.backend.infraestructure.mapping.barber.BarberMapper;
import barber.gerard.backend.infraestructure.ports.out.BarberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class BarberRepositoryImpl implements BarberRepository {
    private JpaBarberRepository jpaBarberRepository;
    private BarberMapper barberMapper;

    @Override
    public Barber save(Barber barber) {
        BarberEntity barberEntity = barberMapper.domainToEntity(barber);
        BarberEntity entitySaved =  jpaBarberRepository.save(barberEntity);
        return barberMapper.entityToDomain(entitySaved);
    }

    @Override
    public Optional<Barber> findById(Long id) {
        Optional<BarberEntity> barberEntity = jpaBarberRepository.findById(id);
        return barberEntity.map(barber -> barberMapper.entityToDomain(barber));
    }

    @Override
    public List<Barber> findAll() {
        return barberMapper.entityListToDomainList(jpaBarberRepository.findAll());
    }

    @Override
    public Optional<Barber> update(Barber barberUpdated) {
        if (jpaBarberRepository.existsById(barberUpdated.getId())){
            BarberEntity barberEntity = barberMapper.domainToEntity(barberUpdated);
            BarberEntity entityUpdated = jpaBarberRepository.save(barberEntity);
            return Optional.of(barberMapper.entityToDomain(entityUpdated));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Barber deleteById(Long id) {
        Optional<BarberEntity> barber = jpaBarberRepository.findById(id);
        return barber.map(barb -> barberMapper.entityToDomain(barb))
                .orElseThrow(() -> new RuntimeException());
    }
}
