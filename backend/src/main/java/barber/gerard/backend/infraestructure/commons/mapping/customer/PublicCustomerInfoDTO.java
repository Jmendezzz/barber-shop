package barber.gerard.backend.infraestructure.commons.mapping.customer;

import java.time.LocalDate;

public record PublicCustomerInfoDTO(
        Long id,
        String firstName,
        String lastName,
        String cellphoneNumber,
        LocalDate birthday,
        Integer points
) {
}
