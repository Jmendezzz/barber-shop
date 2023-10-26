package barber.gerard.backend.application.ports.out;

import barber.gerard.backend.domain.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(Long id);
    List<Customer> findAll();
    Optional<Customer> update(Customer customerUpdated);
    Customer deleteById(Long id);
}
