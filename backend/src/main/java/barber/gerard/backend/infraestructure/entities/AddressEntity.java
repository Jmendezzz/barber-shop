package barber.gerard.backend.infraestructure.entities;


import barber.gerard.backend.domain.models.Coordinate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "address_location")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 50, nullable = false)
  private String country;
  @Column(length = 50, nullable = false)
  private String city;
  @Column(length = 50, nullable = false)
  private String description;
  @OneToOne(cascade = CascadeType.ALL)
  private CoordinateEntity location;
}