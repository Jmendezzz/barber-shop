package barber.gerard.backend.infraestructure.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "location")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LocationEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 50, nullable = false)
  private String name;
  @Column(length = 200, nullable = false)
  private String description;
  @OneToMany(cascade = CascadeType.REMOVE)
  private List<AdminEntity> admins;
  @OneToOne(cascade = CascadeType.ALL)
  private AddressEntity address;
}
