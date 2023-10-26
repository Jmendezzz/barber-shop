package barber.gerard.backend.infraestructure.commons.validator.messages;

public class AppointmentValidatorMessage {
  public static final String ID_NOT_NULL = "El id es obligatorio.";
  public static final String BARBER_NOT_NULL = "El barbero es obligatorio.";
  public static final String CUT_SERVICE_NOT_NULL = "El servicio de corte es obligatorio.";
  public static final String CUSTOMER_NOT_NULL = "El cliente es obligatorio.";
  public static final String DATE_NOT_NULL = "La fecha es obligatoria.";
  public static final String DATE_NOT_IN_THE_PAST = "La fecha no puede ser en el pasado.";
  public static final String STATUS_NOT_NULL = "El estado es obligatorio.";
  public static final String STATUS_NOT_VALID = "El estado no es válido.";

}
