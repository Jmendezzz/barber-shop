package barber.gerard.backend.infraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "cut_service")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CutServiceEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 50, nullable = false)
  private String name;
  @Column(length = 200, nullable = false)
  private String description;
  @Column(nullable = false)
  private Double price;
  @Column(nullable = false)
  private LocalTime duration;
}