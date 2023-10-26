package barber.gerard.backend.application.services;

import barber.gerard.backend.domain.models.Barber;
import barber.gerard.backend.application.ports.in.BarberInputPort;
import barber.gerard.backend.application.ports.out.BarberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BarberService implements BarberInputPort {
    private BarberRepository barberRepository;

    @Override
    public Barber createBarber(Barber barber) {
        return barberRepository.save(barber);
    }

    @Override
    public List<Barber> getAllBarbers() {
        return barberRepository.findAll();
    }

    @Override
    public Optional<Barber> getBarberById(Long id) {
        return barberRepository.findById(id);
    }

    @Override
    public Optional<Barber> updateBarber(Barber barberUpdated) {
        return barberRepository.update(barberUpdated);
    }

    @Override
    public Barber deleteBarberById(Long id) {
        return barberRepository.deleteById(id);
    }
}
