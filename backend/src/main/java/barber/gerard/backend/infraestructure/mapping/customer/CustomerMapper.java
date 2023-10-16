package barber.gerard.backend.infraestructure.mapping.customer;

import barber.gerard.backend.domain.enums.Role;
import barber.gerard.backend.domain.models.Customer;
import barber.gerard.backend.domain.models.User;
import barber.gerard.backend.infraestructure.entities.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    PublicCustomerInfoDTO domainToPublicCustomerInfoDTO(Customer customer);
    Customer entityToDomain(CustomerEntity customer);
    List<Customer> entityListToDomainList(List<CustomerEntity> customers);
    CustomerEntity domainToEntity(Customer customer);
    Customer userToCustomer(User user);
    List<Customer> usetListToCustomerList(List<User> users);
    User customerToUser(Customer customer);

    @Mapping(target = "password", source = "nid")
    @Mapping(target = "role", expression = "java(setCustomerRole())")
    @Mapping(target = "points", expression = "java(setCustomerPoints())")
    Customer createCustomerDTOToDomain(CreateCustomerDTO customer);
    @Mapping(target = "role", expression = "java(setCustomerRole())")
    Customer updateCustomerDTOToDomain(UpdateCustomerDTO customer);
    List<PublicCustomerInfoDTO> domainListToPublicCustomerInfoDTOList(List<Customer> customers);

    default Role setCustomerRole(){
        return Role.CUSTOMER;
    }
    default Integer setCustomerPoints(){
        return 0;
    }

}
