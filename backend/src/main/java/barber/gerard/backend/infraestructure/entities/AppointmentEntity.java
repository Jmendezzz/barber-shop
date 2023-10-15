package barber.gerard.backend.infraestructure.entities;

import barber.gerard.backend.domain.enums.Status;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentEntity {
  @Id
  private Long id;
  @ManyToOne
  private UserEntity barber;
  @ManyToOne
  private CutServiceEntity cutService;
  @ManyToOne
  private UserEntity customer;
  private LocalDateTime date;
  private Status status;

}
