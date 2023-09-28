package barber.gerard.backend.infraestructure.adapters.out.repository;

import barber.gerard.backend.infraestructure.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
