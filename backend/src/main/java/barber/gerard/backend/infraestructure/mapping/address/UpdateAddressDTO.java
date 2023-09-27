package barber.gerard.backend.infraestructure.mapping.address;

import barber.gerard.backend.infraestructure.mapping.coordinate.UpdateCoordinateDTO;

public record UpdateAddressDTO(
  Long id,
  String country,
  String city,
  String description,
  UpdateCoordinateDTO location
) {
}
