package barber.gerard.backend.infraestructure.mapping.barber;

import barber.gerard.backend.domain.models.Location;

import java.time.LocalDate;

public record CreateBarberDTO(
        String firstName,
        String lastName,
        String nid,
        String cellphoneNumber,
        LocalDate birthday,
        String email,
        Location location,
        int yearsExperience

) {
}
