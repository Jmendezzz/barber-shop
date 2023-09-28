package barber.gerard.backend.infraestructure.mapping.barber;

import barber.gerard.backend.domain.models.AppointmentReview;
import barber.gerard.backend.domain.models.Location;

import java.time.LocalDate;
import java.util.List;

public record PublicBarberInfoDTO(
        Long id,
        String firstName,
        String lastName,
        String cellphoneNumber,
        LocalDate birthday,
        Location managedLocation,
        int yearsExperience,
        List<AppointmentReview> appointmentHistory,
        Double rating
) {
}
