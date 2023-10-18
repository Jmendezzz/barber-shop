package barber.gerard.backend.infraestructure.adapters.out.repository.imp;

import barber.gerard.backend.domain.enums.Role;
import barber.gerard.backend.domain.models.Customer;
import barber.gerard.backend.domain.models.User;
import barber.gerard.backend.infraestructure.commons.mapping.customer.CustomerMapper;
import barber.gerard.backend.infraestructure.ports.out.CustomerRepository;
import barber.gerard.backend.infraestructure.ports.out.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@AllArgsConstructor
public class CustomerRepositoryImp implements CustomerRepository {
    private CustomerMapper customerMapper;
    private UserRepository userRepository;
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Customer save(Customer customer) {
        Customer customerSaved = customerMapper.userToCustomer(userRepository.save(customer));
        customerSaved.setPoints(customer.getPoints());
        saveCustomerPoints(customerSaved);

        return customerSaved;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            Customer customer = customerMapper.userToCustomer(user.get());
            customer.setPoints(getCustomerPoints(customer));

            return Optional.of(customer);
        }else {
            return Optional.empty();
        }
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = customerMapper.usetListToCustomerList(userRepository.findByRole(Role.CUSTOMER));
        customers.parallelStream()
                    .forEach(c->c.setPoints(getCustomerPoints(c)));

        return customers;
    }

    @Override
    public Optional<Customer> update(Customer customerUpdated) {
        if(userRepository.existsById(customerUpdated.getId())){
            Customer customer = customerMapper.userToCustomer(userRepository.update(customerUpdated).get());
            updateCustomerPoints(customerUpdated);
            customer.setPoints(getCustomerPoints(customer));
            return Optional.of(customer);
        }else {
            return Optional.empty();
        }
    }

    @Override
    public Customer deleteById(Long id) {
        deleteCustomerPoints(id);
        userRepository.deleteById(id);
        //TODO: Return Customer.
        return null;

    }

    private void saveCustomerPoints(Customer customer){
        entityManager.createNativeQuery("INSERT INTO customer_points(customer_id,points) VALUES(?,?)")
                                        .setParameter(1,customer.getId())
                                        .setParameter(2,customer.getPoints())
                                        .executeUpdate();
    }

    private Integer getCustomerPoints(Customer customer){
        return (Integer) entityManager.createNativeQuery("SELECT points FROM customer_points WHERE customer_id = ?")
                                                        .setParameter(1,customer.getId())
                                                        .getSingleResult();
    }
    private void deleteCustomerPoints(Long customerId){
        entityManager.createNativeQuery("DELETE FROM customer_points WHERE customer_id = ?")
                                        .setParameter(1,customerId)
                                        .executeUpdate();
    }

    private void updateCustomerPoints(Customer customer){
        deleteCustomerPoints(customer.getId());
        saveCustomerPoints(customer);
    }
}
