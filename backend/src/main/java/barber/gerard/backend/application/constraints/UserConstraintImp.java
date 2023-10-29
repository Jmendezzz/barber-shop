package barber.gerard.backend.application.constraints;

import barber.gerard.backend.application.ports.in.constraints.UserConstraint;
import barber.gerard.backend.application.ports.out.UserRepository;
import barber.gerard.backend.domain.models.User;
import barber.gerard.backend.infraestructure.commons.exceptions.UserException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static barber.gerard.backend.infraestructure.commons.exceptions.messages.UserExceptionMessage.*;

@Component
@AllArgsConstructor
public class UserConstraintImp implements UserConstraint {
  private UserRepository userRepository;
  @Override
  public void validateUserEmail(String email) throws UserException {
    validateUniqueField("email", email, USER_ALREADY_EXISTS_WITH_EMAIL);
  }

  @Override
  public void validateUserNid(String nid) throws UserException {
    validateUniqueField("nid", nid, USER_ALREADY_EXISTS_WITH_NID);
  }

  @Override
  public void validateUserUsername(String username) throws UserException {
    validateUniqueField("username", username, USER_ALREADY_EXISTS_WITH_USERNAME);
  }

  @Override
  public void validateCellphone(String cellphone) throws UserException {
    validateUniqueField("cellphoneNumber", cellphone, USER_ALREADY_EXISTS_WITH_PHONE);
  }

  private void validateUniqueField(String fieldName, String fieldValue, String errorMessage) throws UserException {
    Optional<User> user = userRepository.findByAnyField(fieldName, fieldValue);
    if (user.isPresent()) {
      throw new UserException(errorMessage, HttpStatus.BAD_REQUEST);
    }
  }


}
