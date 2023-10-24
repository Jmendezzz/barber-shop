package barber.gerard.backend.infraestructure.commons.validator.messages;

public class AddressValidatorMessage {
  public static final String ID_NOT_NULL = "El id es obligatorio.";
  public static final String COUNTRY_NOT_NULL = "El país es obligatorio.";
  public static final String CITY_NOT_NULL = "La ciudad es obligatoria.";
  public static final String DESCRIPTION_NOT_NULL = "La descripción es obligatoria.";
  public static final String DESCRIPTION_SIZE = "La descripción debe tener entre 10 y 100 caracteres.";
  public static final String LOCATION_NOT_NULL = "La dirección es obligatoria.";
}
