package barber.gerard.backend.infraestructure.mapping.admin;


import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.infraestructure.entities.AdminEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdminMapper {
  Admin entityToDomain(AdminEntity admin);
  List<Admin> entityListToDomainList(List<AdminEntity> admins);
  AdminEntity domainToEntity(Admin admin);
  @Mapping(target = "password", source = "admin.nid")
  @Mapping(target = "role", expression = "java(barber.gerard.backend.domain.enums.Role.ADMIN)")
  Admin createAdminDTOToDomain(CreateAdminDTO admin);
  Admin updateAdminDTOToDomain(UpdateAdminDTO admin);
  PublicAdminInfoDTO domainToPublicAdminInfoDTO(Admin admin);
  List<PublicAdminInfoDTO> domainListToPublicAdminInfoDTOList(List<Admin> admins);

}
