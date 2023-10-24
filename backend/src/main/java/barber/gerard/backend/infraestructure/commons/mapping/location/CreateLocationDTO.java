package barber.gerard.backend.infraestructure.commons.mapping.location;

import barber.gerard.backend.infraestructure.commons.mapping.address.CreateAddressDTO;
import barber.gerard.backend.infraestructure.commons.mapping.admin.PublicAdminInfoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

import static barber.gerard.backend.infraestructure.commons.validator.messages.LocationValidatorMessage.*;

public record CreateLocationDTO(
        @NotBlank(message = NAME_NOT_NULL)
        String name,
        @NotBlank(message = DESCRIPTION_NOT_NULL)
        @Size(min=10, max=255, message = DESCRIPTION_SIZE)
        String description,
        List<PublicAdminInfoDTO> admins,
        @NotNull(message = ADDRESS_NOT_NULL)
        @Valid
        CreateAddressDTO address
) {
}
