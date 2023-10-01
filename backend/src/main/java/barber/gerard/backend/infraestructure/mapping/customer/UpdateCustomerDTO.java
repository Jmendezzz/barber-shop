package barber.gerard.backend.infraestructure.mapping.customer;

import java.time.LocalDate;

public record UpdateCustomerDTO(
        Long id,
        String firstName,
        String lastName,
        String nid,
        String cellphoneNumber,
        LocalDate birthday,
        String email,
        String password
) {
}
