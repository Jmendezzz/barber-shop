package barber.gerard.backend.application.ports.in.constraints;

import barber.gerard.backend.infraestructure.commons.exceptions.UserException;

public interface UserConstraint {
  void validateUserEmail(String email) throws UserException;
  void validateUserNid(String nid) throws UserException;
  void validateUserUsername(String username) throws UserException;
  void validateCellphone(String cellphone) throws UserException;
}
