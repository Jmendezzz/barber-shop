package barber.gerard.backend.infraestructure.mapping.customer;

import barber.gerard.backend.domain.models.Location;

import java.time.LocalDate;

public record CreateCustomerDTO(
        String firstName,
        String lastName,
        String nid,
        String cellphoneNumber,
        LocalDate birthday,
        String email,
        Integer points
){}
