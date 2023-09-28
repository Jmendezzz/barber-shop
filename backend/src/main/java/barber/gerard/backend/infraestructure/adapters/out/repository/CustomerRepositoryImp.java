package barber.gerard.backend.infraestructure.adapters.out.repository;

import barber.gerard.backend.domain.models.Customer;
import barber.gerard.backend.infraestructure.entities.CustomerEntity;
import barber.gerard.backend.infraestructure.mapping.customer.CustomerMapper;
import barber.gerard.backend.infraestructure.ports.out.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CustomerRepositoryImp implements CustomerRepository {
    private JpaCustomerRepository jpaCustomerRepository;
    private CustomerMapper customerMapper;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = customerMapper.domainToEntity(customer);
        CustomerEntity entitySaved =  jpaCustomerRepository.save(customerEntity);
        return customerMapper.entityToDomain(entitySaved);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        Optional<CustomerEntity> customerEntity = jpaCustomerRepository.findById(id);
        return customerEntity.map(cust-> customerMapper.entityToDomain(cust));
    }

    @Override
    public List<Customer> findAll() {
        return customerMapper.entityListToDomainList(jpaCustomerRepository.findAll());
    }

    @Override
    public Optional<Customer> update(Customer customerUpdated) {
        if(jpaCustomerRepository.existsById(customerUpdated.getId())){
            CustomerEntity customerEntity = customerMapper.domainToEntity(customerUpdated);
            CustomerEntity entityUpdated =  jpaCustomerRepository.save(customerEntity);
            return Optional.of(
                    customerMapper.entityToDomain(entityUpdated)
            );
        }else {
            return Optional.empty();
        }
    }

    @Override
    public Customer deleteById(Long id) {
        Optional<CustomerEntity> customer =  jpaCustomerRepository.findById(id);
        return customer.map(cust -> customerMapper.entityToDomain(cust))
                .orElseThrow(()-> new RuntimeException());
    }
}
