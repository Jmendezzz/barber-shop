package barber.gerard.backend.infraestructure.commons.mapping.admin;


import barber.gerard.backend.domain.enums.Role;
import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.domain.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper {
  Admin userToAdmin(User user);
  List<Admin> userListToAdminList(List<User> users);
  User adminToUser(Admin admin);

  @Mapping(target = "password", source = "admin.nid")
  @Mapping(target = "role", expression = "java(setAdminRole())")
  Admin createAdminDTOToDomain(CreateAdminDTO admin);
  @Mapping(target = "role", expression = "java(setAdminRole())")
  Admin updateAdminDTOToDomain(UpdateAdminDTO admin);
  PublicAdminInfoDTO domainToPublicAdminInfoDTO(Admin admin);
  List<PublicAdminInfoDTO> domainListToPublicAdminInfoDTOList(List<Admin> admins);

  default Role setAdminRole(){
    return Role.ADMIN;
  }
}
