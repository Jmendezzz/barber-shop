package barber.gerard.backend.infraestructure.commons.mapping.appointment;

import barber.gerard.backend.domain.models.CutService;
import barber.gerard.backend.infraestructure.commons.mapping.barber.PublicBarberInfoDTO;
import barber.gerard.backend.infraestructure.commons.mapping.customer.PublicCustomerInfoDTO;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

import static barber.gerard.backend.infraestructure.commons.validator.messages.AppointmentValidatorMessage.*;

public record CreateAppointmentDTO(
        @NotNull(message = BARBER_NOT_NULL)
        PublicBarberInfoDTO barber,
        @NotNull(message = CUT_SERVICE_NOT_NULL)
        CutService cutService,
        @NotNull(message = CUSTOMER_NOT_NULL)
        PublicCustomerInfoDTO customer,
        @NotNull(message = DATE_NOT_NULL)
        @Future(message = DATE_NOT_IN_THE_PAST)
        LocalDateTime date
) {
}
