package barber.gerard.backend.infraestructure.mapping.customer;

import java.time.LocalDate;

public record CreateCustomerDTO(
        String firstName,
        String lastName,
        String cellphoneNumber,
        LocalDate birthday,
        String email
){}
