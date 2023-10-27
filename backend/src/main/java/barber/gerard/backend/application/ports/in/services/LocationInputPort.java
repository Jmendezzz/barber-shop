package barber.gerard.backend.application.ports.in.services;

import barber.gerard.backend.domain.models.Location;

import java.util.List;
import java.util.Optional;

public interface LocationInputPort {
  Location createLocation(Location location);
  List<Location> getAllLocations();
  Optional<Location> getLocationById(Long id);
  Optional<Location> updateLocation(Location locationUpdated);
  Location deleteLocationById(Long id);
}
