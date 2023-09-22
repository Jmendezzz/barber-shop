package barber.gerard.backend.infraestructure.ports.out;

import barber.gerard.backend.domain.models.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminRepository {
  Admin save(Admin admin);
  Optional<Admin> findById(Long id);
  List<Admin> findAll();
  Optional<Admin> update(Admin adminUpdated);
  Admin deleteById(Long id);

}
