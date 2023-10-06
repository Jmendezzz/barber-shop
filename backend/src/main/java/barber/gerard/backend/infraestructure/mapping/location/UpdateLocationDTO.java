package barber.gerard.backend.infraestructure.mapping.location;

import barber.gerard.backend.infraestructure.mapping.address.UpdateAddressDTO;
import barber.gerard.backend.infraestructure.mapping.admin.LocationRequestAdminDTO;

import java.util.List;

public record UpdateLocationDTO(
        Long id,
        String name,
        String description,
        List<LocationRequestAdminDTO> admins,
        UpdateAddressDTO address
) {
}
