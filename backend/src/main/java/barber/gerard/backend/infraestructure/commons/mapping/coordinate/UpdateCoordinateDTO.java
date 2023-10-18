package barber.gerard.backend.infraestructure.commons.mapping.coordinate;

public record UpdateCoordinateDTO(
        Long id,
        Double longitude,
        Double latitude
) {
}
