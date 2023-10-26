package barber.gerard.backend.application.ports.out;

import barber.gerard.backend.domain.models.Location;
import java.util.List;
import java.util.Optional;

public interface LocationRepository {
  Location save(Location location);
  Optional<Location> findById(Long id);
  List<Location> findAll();
  Optional<Location> update(Location locationUpdated);
  Location deleteById(Long id);
  Location assignEmplooyeLocation(Long locationId,Long employeeId);
  Optional<Location> findLocationByEmployeeId(Long employeeId);
  boolean removeEmployeeLocation(Long employeeId);
  void updateEmployeeLocation(Long employeeId, Long updatedLocationId);
}