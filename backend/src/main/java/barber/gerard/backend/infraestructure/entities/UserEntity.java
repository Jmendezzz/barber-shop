package barber.gerard.backend.infraestructure.entities;

import barber.gerard.backend.domain.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 50, nullable = false)
  private String firstName;
  @Column(length = 50, nullable = false)
  private String lastName;
  @Column(length = 14)
  private String nid;
  @Column(length = 20, nullable = false)
  private String cellphoneNumber;
  @Column(nullable = false)
  private LocalDate birthday;
  @Enumerated(EnumType.STRING)
  private Role role;
  @Column(length = 50, nullable = false)
  private String email;
  @Column(length = 20, nullable = false)
  private String password;
}