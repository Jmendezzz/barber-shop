package barber.gerard.backend.application.ports.in.services;

import barber.gerard.backend.domain.models.Admin;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface AdminInputPort {
  Admin createAdmin(Admin admin);
  List<Admin> getAllAdmins();
  List<Admin> getPaginatedAdmins(Integer page, Integer size);
  Optional<Admin> getAdminById(Long id);
  Optional<Admin> updateAdmin(Admin adminUpdated);
  Admin deleteAdminById(Long id);

}
