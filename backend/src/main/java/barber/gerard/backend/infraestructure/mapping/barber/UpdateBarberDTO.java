package barber.gerard.backend.infraestructure.mapping.barber;

import barber.gerard.backend.domain.models.Location;

public record UpdateBarberDTO(
        Long id,
        String firstName,
        String lastName,
        String cellphoneNumber,
        String email,
        Location managedLocation
) {
}
