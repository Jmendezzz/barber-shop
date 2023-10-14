package barber.gerard.backend.infraestructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "barber")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BarberEntity extends UserEntity{
  @ManyToOne
  private  LocationEntity location;
  private Double rating;
}
