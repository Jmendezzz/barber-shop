package barber.gerard.backend.infraestructure.mapping.admin;


import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.infraestructure.entities.AdminEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {

  PublicAdminInfoDTO entityToPublicAdminInfoDTO(Admin admin);
  Admin entityToDomain(AdminEntity admin);
  AdminEntity domainToEntity(Admin admin);
}
