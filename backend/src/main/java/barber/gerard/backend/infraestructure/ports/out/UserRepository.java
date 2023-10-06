package barber.gerard.backend.infraestructure.ports.out;

import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.domain.models.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
  User save(User user);
  Optional<User> findById(Long id);
  List<User> findAll();
  Optional<User> update(User userUpdated);
  User deleteById(Long id);
}
