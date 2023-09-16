package barber.gerard.backend.domain.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private Long id;
  private String name;
  private String cellphoneNumber;
  private String email;
  private String password;
  private Date birthday;


}
