package barber.gerard.backend.infraestructure.adapters.out.repository;

import barber.gerard.backend.infraestructure.entities.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAdminRepository extends JpaRepository<AdminEntity, Long> {
}
