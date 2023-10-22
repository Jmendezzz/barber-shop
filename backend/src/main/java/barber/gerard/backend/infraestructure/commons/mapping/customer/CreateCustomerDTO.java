package barber.gerard.backend.infraestructure.commons.mapping.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

import static barber.gerard.backend.infraestructure.commons.validator.messages.UserValidatorMessage.*;

public record CreateCustomerDTO(
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
        @NotBlank(message = BIRTHDAY_NOT_NULL)
        @Past(message = BIRTHDAY_NOT_FUTURE)
        LocalDate birthday,
        @NotBlank(message = EMAIL_NOT_NULL)
        @Email(message = EMAIL_NOT_VALID)
        String email
){}
