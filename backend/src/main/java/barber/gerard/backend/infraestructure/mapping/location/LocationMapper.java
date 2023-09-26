package barber.gerard.backend.infraestructure.mapping.location;

import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.infraestructure.entities.LocationEntity;

import java.util.List;

public interface LocationMapper {
  Location entityToDomain(LocationEntity location);
  List<Location> entityListToDomainList(List<LocationEntity> locationEntities);
  LocationEntity domainToEntity(Location location);
  Location createLocationDTOToDomain(CreateLocationDTO location);
  Location updateLocationDTOToDomain(UpdateLocationDTO updateLocationDTO);

}
