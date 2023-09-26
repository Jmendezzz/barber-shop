package barber.gerard.backend.application.services;

import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.infraestructure.ports.in.LocationInputPort;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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
  public Optional<Location> getLocationById(Long id) {
    return null;
  }

  @Override
  public Optional<Location> updateLocation(Location locationUpdated) {
    return Optional.empty();
  }

  @Override
  public Location deleteLocationById(Long id) {
    return null;
  }
}
