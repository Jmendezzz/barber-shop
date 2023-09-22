package barber.gerard.backend.infraestructure.mapping.admin;


import barber.gerard.backend.domain.models.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {

  PublicAdminInfoDTO entityToPublicAdminInfoDTO(Admin admin);
}
