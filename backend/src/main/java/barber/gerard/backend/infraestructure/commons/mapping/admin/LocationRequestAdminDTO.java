package barber.gerard.backend.infraestructure.commons.mapping.admin;

import barber.gerard.backend.domain.enums.Role;

import java.time.LocalDate;

public record LocationRequestAdminDTO(
        Long id,
        String firstName,
        String lastName,
        String nid,
        String cellphoneNumber,
        LocalDate birthday,
        Role role
) {
}
