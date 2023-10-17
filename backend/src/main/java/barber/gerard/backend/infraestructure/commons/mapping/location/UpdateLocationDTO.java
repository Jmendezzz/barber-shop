package barber.gerard.backend.infraestructure.commons.mapping.location;

import barber.gerard.backend.infraestructure.commons.mapping.address.UpdateAddressDTO;
import barber.gerard.backend.infraestructure.commons.mapping.admin.LocationRequestAdminDTO;

import java.util.List;

public record UpdateLocationDTO(
        Long id,
        String name,
        String description,
        List<LocationRequestAdminDTO> admins,
        UpdateAddressDTO address
) {
}
