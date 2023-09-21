package barber.gerard.backend.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentReview {
  private Long id;
  private Appointment appointment;
  private String review;
  private Double rating;
}
