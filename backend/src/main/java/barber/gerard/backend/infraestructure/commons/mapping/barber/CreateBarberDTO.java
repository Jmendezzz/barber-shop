package barber.gerard.backend.infraestructure.commons.mapping.barber;

import barber.gerard.backend.infraestructure.commons.mapping.location.LocationDTO;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

import static barber.gerard.backend.infraestructure.commons.validator.messages.UserValidatorMessage.*;
import static barber.gerard.backend.infraestructure.commons.validator.messages.UserValidatorMessage.LAST_NAME_SIZE;

public record CreateBarberDTO(
        @NotBlank(message = NAME_NOT_NULL)
        @Size(min = 3, max = 50, message = NAME_SIZE)
        String firstName,
        @NotBlank(message = LAST_NAME_NOT_NULL)
        @Size(min = 3, max = 50, message = LAST_NAME_SIZE)
        String lastName,
        @NotBlank(message = NID_NOT_NULL)
        @Size(min = 10, max = 10, message = NID_SIZE)
        String nid,
        @NotBlank(message = CELLPHONE_NUMBER_NOT_NULL)
        @Size(min = 10, max = 10, message = CELLPHONE_NUMBER_SIZE)
        String cellphoneNumber,
        @NotNull(message = BIRTHDAY_NOT_NULL)
        @Past(message = BIRTHDAY_NOT_FUTURE)
        LocalDate birthday,
        @NotBlank(message = EMAIL_NOT_NULL)
        @Email(message = EMAIL_NOT_VALID)
        String email,
        LocationDTO location
) {
}
