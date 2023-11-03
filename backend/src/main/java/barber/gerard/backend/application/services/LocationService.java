package barber.gerard.backend.application.services;

import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.application.ports.in.services.LocationInputPort;
import barber.gerard.backend.application.ports.out.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocationService implements LocationInputPort {
  private LocationRepository locationRepository;
  @Override
  public Location createLocation(Location location) {
    return locationRepository.save(location);
  }

  @Override
  public List<Location> getAllLocations() {
    return locationRepository.findAll();
  }

  @Override
  public List<Location> getPaginatedLocations(int page, int size) {
    return locationRepository.findPaginated(page,size);
  }


  @Override
  public Optional<Location> getLocationById(Long id) {
    return locationRepository.findById(id);
  }

  @Override
  public Optional<Location> updateLocation(Location locationUpdated) {
    return locationRepository.update(locationUpdated);
  }

  @Override
  public Location deleteLocationById(Long id) {
    return locationRepository.deleteById(id);
  }
}
