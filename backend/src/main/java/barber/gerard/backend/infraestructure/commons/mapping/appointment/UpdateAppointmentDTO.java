package barber.gerard.backend.infraestructure.commons.mapping.appointment;

import barber.gerard.backend.domain.enums.Status;
import barber.gerard.backend.domain.models.CutService;
import barber.gerard.backend.infraestructure.commons.mapping.barber.PublicBarberInfoDTO;
import barber.gerard.backend.infraestructure.commons.mapping.customer.PublicCustomerInfoDTO;
import java.time.LocalDateTime;

public record UpdateAppointmentDTO(
        Long id,
        PublicBarberInfoDTO barber,
        CutService cutService,
        PublicCustomerInfoDTO customer,
        LocalDateTime date,
        Status status
) {
}
