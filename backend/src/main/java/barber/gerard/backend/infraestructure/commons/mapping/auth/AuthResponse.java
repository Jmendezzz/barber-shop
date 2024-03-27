package barber.gerard.backend.infraestructure.commons.mapping.auth;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"username", "message", "jwt", "status"})
public record AuthResponse(String username, String message, String jwt, boolean status) {
}
