package barber.gerard.backend.infraestructure.commons.mapping.barber;

import barber.gerard.backend.domain.enums.Role;
import barber.gerard.backend.domain.models.Barber;
import barber.gerard.backend.domain.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BarberMapper {
    Barber userToBarber(User user);
    User barberToUser(Barber barber);
    List<Barber> usertListToBarberList(List<User> users);
    @Mapping(target = "password", source = "barber.nid")
    @Mapping(target = "role", expression = "java(setBarberRole())")
    @Mapping(target = "rating", expression = "java(setDefaultRating())")
    Barber createBarberDTOToDomain(CreateBarberDTO barber);
    @Mapping(target = "role", expression = "java(setBarberRole())")
    Barber updateBarberDTOToDomain(UpdateBarberDTO barber);
    PublicBarberInfoDTO domainToPublicBarberInfoDTO(Barber barber);
    List<PublicBarberInfoDTO> domainListToPublicBarberInfoDTOList(List<Barber> barbers);
    default Role setBarberRole(){
        return Role.BARBER;
    }
    default Double setDefaultRating(){
        return 0.0;
    }

}
