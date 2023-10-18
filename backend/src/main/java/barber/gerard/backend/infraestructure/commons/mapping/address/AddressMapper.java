package barber.gerard.backend.infraestructure.commons.mapping.address;


import barber.gerard.backend.domain.models.Address;
import barber.gerard.backend.infraestructure.entities.AddressEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
  Address entityToDomain(AddressEntity address);
  AddressEntity domainToEntity(Address address);
  Address createAddressDTOToDomain(CreateAddressDTO createAddressDTO);

}
