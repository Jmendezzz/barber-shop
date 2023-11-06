package barber.gerard.backend.application.services;

import barber.gerard.backend.application.ports.in.constraints.LocationConstraint;
import barber.gerard.backend.application.ports.in.constraints.UserConstraint;
import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.domain.models.Barber;
import barber.gerard.backend.application.ports.in.services.BarberInputPort;
import barber.gerard.backend.application.ports.out.BarberRepository;
import barber.gerard.backend.infraestructure.commons.exceptions.UserException;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BarberService implements BarberInputPort {
    private BarberRepository barberRepository;
    private LocationConstraint locationConstraint;
    private UserConstraint userConstraint;

    @Override
    @CacheEvict(value = "barbers", allEntries = true)
    public Barber createBarber(Barber barber) {
        validateBarber(barber);
        return barberRepository.save(barber);
    }

    @Override
    @Cacheable("barbers")
    public List<Barber> getAllBarbers() {
        return barberRepository.findAll();
    }

    @Override
    @Cacheable("barbers")
    public List<Barber> getAllPaginatedBarbers(int page, int size) {
        return barberRepository.findPaginated(page,size);
    }

    @Override
    @Cacheable("barbers")
    public Optional<Barber> getBarberById(Long id) {
        return barberRepository.findById(id);
    }

    @Override
    @CacheEvict(value = "barbers", allEntries = true)
    public Optional<Barber> updateBarber(Barber barberUpdated) {
        validateBarber(barberUpdated);
        return barberRepository.update(barberUpdated);
    }

    @Override
    @CacheEvict(value = "barbers", allEntries = true)
    public Barber deleteBarberById(Long id) {
        return barberRepository.deleteById(id);
    }

    private void validateBarber(Barber barber) throws UserException {
        if(barber.getLocation() != null){
            locationConstraint.doesLocationExist(barber.getLocation().getId());
        }
        userConstraint.validateUserEmail(barber.getEmail());
        userConstraint.validateUserNid(barber.getNid());
        userConstraint.validateCellphone(barber.getCellphoneNumber());
    }
}
