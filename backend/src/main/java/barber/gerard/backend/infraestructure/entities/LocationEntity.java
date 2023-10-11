package barber.gerard.backend.infraestructure.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Where;

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
  @OneToMany
  @JoinTable(
          name = "employee_location", // Nombre de la tabla intermedia
          joinColumns = @JoinColumn(name = "location_id"), // Clave foránea de LocationEntity
          inverseJoinColumns = @JoinColumn(name = "employee_id") // Clave foránea de UserEntity
  )
  @Where(clause = "role = 'ADMIN'") // Filtrar por rol de ADMIN a los Users
  private List<UserEntity> admins;
  @OneToOne(cascade = CascadeType.ALL)
  private AddressEntity address;
}
