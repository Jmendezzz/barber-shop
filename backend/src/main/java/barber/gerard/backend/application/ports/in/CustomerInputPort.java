package barber.gerard.backend.application.ports.in;

import barber.gerard.backend.domain.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerInputPort {
    Optional<Customer> getCustomerById(Long id);
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Optional<Customer> updateCustomer(Customer customerUpdated);
    Customer deleteCustomerById(Long id);
}
