package barber.gerard.backend.domain.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Barber extends  User{
  private List<AppointmentReview> appointmentsHistory;
  private Double rating;
  private Location location;



}
