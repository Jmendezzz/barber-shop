package barber.gerard.backend.infraestructure.mapping.location;

import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.infraestructure.entities.LocationEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {
  Location entityToDomain(LocationEntity location);
  List<Location> entityListToDomainList(List<LocationEntity> locationEntities);
  LocationEntity domainToEntity(Location location);
  Location createLocationDTOToDomain(CreateLocationDTO location);
  Location updateLocationDTOToDomain(UpdateLocationDTO updateLocationDTO);

}
