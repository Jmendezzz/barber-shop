package barber.gerard.backend.infraestructure.commons.mapping.location;

import barber.gerard.backend.infraestructure.commons.mapping.address.CreateAddressDTO;
import barber.gerard.backend.infraestructure.commons.mapping.admin.PublicAdminInfoDTO;

import java.util.List;

public record CreateLocationDTO(
        String name,
        String description,
        List<PublicAdminInfoDTO> admins,
        CreateAddressDTO address
) {
}
