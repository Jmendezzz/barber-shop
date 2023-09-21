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
public class Location {
  private Long id;
  private String name;
  private String description;
  private List<Admin> admins;
  private Address address;

}
