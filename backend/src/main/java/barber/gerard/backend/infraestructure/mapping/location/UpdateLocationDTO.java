package barber.gerard.backend.infraestructure.mapping.location;

import barber.gerard.backend.infraestructure.mapping.address.CreateAddressDTO;
import barber.gerard.backend.infraestructure.mapping.admin.PublicAdminInfoDTO;

import java.util.List;

public record UpdateLocationDTO(
        Long id,
        String name,
        String description,
        List<PublicAdminInfoDTO> admins,
        CreateAddressDTO address
) {
}