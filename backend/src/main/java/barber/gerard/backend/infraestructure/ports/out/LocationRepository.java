package barber.gerard.backend.infraestructure.ports.out;

import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.domain.models.Location;

import java.util.List;
import java.util.Optional;

public interface LocationRepository {
  Location save(Location admin);
  Optional<Location> findById(Long id);
  List<Location> findAll();
  Location update(Location locationUpdated);
  Location deleteById(Long id);
}
