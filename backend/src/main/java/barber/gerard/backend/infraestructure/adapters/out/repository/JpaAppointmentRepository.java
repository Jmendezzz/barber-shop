package barber.gerard.backend.infraestructure.adapters.out.repository;

import barber.gerard.backend.infraestructure.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAppointmentRepository extends JpaRepository<AppointmentEntity,Long> {
}
