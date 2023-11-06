package barber.gerard.backend.application.services;

import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.application.ports.in.services.LocationInputPort;
import barber.gerard.backend.application.ports.out.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocationService implements LocationInputPort {
  private LocationRepository locationRepository;
  @Override
  @CacheEvict(value = "locations", allEntries = true)
  public Location createLocation(Location location) {
    return locationRepository.save(location);
  }

  @Override
  @Cacheable("locations")
  public List<Location> getAllLocations() {
    return locationRepository.findAll();
  }

  @Override
  @Cacheable("locations")
  public List<Location> getPaginatedLocations(int page, int size) {
    return locationRepository.findPaginated(page,size);
  }


  @Override
  @Cacheable("locations")
  public Optional<Location> getLocationById(Long id) {
    return locationRepository.findById(id);
  }

  @Override
  @CacheEvict(value = "locations", allEntries = true)
  public Optional<Location> updateLocation(Location locationUpdated) {
    return locationRepository.update(locationUpdated);
  }

  @Override
  @CacheEvict(value = "locations", allEntries = true)
  public Location deleteLocationById(Long id) {
    return locationRepository.deleteById(id);
  }
}
