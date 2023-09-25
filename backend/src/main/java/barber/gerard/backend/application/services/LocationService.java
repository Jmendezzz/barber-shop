package barber.gerard.backend.application.services;

import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.infraestructure.ports.in.LocationInputPort;

import java.util.List;

public class LocationService implements LocationInputPort {
  @Override
  public Location createLocation(Location location) {
    return null;
  }

  @Override
  public List<Location> getAllLocations() {
    return null;
  }

  @Override
  public Location getLocationById(Long id) {
    return null;
  }

  @Override
  public Location updateLocation(Location locationUpdated) {
    return null;
  }

  @Override
  public Location deleteLocationById(Long id) {
    return null;
  }
}
