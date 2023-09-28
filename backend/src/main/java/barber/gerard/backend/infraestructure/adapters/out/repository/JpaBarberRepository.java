package barber.gerard.backend.infraestructure.adapters.out.repository;

import barber.gerard.backend.infraestructure.entities.BarberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBarberRepository extends JpaRepository<BarberEntity, Long> {
}
