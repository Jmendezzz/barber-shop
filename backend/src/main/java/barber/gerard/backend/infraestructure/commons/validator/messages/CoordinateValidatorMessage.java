package barber.gerard.backend.infraestructure.commons.validator.messages;

public class CoordinateValidatorMessage {
public static final String ID_NOT_NULL = "El id es obligatorio.";
  public static final String LATITUDE_NOT_NULL = "La latitud es obligatoria.";
  public static final String LONGITUDE_NOT_NULL = "La longitud es obligatoria.";
  public static final String LATITUDE_SIZE = "La latitud debe ser entre -90 y 90.";
  public static final String LONGITUDE_SIZE = "La longitud debe ser entre -180 y 180.";
}
