package barber.gerard.backend.infraestructure.commons.exceptions.config;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionResponse {
  private String message;
  private LocalDateTime timestamp;
}
