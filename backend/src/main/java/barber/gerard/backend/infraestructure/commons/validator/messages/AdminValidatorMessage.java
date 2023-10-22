package barber.gerard.backend.infraestructure.commons.validator.messages;

public class AdminValidatorMessage {
  public static final String NAME_NOT_NULL = "El nombre es obligatorio.";
  public static final String NAME_SIZE = "El nombre debe tener entre 3 y 50 caracteres.";

  public static final String LAST_NAME_NOT_NULL = "Los apellidos son obligatorios.";
  public static final String LAST_NAME_SIZE = "Los apellidos deben tener entre 3 y 50 caracteres.";

  public static final String NID_NOT_NULL = "El NID es obligatorio.";
  public static final String NID_SIZE = "El NID debe tener 10 caracteres.";

  public static final String CELLPHONE_NUMBER_NOT_NULL = "El número de teléfono es obligatorio.";
  public static final String CELLPHONE_NUMBER_SIZE = "El número de teléfono debe tener 10 caracteres.";

  public static final String BIRTHDAY_NOT_NULL = "La fecha de nacimiento es obligatoria.";
  public static final String BIRTHDAY_NOT_FUTURE = "La fecha de nacimiento no debe ser una fecha futura.";

  public static final String EMAIL_NOT_NULL = "El email es obligatorio.";
  public static final String EMAIL_NOT_VALID = "El email no es válido.";
}
