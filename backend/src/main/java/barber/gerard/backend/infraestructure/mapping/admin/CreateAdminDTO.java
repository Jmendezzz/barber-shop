package barber.gerard.backend.infraestructure.mapping.admin;

import java.time.LocalDate;

public record CreateAdminDTO(
        String firstName,
        String lastName,
        String nid,
        String cellphoneNumber,
        LocalDate birthday,
        String email
        //TODO Location

) {
}
