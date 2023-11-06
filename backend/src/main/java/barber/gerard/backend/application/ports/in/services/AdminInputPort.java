package barber.gerard.backend.application.ports.in.services;

import barber.gerard.backend.domain.models.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminInputPort {
  Admin createAdmin(Admin admin);
  List<Admin> getAllAdmins();
  List<Admin> getAllPaginatedAdmins(Integer page, Integer size);
  Optional<Admin> getAdminById(Long id);
  Optional<Admin> updateAdmin(Admin adminUpdated);
  Admin deleteAdminById(Long id);

}
