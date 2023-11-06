package barber.gerard.backend.application.services;

import barber.gerard.backend.application.ports.in.constraints.LocationConstraint;
import barber.gerard.backend.application.ports.in.constraints.UserConstraint;
import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.application.ports.in.services.AdminInputPort;
import barber.gerard.backend.application.ports.out.AdminRepository;
import barber.gerard.backend.infraestructure.commons.exceptions.UserException;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
  @CacheEvict(value = "admins", allEntries = true)
  public Admin createAdmin(Admin admin) {
    validateAdmin(admin);
    return adminRepository.save(admin);
  }

  @Override
  @Cacheable("admins")
  public List<Admin> getAllAdmins() {
    return adminRepository.findAll();
  }

  @Override
  @Cacheable("admins")
  public List<Admin> getAllPaginatedAdmins(Integer page, Integer size) {
    return adminRepository.findAllPaginated(page, size);
  }

  @Override
  @Cacheable("admins")
  public Optional<Admin> getAdminById(Long id) {
    return adminRepository.findById(id);
  }

  @Override
  @CacheEvict(value = "admins", allEntries = true)
  public Optional<Admin> updateAdmin(Admin adminUpdated) {
    validateAdmin(adminUpdated);
    return adminRepository.update(adminUpdated);
  }

  @Override
  @CacheEvict(value = "admins", allEntries = true)
  public Admin deleteAdminById(Long id) {
    return adminRepository.deleteById(id);
  }

  private void validateAdmin(Admin admin) throws UserException {
    if(admin.getManagedLocation() != null){
      locationConstraint.doesLocationExist(admin.getManagedLocation().getId());
    }
    userConstraint.validateUserEmail(admin.getEmail());
    userConstraint.validateUserNid(admin.getNid());
    userConstraint.validateCellphone(admin.getCellphoneNumber());
  }
}
