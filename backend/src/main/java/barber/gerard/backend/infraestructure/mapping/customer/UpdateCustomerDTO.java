package barber.gerard.backend.infraestructure.mapping.customer;

public record UpdateCustomerDTO(
        Long id,
        String firstName,
        String lastName,
        String cellphoneNumber,
        String email
) {
}
