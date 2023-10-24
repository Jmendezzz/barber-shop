package barber.gerard.backend.infraestructure.commons.mapping.coordinate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import static barber.gerard.backend.infraestructure.commons.validator.messages.CoordinateValidatorMessage.*;

public record CreateCoordinateDTO(
        @NotNull(message = LONGITUDE_NOT_NULL)
        @Min(value = -180, message = LONGITUDE_SIZE)
        @Max(value = 180, message = LONGITUDE_SIZE)
        Double longitude,
        @NotNull(message = LATITUDE_NOT_NULL)
        @Min(value = -90, message = LATITUDE_SIZE)
        @Max(value = 90, message = LATITUDE_SIZE)
        Double latitude
) {
}
