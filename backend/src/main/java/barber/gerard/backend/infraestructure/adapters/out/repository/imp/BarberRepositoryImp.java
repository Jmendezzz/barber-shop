package barber.gerard.backend.infraestructure.adapters.out.repository.imp;

import barber.gerard.backend.domain.enums.Role;
import barber.gerard.backend.domain.models.Barber;
import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.domain.models.User;
import barber.gerard.backend.infraestructure.mapping.barber.BarberMapper;
import barber.gerard.backend.infraestructure.ports.out.BarberRepository;
import barber.gerard.backend.infraestructure.ports.out.LocationRepository;
import barber.gerard.backend.infraestructure.ports.out.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@AllArgsConstructor
public class BarberRepositoryImp implements BarberRepository {
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
        if (userRepository.existsById(barberUpdated.getId())){
            Barber barber = userRepository.update(barberMapper.userToBarber(barberUpdated))
                                        .map(u->barberMapper.userToBarber(u))
                                        .get();
            updateBarberLocation(barberUpdated);
            updateBarberRating(barberUpdated);

            barber.setLocation(getBarberLocation(barber));
            barber.setRating(getBarberRating(barber.getId()));

            return Optional.of(barber);
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Barber deleteById(Long id) {
        locationRepository.removeEmployeeLocation(id);
        deleteBarberRating(id);
        userRepository.deleteById(id);

        //TODO: Return Barber.
        return null;
    }

    private void updateBarberLocation(Barber barber){
        if(barber.getLocation() != null){
            locationRepository.updateEmployeeLocation(barber.getId(),barber.getLocation().getId());
        }else {
            locationRepository.removeEmployeeLocation(barber.getId());
        }
    }
    private void saveBarberRating(Barber barber){
        entityManager.createNativeQuery("INSERT INTO barber_rating(barber_id,rating) VALUES(?,?)")
                                         .setParameter(1,barber.getId())
                                         .setParameter(2,barber.getRating())
                                         .executeUpdate();
    }
    private void deleteBarberRating(Long barberId){
        entityManager.createNativeQuery("DELETE FROM barber_rating WHERE barber_id = ?")
                                        .setParameter(1,barberId)
                                        .executeUpdate();
    }
    private void updateBarberRating(Barber barber){
        deleteBarberRating(barber.getId());
        saveBarberRating(barber);
    }

    private Location getBarberLocation(Barber barber){
        Optional<Location> adminManagedLocation = locationRepository.findLocationByEmployeeId(barber.getId());
        return adminManagedLocation.orElse(null);
    }

    private Double getBarberRating(Long barberId){
        try {
            return (Double) entityManager.createNativeQuery("SELECT rating FROM barber_rating WHERE barber_id = ?")
                    .setParameter(1,barberId)
                    .getSingleResult();
        }catch (NoResultException ex){
            return null;
        }

    }
}
