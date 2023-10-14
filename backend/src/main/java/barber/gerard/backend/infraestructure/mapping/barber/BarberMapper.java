package barber.gerard.backend.infraestructure.mapping.barber;

import barber.gerard.backend.domain.enums.Role;
import barber.gerard.backend.domain.models.Barber;
import barber.gerard.backend.domain.models.User;
import barber.gerard.backend.infraestructure.entities.BarberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BarberMapper {
    Barber entityToDomain(BarberEntity barber);
    List<Barber> entityListToDomainList(List<BarberEntity> barbers);
    BarberEntity domainToEntity(Barber barber);
    Barber userToBarber(User user);
    @Mapping(target = "password", source = "barber.nid")
    @Mapping(target = "role", expression = "java(setBarberRole())")
    Barber createBarberDTOToDomain(CreateBarberDTO barber);
    Barber updateBarberDTOToDomain(UpdateBarberDTO barber);
    PublicBarberInfoDTO domainToPublicBarberInfoDTO(Barber barber);
    List<PublicBarberInfoDTO> domainListToPublicBarberInfoDTOList(List<Barber> barbers);
    default Role setBarberRole(){
        return Role.BARBER;
    }

}
