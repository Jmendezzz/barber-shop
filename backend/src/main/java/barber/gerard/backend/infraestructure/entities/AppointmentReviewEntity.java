package barber.gerard.backend.infraestructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "appointment_review")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentReviewEntity {
  @Id
  private Long id;
  @OneToOne
  private AppointmentEntity appointment;
  private String review;
  private Double rating;
}