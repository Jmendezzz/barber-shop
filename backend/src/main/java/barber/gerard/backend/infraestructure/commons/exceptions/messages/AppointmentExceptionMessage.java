package barber.gerard.backend.infraestructure.commons.exceptions.messages;

public class AppointmentExceptionMessage {
  public static final String APPOINTMENT_NOT_FOUND = "No se encontró la reserva.";
  public static final String APPOINTMENT_TIME_EXCEEDED = "La reserva debe ser con al menos 2 horas de antelación.";
  public static final String APPOINTMENT_TIME_BEFORE_OPENING_TIME = "La reserva debe ser realizada despues del horario de apertura (8am).";
  public static final String APPOINTMENT_TIME_AFTER_CLOSING_TIME = "La reserva debe ser realizada antes del horario de cierre (7pm).";
}
