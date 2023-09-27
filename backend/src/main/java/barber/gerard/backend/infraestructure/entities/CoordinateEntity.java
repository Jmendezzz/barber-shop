package barber.gerard.backend.infraestructure.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address_coordinate")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CoordinateEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private Double longitude;
  @Column(nullable = false)
  private Double latitude;
}