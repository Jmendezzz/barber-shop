package barber.gerard.backend.domain.models;

import barber.gerard.backend.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
  private Long id;
  private Barber barber;
  private CutService cutService;
  private Customer customer;
  private LocalDateTime date;
  private Status status;

}
