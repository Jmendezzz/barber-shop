package barber.gerard.backend.infraestructure.adapters.out.repository.imp;

import barber.gerard.backend.domain.enums.Role;
import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.domain.models.Barber;
import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.domain.models.User;
import barber.gerard.backend.infraestructure.adapters.out.repository.JpaBarberRepository;
import barber.gerard.backend.infraestructure.entities.BarberEntity;
import barber.gerard.backend.infraestructure.mapping.barber.BarberMapper;
import barber.gerard.backend.infraestructure.ports.out.BarberRepository;
import barber.gerard.backend.infraestructure.ports.out.LocationRepository;
import barber.gerard.backend.infraestructure.ports.out.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@AllArgsConstructor
public class BarberRepositoryImp implements BarberRepository {
    private JpaBarberRepository jpaBarberRepository;
    private BarberMapper barberMapper;
    private UserRepository userRepository;
    private LocationRepository locationRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Barber save(Barber barber) {
        Barber barberSaved = barberMapper.userToBarber(userRepository.save(barber));
        barberSaved.setRating(barber.getRating());
        saveBarberRating(barberSaved);

        if(barber.getLocation() != null){
            Location location = locationRepository.assignEmplooyeLocation(barber.getLocation().getId(),barberSaved.getId());
            barberSaved.setLocation(location);
        }
        return barberSaved;
    }

    @Override
    public Optional<Barber> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            Barber barber = barberMapper.userToBarber(user.get());
            barber.setLocation(getBarberLocation(barber));
            barber.setRating(getBarberRating(barber.getId()));
            return Optional.of(barber);
        }else {
            return Optional.empty();
        }
    }

    @Override
    public List<Barber> findAll() {
        List<Barber> barbers = barberMapper.usertListToBarberList(userRepository.findByRole(Role.BARBER));
        barbers.parallelStream()
                .forEach(barber ->{
                    barber.setLocation(getBarberLocation(barber));
                    barber.setRating(getBarberRating(barber.getId()));
                }
        );
        return barbers;
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

    private void saveBarberRating(Barber barber){
        entityManager.createNativeQuery("INSERT INTO barber_rating(barber_id,rating) VALUES(?,?)")
                     .setParameter(1,barber.getId())
                     .setParameter(2,barber.getRating())
                     .executeUpdate();
    }
    private Location getBarberLocation(Barber barber){
        Optional<Location> adminManagedLocation = locationRepository.findLocationByEmployeeId(barber.getId());
        return adminManagedLocation.orElse(null);
    }

    private Double getBarberRating(Long barberId){
        return (Double) entityManager.createNativeQuery("SELECT rating FROM barber_rating WHERE barber_id = ?")
                                     .setParameter(1,barberId)
                                     .getSingleResult();
    }
}
