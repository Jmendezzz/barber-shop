package barber.gerard.backend.infraestructure.entities;


import barber.gerard.backend.domain.models.AppointmentReview;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
  private  LocationEntity location;
  private int yearsExperience;
  private List<AppointmentReview> appointmentsHistory;
  private Double rating;
}
