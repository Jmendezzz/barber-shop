package barber.gerard.backend.infraestructure.mapping.location;

import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.infraestructure.entities.LocationEntity;

public interface LocationMapper {
  Location entityToDomain(LocationEntity location);
  LocationEntity domainToEntity(Location location);
  Location createLocationDTOToDomain(CreateLocationDTO location);
  Location updateLocationDTOToDomain(UpdateLocationDTO updateLocationDTO);

}
