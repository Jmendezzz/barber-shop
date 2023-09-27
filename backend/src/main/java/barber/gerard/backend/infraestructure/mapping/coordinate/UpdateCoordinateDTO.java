package barber.gerard.backend.infraestructure.mapping.coordinate;

public record UpdateCoordinateDTO(
        Long id,
        Double longitude,
        Double latitude
) {
}
