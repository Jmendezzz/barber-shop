package barber.gerard.backend.infraestructure.commons.mapping.auth;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(@NotBlank String username, @NotBlank String password) {
}
