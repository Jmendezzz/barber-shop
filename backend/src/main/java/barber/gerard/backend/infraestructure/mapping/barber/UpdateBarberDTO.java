package barber.gerard.backend.infraestructure.mapping.barber;
import barber.gerard.backend.infraestructure.mapping.location.LocationDTO;

import java.time.LocalDate;

public record UpdateBarberDTO(
        Long id,
        String firstName,
        String lastName,
        String nid,
        String cellphoneNumber,
        LocalDate birthday,
        String email,
        String password,
        Double rating,
        LocationDTO location
) {
}
