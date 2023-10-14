package barber.gerard.backend.infraestructure.mapping.barber;

import barber.gerard.backend.infraestructure.mapping.location.LocationDTO;
import java.time.LocalDate;

public record PublicBarberInfoDTO(
        Long id,
        String firstName,
        String lastName,
        String cellphoneNumber,
        LocalDate birthday,
        Double rating,
        LocationDTO location
) {
}
