package barber.gerard.backend.application.ports.in;

import barber.gerard.backend.domain.models.Barber;

import java.util.List;
import java.util.Optional;

public interface BarberInputPort {
    Barber createBarber(Barber barber);
    List<Barber> getAllBarbers();
    Optional<Barber> getBarberById(Long id);
    Optional<Barber> updateBarber(Barber barberUpdated);
    Barber deleteBarberById(Long id);
}
