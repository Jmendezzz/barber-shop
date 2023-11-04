package barber.gerard.backend.application.services;

import barber.gerard.backend.application.ports.in.constraints.LocationConstraint;
import barber.gerard.backend.domain.models.Barber;
import barber.gerard.backend.application.ports.in.services.BarberInputPort;
import barber.gerard.backend.application.ports.out.BarberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BarberService implements BarberInputPort {
    private BarberRepository barberRepository;
    private LocationConstraint locationConstraint;


    @Override
    public Barber createBarber(Barber barber) {
        locationConstraint.doesLocationExist(barber.getLocation().getId());

        return barberRepository.save(barber);
    }

    @Override
    public List<Barber> getAllBarbers() {
        return barberRepository.findAll();
    }

    @Override
    public List<Barber> getPaginatedBarbers(int page, int size) {
        return barberRepository.findPaginated(page,size);
    }

    @Override
    public Optional<Barber> getBarberById(Long id) {
        return barberRepository.findById(id);
    }

    @Override
    public Optional<Barber> updateBarber(Barber barberUpdated) {
        locationConstraint.doesLocationExist(barberUpdated.getLocation().getId());

        return barberRepository.update(barberUpdated);
    }

    @Override
    public Barber deleteBarberById(Long id) {
        return barberRepository.deleteById(id);
    }
}
