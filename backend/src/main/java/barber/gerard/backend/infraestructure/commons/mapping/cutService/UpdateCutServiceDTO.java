package barber.gerard.backend.infraestructure.commons.mapping.cutService;

import java.time.LocalTime;

public record UpdateCutServiceDTO(
        Long id,
        String name,
        String description,
        Double price,
        LocalTime duration) {
}
