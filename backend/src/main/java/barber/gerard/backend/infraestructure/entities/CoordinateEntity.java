package barber.gerard.backend.infraestructure.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
  private Long id;
  @Column(nullable = false)
  private Double longitude;
  @Column(nullable = false)
  private Double latitude;
}