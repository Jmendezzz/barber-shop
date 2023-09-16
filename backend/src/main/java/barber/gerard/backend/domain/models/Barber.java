package barber.gerard.backend.domain.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Barber extends  User{
  private Integer haircutsCount;
  private Double qualification;

}
