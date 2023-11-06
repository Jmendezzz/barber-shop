package barber.gerard.backend.application.services;

import barber.gerard.backend.application.ports.in.constraints.UserConstraint;
import barber.gerard.backend.domain.models.Customer;
import barber.gerard.backend.application.ports.in.services.CustomerInputPort;
import barber.gerard.backend.application.ports.out.CustomerRepository;
import barber.gerard.backend.infraestructure.commons.exceptions.UserException;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService implements CustomerInputPort {
    private CustomerRepository customerRepository;
    private UserConstraint userConstraint;
    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    @CacheEvict(value = "customers", allEntries = true)
    public Customer createCustomer(Customer customer) {
        validateCustomer(customer);
        return customerRepository.save(customer);
    }

    @Override
    @Cacheable("customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @Cacheable("customers")
    public List<Customer> getPaginatedCustomers(Integer page, Integer size) {
        return customerRepository.findAllPaginated(page, size);
    }

    @Override
    @CacheEvict(value = "customers", allEntries = true)
    public Optional<Customer> updateCustomer(Customer customerUpdated) {
        validateCustomer(customerUpdated);
        return customerRepository.update(customerUpdated);
    }

    @Override
    @CacheEvict(value = "customers", allEntries = true)
    public Customer deleteCustomerById(Long id) {
        return customerRepository.deleteById(id);
    }
    public void validateCustomer(Customer customer) throws UserException {
        userConstraint.validateUserEmail(customer.getEmail());
        userConstraint.validateUserNid(customer.getPassword());
        userConstraint.validateCellphone (customer.getCellphoneNumber());
    }
}
