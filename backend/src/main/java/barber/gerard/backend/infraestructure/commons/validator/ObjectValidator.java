package barber.gerard.backend.infraestructure.commons.validator;

import barber.gerard.backend.infraestructure.commons.exceptions.ObjectNotValidException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectValidator{
  private final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
  private final Validator validator = validatorFactory.getValidator();
  public <T> void validate(T object) {
    Set<ConstraintViolation<T>> violations = validator.validate(object);
    if(!violations.isEmpty()) {
      Set<String> errorMessages = violations.stream()
                                            .map(ConstraintViolation::getMessage)
                                            .collect(Collectors.toSet());
      throw new ObjectNotValidException(errorMessages);
    }
  }
}
