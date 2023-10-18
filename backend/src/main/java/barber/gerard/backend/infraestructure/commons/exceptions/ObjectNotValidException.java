package barber.gerard.backend.infraestructure.commons.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Set;

@Getter
@AllArgsConstructor
public class ObjectNotValidException extends RuntimeException{
  private Set<String> errorMessages;
}
