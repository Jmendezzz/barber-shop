package barber.gerard.backend.application.services;

import barber.gerard.backend.domain.models.Customer;
import barber.gerard.backend.application.ports.in.CustomerInputPort;
import barber.gerard.backend.application.ports.out.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService implements CustomerInputPort {
    private CustomerRepository customerRepository;
    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> updateCustomer(Customer customerUpdated) {
        return customerRepository.update(customerUpdated);
    }

    @Override
    public Customer deleteCustomerById(Long id) {
        return customerRepository.deleteById(id);
    }
}
