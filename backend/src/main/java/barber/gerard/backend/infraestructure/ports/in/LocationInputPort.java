package barber.gerard.backend.infraestructure.ports.in;

import barber.gerard.backend.domain.models.Location;

import java.util.List;

public interface LocationInputPort {
  Location createLocation(Location location);
  List<Location> getAllLocations();
  Location getLocationById(Long id);
  Location updateLocation(Location locationUpdated);
  Location deleteLocationById(Long id);
}
