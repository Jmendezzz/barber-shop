package barber.gerard.backend.infraestructure.mapping.location;

import barber.gerard.backend.infraestructure.mapping.admin.PublicAdminInfoDTO;

import java.util.List;

public record CreateLocationDTO(
        String name,
        String description,
        List<PublicAdminInfoDTO> admins


) {
}
