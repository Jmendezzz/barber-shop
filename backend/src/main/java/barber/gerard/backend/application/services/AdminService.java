package barber.gerard.backend.application.services;

import barber.gerard.backend.application.ports.in.constraints.LocationConstraint;
import barber.gerard.backend.application.ports.in.constraints.UserConstraint;
import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.application.ports.in.services.AdminInputPort;
import barber.gerard.backend.application.ports.out.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class AdminService implements AdminInputPort {
  private AdminRepository adminRepository;
  private LocationConstraint locationConstraint;
  private UserConstraint userConstraint;
  @Override
  public Admin createAdmin(Admin admin) {
    if(admin.getManagedLocation() != null){
      locationConstraint.doesLocationExist(admin.getManagedLocation().getId());
    }
    userConstraint.validateUserEmail(admin.getEmail());
    userConstraint.validateUserNid(admin.getNid());
    userConstraint.validateCellphone(admin.getCellphoneNumber());

    return adminRepository.save(admin);
  }

  @Override
  public List<Admin> getAllAdmins() {
    return adminRepository.findAll();
  }

  @Override
  public List<Admin> getAllPaginatedAdmins(Integer page, Integer size) {
    return adminRepository.findAllPaginated(page, size);
  }

  @Override
  public Optional<Admin> getAdminById(Long id) {
    return adminRepository.findById(id);
  }

  @Override
  public Optional<Admin> updateAdmin(Admin adminUpdated) {
    locationConstraint.doesLocationExist(adminUpdated.getManagedLocation().getId());

    return adminRepository.update(adminUpdated);
  }

  @Override
  public Admin deleteAdminById(Long id) {
    return adminRepository.deleteById(id);
  }
}
