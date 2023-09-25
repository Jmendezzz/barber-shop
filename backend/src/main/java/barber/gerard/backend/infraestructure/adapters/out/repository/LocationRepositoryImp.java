package barber.gerard.backend.infraestructure.adapters.out.repository;

import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.infraestructure.entities.LocationEntity;
import barber.gerard.backend.infraestructure.ports.out.LocationRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class LocationRepositoryImp implements LocationRepository {
  //TODO: Mapper
  private JpaLocationRepository jpaLocationRepository;

  @Override
  public Location save(Location location) {
    return null;
  }

  @Override
  public Optional<Location> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public List<Location> findAll() {
    return null;
  }

  @Override
  public Location update(Location locationUpdated) {
    return null;
  }

  @Override
  public Location deleteById(Long id) {
    return null;
  }
}
