package barber.gerard.backend.infraestructure.commons.mapping.location;

import barber.gerard.backend.infraestructure.commons.mapping.address.UpdateAddressDTO;
import barber.gerard.backend.infraestructure.commons.mapping.admin.LocationRequestAdminDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

import static barber.gerard.backend.infraestructure.commons.validator.messages.LocationValidatorMessage.*;
import static barber.gerard.backend.infraestructure.commons.validator.messages.LocationValidatorMessage.DESCRIPTION_SIZE;

public record UpdateLocationDTO(
        @NotNull(message = ID_NOT_NULL)
        Long id,
        @NotBlank(message = NAME_NOT_NULL)
        String name,
        @NotBlank(message = DESCRIPTION_NOT_NULL)
        @Size(min=10, max=255, message = DESCRIPTION_SIZE)
        String description,
        List<LocationRequestAdminDTO> admins,
        @NotNull(message = ADDRESS_NOT_NULL)
        @Valid
        UpdateAddressDTO address
) {
}
