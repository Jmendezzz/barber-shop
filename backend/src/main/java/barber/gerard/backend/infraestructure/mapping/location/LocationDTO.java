package barber.gerard.backend.infraestructure.mapping.location;

import barber.gerard.backend.domain.models.Address;
import barber.gerard.backend.infraestructure.mapping.admin.LocationRequestAdminDTO;

import java.util.List;

public record LocationDTO(
        Long id,
        String name,
        String description,
        List<LocationRequestAdminDTO> admins,
        Address address

) {
}
