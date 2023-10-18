package barber.gerard.backend.infraestructure.commons.mapping.address;

import barber.gerard.backend.infraestructure.commons.mapping.coordinate.UpdateCoordinateDTO;

public record UpdateAddressDTO(
  Long id,
  String country,
  String city,
  String description,
  UpdateCoordinateDTO location
) {
}
