package barber.gerard.backend.infraestructure.adapters.out.repository;

import barber.gerard.backend.infraestructure.entities.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JpaLocationRepository extends JpaRepository<LocationEntity,Long> {


}
