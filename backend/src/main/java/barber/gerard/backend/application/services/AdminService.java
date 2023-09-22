package barber.gerard.backend.application.services;

import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.infraestructure.ports.in.AdminInputPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AdminService implements AdminInputPort {
  @Override
  public Admin createAdmin(Admin admin) {
    return null;
  }

  @Override
  public List<Admin> getAllAdmins(Admin admin) {
    return null;
  }

  @Override
  public Optional<Admin> getAdminById(Long id) {
    return Optional.empty();
  }

  @Override
  public Admin updateAdmin(Admin adminUpdated) {
    return null;
  }

  @Override
  public Admin deleteAdminById(Long id) {
    return null;
  }
}
