package barber.gerard.backend.infraestructure.adapters.in.http;

import barber.gerard.backend.domain.models.Customer;
import barber.gerard.backend.infraestructure.mapping.customer.CreateCustomerDTO;
import barber.gerard.backend.infraestructure.mapping.customer.CustomerMapper;
import barber.gerard.backend.infraestructure.mapping.customer.PublicCustomerInfoDTO;
import barber.gerard.backend.infraestructure.mapping.customer.UpdateCustomerDTO;
import barber.gerard.backend.infraestructure.ports.in.CustomerInputPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private CustomerInputPort customerInputPort;
    private CustomerMapper customerMapper;

    @GetMapping("/{id}")
    public ResponseEntity<PublicCustomerInfoDTO> getCustomerById(@PathVariable Long id){
        Optional<Customer> customer = customerInputPort.getCustomerById(id);

        //TODO HANDLE EXCEPTION
        return customer
                .map(cust -> new ResponseEntity<>(
                        customerMapper.domainToPublicCustomerInfoDTO(cust), HttpStatus.OK))
                .orElseThrow(()-> new RuntimeException("No se encontró el CLIENTE"));
    }

    @GetMapping("/")
    public ResponseEntity<List<PublicCustomerInfoDTO>> getAllCustomers(){
        List<PublicCustomerInfoDTO> customers = customerMapper.domainListToPublicCustomerInfoDTOList(customerInputPort.getAllCustomers());
        return new ResponseEntity<>(
                customers,
                HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<PublicCustomerInfoDTO> createCustomer(@RequestBody CreateCustomerDTO createCustomerDTO){
        Customer customerDomain = customerMapper.createCustomerDTOToDomain(createCustomerDTO);
        Customer customerCreated = customerInputPort.createCustomer(customerDomain);
        return new ResponseEntity<>(
                customerMapper.domainToPublicCustomerInfoDTO(customerCreated),
                HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PublicCustomerInfoDTO> updateCustomer(@RequestBody UpdateCustomerDTO updateCustomerDTO){
        Customer customerDomainUpdated = customerMapper.updateCustomerDTOToDomain(updateCustomerDTO);
        Optional<Customer> customerUpdated = customerInputPort.updateCustomer(customerDomainUpdated);
        return customerUpdated.map(cust -> new ResponseEntity<>(
                customerMapper.domainToPublicCustomerInfoDTO(cust),
                HttpStatus.OK))
                .orElseThrow(()-> new RuntimeException("No se encontró el CLIENTE"));
    }

    @DeleteMapping("/delte/{id}")
    public ResponseEntity<PublicCustomerInfoDTO> deleteCustomerById(@PathVariable Long id){
        Customer customerDeleted = customerInputPort.deleteCustomerById(id);
        return new ResponseEntity<>(
                customerMapper.domainToPublicCustomerInfoDTO(customerDeleted),
                HttpStatus.OK);
    }
}
