package barber.gerard.backend.infraestructure.commons.mapping.location;

import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.infraestructure.entities.LocationEntity;
import barber.gerard.backend.infraestructure.commons.mapping.config.CycleAvoidingMappingContext;
import org.mapstruct.Context;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {
  Location entityToDomain(LocationEntity location,
                          @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
  List<Location> entityListToDomainList(List<LocationEntity> locationEntities,
                                        @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
  LocationEntity domainToEntity(Location locatio,
                                @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
  Location createLocationDTOToDomain(CreateLocationDTO location);
  Location updateLocationDTOToDomain(UpdateLocationDTO updateLocationDTO);
  LocationDTO entityToDTO(Location location);
  List<LocationDTO> entityListToDTOList(List<Location> locations);

}
