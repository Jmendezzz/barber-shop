package barber.gerard.backend.infraestructure.ports.out;

import barber.gerard.backend.domain.models.Barber;

import java.util.List;
import java.util.Optional;

public interface BarberRepository {
    Barber save(Barber barber);
    Optional<Barber> findById(Long id);
    List<Barber> findAll();
    Optional<Barber> update(Barber barberUpdated);
    Barber deleteById(Long id);
}
