package barber.gerard.backend.infraestructure.mapping.address;

import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.infraestructure.mapping.coordinate.CreateCoordinateDTO;

import java.util.List;

public record CreateAddressDTO(
        String country,
        String city,
        List<Admin> description,
        CreateCoordinateDTO coordinate
) {
}
