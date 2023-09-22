package barber.gerard.backend.infraestructure.entities;

import jakarta.persistence.*;
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