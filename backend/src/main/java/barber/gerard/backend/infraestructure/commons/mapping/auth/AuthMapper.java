package barber.gerard.backend.infraestructure.commons.mapping.auth;

import barber.gerard.backend.domain.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {
  User signUpRequestToUser(AuthSignUpRequest signUpRequest);
}
