package barber.gerard.backend.infraestructure.mapping.customer;

import barber.gerard.backend.domain.models.Customer;
import barber.gerard.backend.infraestructure.entities.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    PublicCustomerInfoDTO domainToPublicCustomerInfoDTO(Customer customer);
    Customer entityToDomain(CustomerEntity customer);
    List<Customer> entityListToDomainList(List<CustomerEntity> customers);
    CustomerEntity domainToEntity(Customer customer);
    Customer createCustomerDTOToDomain(CreateCustomerDTO customer);
    Customer updateCustomerDTOToDomain(UpdateCustomerDTO customer);
    List<PublicCustomerInfoDTO> domainListToPublicCustomerInfoDTOList(List<Customer> customers);
}
