package barber.gerard.backend.infraestructure.mapping.cutService;

import barber.gerard.backend.domain.models.CutService;
import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.infraestructure.entities.CutServiceEntity;
import barber.gerard.backend.infraestructure.entities.LocationEntity;
import barber.gerard.backend.infraestructure.mapping.address.CreateAddressDTO;
import barber.gerard.backend.infraestructure.mapping.location.UpdateLocationDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CutServiceMapper {
    CutService entityToDomain(CutServiceEntity cutService);
    CutServiceEntity domainToEntity(CutService cutService);
    CutService createCutServiceDTOToDomain(CreateCutServiceDTO createCutServiceDTO);
    List<CutService> entityListToDomainList(List<CutServiceEntity> cutServiceEntities);
    CutService updateCutServiceDTOToDomain(UpdateCutServiceDTO updateCutServiceDTO);
}
