package barber.gerard.backend.infraestructure.commons.mapping.admin;

import barber.gerard.backend.domain.enums.Role;
import barber.gerard.backend.infraestructure.commons.mapping.location.AdminRequestLocationDTO;

import java.time.LocalDate;

public record PublicAdminInfoDTO(
        Long id,
        String firstName,
        String lastName,
        String nid,
        String cellphoneNumber,
        LocalDate birthday,
        Role role,
        AdminRequestLocationDTO managedLocation
) {
}
