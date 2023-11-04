package barber.gerard.backend.application.ports.out;

import barber.gerard.backend.domain.models.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminRepository {
  Admin save(Admin admin);
  Optional<Admin> findById(Long id);
  List<Admin> findAll();
  List<Admin> findAllPaginated(Integer page, Integer size);
  Optional<Admin> update(Admin adminUpdated);
  Admin deleteById(Long id);
}