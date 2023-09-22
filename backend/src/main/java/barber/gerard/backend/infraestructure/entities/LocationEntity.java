package barber.gerard.backend.infraestructure.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "location")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LocationEntity {
  @Id
  private Long id;
  @Column(length = 50, nullable = false)
  private String name;
  @Column(length = 200, nullable = false)
  private String description;
  @OneToMany
  private List<AdminEntity> admins;
  @OneToOne
  private AddressEntity address;
}
