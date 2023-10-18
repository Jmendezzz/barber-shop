package barber.gerard.backend.infraestructure.commons.mapping.address;

import barber.gerard.backend.infraestructure.commons.mapping.coordinate.CreateCoordinateDTO;

public record CreateAddressDTO(
        String country,
        String city,
        String description,
        CreateCoordinateDTO location
) {
}
