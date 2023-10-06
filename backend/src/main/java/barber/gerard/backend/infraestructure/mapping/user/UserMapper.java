package barber.gerard.backend.infraestructure.mapping.user;

import barber.gerard.backend.domain.models.User;
import barber.gerard.backend.infraestructure.entities.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
  User entityToDomain(UserEntity user);
  UserEntity domainToEntity(User user);
  List<User> entityListToDomainList(List<UserEntity> users);
}
