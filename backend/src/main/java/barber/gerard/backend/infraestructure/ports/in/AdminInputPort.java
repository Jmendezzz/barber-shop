package barber.gerard.backend.infraestructure.ports.in;

import barber.gerard.backend.domain.models.Admin;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface AdminInputPort {
  Admin createAdmin(Admin admin);
  List<Admin> getAllAdmins(Admin admin);
  Optional<Admin> getAdminById(Long id);
  Admin updateAdmin(Admin adminUpdated);
  Admin deleteAdminById(Long id);

}