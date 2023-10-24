package barber.gerard.backend.infraestructure.commons.mapping.address;

import barber.gerard.backend.infraestructure.commons.mapping.coordinate.UpdateCoordinateDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import static barber.gerard.backend.infraestructure.commons.validator.messages.AddressValidatorMessage.*;


public record UpdateAddressDTO(
        @NotNull(message = ID_NOT_NULL)
        Long id,
        @NotBlank(message = COUNTRY_NOT_NULL)
        String country,
        @NotBlank(message = CITY_NOT_NULL)
        String city,
        @NotBlank(message = DESCRIPTION_NOT_NULL)
        @Size(min=10, max=100, message = DESCRIPTION_SIZE)
        String description,
        @NotNull(message = LOCATION_NOT_NULL)
        @Valid
        UpdateCoordinateDTO location
) {
}
