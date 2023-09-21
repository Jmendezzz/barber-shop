package barber.gerard.backend.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CutService {
  private Long id;
  private String name;
  private String description;
  private Double price;
  private LocalTime duration;

}
