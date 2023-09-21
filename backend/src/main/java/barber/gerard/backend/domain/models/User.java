package barber.gerard.backend.domain.models;


import barber.gerard.backend.domain.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private Long id;
  private String firstName;
  private String lastName;
  private String nid;
  private String cellphoneNumber;
  private LocalDate birthday;
  private Role role;
  private String email;
  private String password;


}
