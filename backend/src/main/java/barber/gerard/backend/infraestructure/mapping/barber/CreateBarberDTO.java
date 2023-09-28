package barber.gerard.backend.infraestructure.mapping.barber;

import barber.gerard.backend.domain.models.Location;

import java.time.LocalDate;

public record CreateBarberDTO(
        String firstName,
        String lastName,
        //TODO: NID???
        String cellphoneNumber,
        LocalDate birthday,
        String email,
        Location managedLocation

) {
}
