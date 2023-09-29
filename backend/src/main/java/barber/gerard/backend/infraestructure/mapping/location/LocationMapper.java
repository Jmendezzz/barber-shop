package barber.gerard.backend.infraestructure.mapping.location;

import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.infraestructure.entities.LocationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {
  @Mapping(target = "location.admins", ignore = true)
  Location entityToDomain(LocationEntity location);
  @Mapping(target = "location.admins", ignore = true)
  List<Location> entityListToDomainList(List<LocationEntity> locationEntities);
  @Mapping(target = "location.admins", ignore = true)
  LocationEntity domainToEntity(Location location);
  Location createLocationDTOToDomain(CreateLocationDTO location);
  Location updateLocationDTOToDomain(UpdateLocationDTO updateLocationDTO);
  LocationDTO entityToDTO(Location location);
  List<LocationDTO> entityListToDTOList(List<Location> locations);

}
