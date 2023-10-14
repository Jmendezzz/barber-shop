package barber.gerard.backend.infraestructure.adapters.out.repository.imp;

import barber.gerard.backend.domain.models.Barber;
import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.infraestructure.adapters.out.repository.JpaBarberRepository;
import barber.gerard.backend.infraestructure.entities.BarberEntity;
import barber.gerard.backend.infraestructure.mapping.barber.BarberMapper;
import barber.gerard.backend.infraestructure.ports.out.BarberRepository;
import barber.gerard.backend.infraestructure.ports.out.LocationRepository;
import barber.gerard.backend.infraestructure.ports.out.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class BarberRepositoryImp implements BarberRepository {
    private JpaBarberRepository jpaBarberRepository;
    private BarberMapper barberMapper;
    private UserRepository userRepository;
    private LocationRepository locationRepository;

    @Override
    public Barber save(Barber barber) {
        Barber barberSaved = barberMapper.userToBarber(userRepository.save(barber));
        if(barber.getLocation() != null){
            Location location = locationRepository.assignEmplooyeLocation(barber.getLocation().getId(),barberSaved.getId());
            barberSaved.setLocation(location);
        }
        return barberSaved;
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
