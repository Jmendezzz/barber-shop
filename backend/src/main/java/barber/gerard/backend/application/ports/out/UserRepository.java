package barber.gerard.backend.application.ports.out;

import barber.gerard.backend.domain.enums.Role;
import barber.gerard.backend.domain.models.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
  User save(User user);
  Optional<User> findById(Long id);
  List<User> findAll();
  List<User> findPaginatedByRole(Role role, int page, int size);
  Optional<User> update(User userUpdated);
  User deleteById(Long id);
  List<User> findByRole(Role role);
  boolean existsById(Long id);
  Optional<User> findByAnyField(String fieldName, String fieldValue);
}
