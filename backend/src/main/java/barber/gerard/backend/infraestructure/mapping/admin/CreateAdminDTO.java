package barber.gerard.backend.infraestructure.mapping.admin;

import barber.gerard.backend.domain.models.Location;

import java.time.LocalDate;

public record CreateAdminDTO(
        String firstName,
        String lastName,
        String nid,
        String cellphoneNumber,
        LocalDate birthday,
        String email,
        //TODO: Ask if this is valid or create a DTO.
        Location managedLocation

) {
}
