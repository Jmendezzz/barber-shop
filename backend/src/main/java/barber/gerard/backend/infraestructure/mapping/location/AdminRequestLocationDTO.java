package barber.gerard.backend.infraestructure.mapping.location;

import barber.gerard.backend.domain.models.Address;

public record AdminRequestLocationDTO(
        Long id,
        String name,
        String description,
        Address address
) {
}
