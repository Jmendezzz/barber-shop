package barber.gerard.backend.infraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customer_points")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity extends UserEntity{
  private Integer points;
}
