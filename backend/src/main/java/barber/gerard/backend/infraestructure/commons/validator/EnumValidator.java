package barber.gerard.backend.infraestructure.commons.validator;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidatorConstraint.class)
public @interface EnumValidator {
  String message();
  Class<? extends Enum<?>> enumC();
  Class<?>[] groups() default {};
  Class<?>[] payload() default {};

}
