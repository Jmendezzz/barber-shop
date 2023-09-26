package barber.gerard.backend.infraestructure.mapping.address;

import barber.gerard.backend.infraestructure.mapping.coordinate.CreateCoordinateDTO;

public record CreateAddressDTO(
        String country,
        String city,
        String description,
        CreateCoordinateDTO coordinate
) {
}
