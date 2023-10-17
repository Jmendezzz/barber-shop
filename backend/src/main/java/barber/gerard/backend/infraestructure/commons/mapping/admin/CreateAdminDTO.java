package barber.gerard.backend.infraestructure.commons.mapping.admin;

import barber.gerard.backend.infraestructure.commons.mapping.location.LocationDTO;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateAdminDTO(

        @NotNull(message = "firstName is required")
        String firstName,
        @NotNull
        String lastName,
        @NotNull
        String nid,
        @NotNull
        String cellphoneNumber,
        @NotNull
        LocalDate birthday,
        @NotNull
        String email,
        LocationDTO managedLocation

) {
}
