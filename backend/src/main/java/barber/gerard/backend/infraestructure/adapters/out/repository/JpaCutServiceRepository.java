package barber.gerard.backend.infraestructure.adapters.out.repository;

import barber.gerard.backend.domain.models.CutService;
import barber.gerard.backend.infraestructure.entities.CutServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCutServiceRepository extends JpaRepository<CutServiceEntity,Long> {
}
