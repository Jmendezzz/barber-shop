package barber.gerard.backend.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
  private Long id;
  private String country;
  private String city;
  private String description;
  private Coordinate location;
}
