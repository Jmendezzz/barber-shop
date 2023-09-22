package barber.gerard.backend.infraestructure.entities;


import barber.gerard.backend.domain.models.Coordinate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address_location")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressEntity {
  @Id
  private Long id;
  @Column(length = 50, nullable = false)
  private String country;
  @Column(length = 50, nullable = false)
  private String city;
  @Column(length = 50, nullable = false)
  private String description;
  @OneToOne
  private CoordinateEntity location;
}