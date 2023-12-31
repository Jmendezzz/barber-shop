package barber.gerard.backend.infraestructure.adapters.out.repository.imp;

import barber.gerard.backend.domain.enums.Role;
import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.domain.models.User;
import barber.gerard.backend.infraestructure.adapters.out.repository.JpaAdminRepository;
import barber.gerard.backend.infraestructure.commons.mapping.admin.AdminMapper;
import barber.gerard.backend.application.ports.out.AdminRepository;
import barber.gerard.backend.application.ports.out.LocationRepository;
import barber.gerard.backend.application.ports.out.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class AdminRepositoryImp implements AdminRepository {
  private JpaAdminRepository jpaAdminRepository;
  private AdminMapper adminMapper;
  private UserRepository userRepository;
  private LocationRepository locationRepository;
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Admin save(Admin admin) {
    Admin adminSaved = adminMapper.userToAdmin(userRepository.save(admin));
    if(admin.getManagedLocation() != null){
      Location location = locationRepository.assignEmplooyeLocation(admin.getManagedLocation().getId(),
              adminSaved.getId());
      adminSaved.setManagedLocation(location);
    }
    return adminSaved;
  }

  @Override
  public Optional<Admin> findById(Long id) {
    Optional<User> user = userRepository.findById(id);
    if(user.isPresent()){
      Admin adminDomain = adminMapper.userToAdmin(user.get());
      adminDomain.setManagedLocation(getAdminLocation(adminDomain));

      return Optional.of(adminDomain);
    }else{
      return Optional.empty();
    }
  }

  @Override
  public List<Admin> findAll() {
    List<Admin> admins = adminMapper.userListToAdminList(userRepository.findByRole(Role.ADMIN));
    admins.parallelStream()
            .forEach(admin->admin.setManagedLocation(getAdminLocation(admin)));

    return admins;
  }

  @Override
  public List<Admin> findAllPaginated(Integer page, Integer size) {
    List<Admin> admins = adminMapper.userListToAdminList(userRepository.findPaginatedByRole(Role.ADMIN, page, size));
    admins.parallelStream()
            .forEach(admin->admin.setManagedLocation(getAdminLocation(admin)));

    return admins;
  }

  @Override
  public Optional<Admin> update(Admin adminUpdated) {
    if(userRepository.existsById(adminUpdated.getId())){
      Optional<User> userUpdated = userRepository.update(adminMapper.adminToUser(adminUpdated));
      updateAdminLocation(adminUpdated);

      return userUpdated.map(u-> adminMapper.userToAdmin(u));
    }else {
      return Optional.empty();
    }
  }

  @Override
  public Admin deleteById(Long id) {
    locationRepository.removeEmployeeLocation(id);
    userRepository.deleteById(id);
    //TODO: Return admin.
    return null;
  }

  private Location getAdminLocation(Admin admin){
    Optional<Location> adminManagedLocation = locationRepository.findLocationByEmployeeId(admin.getId());
    return adminManagedLocation.orElse(null);
  }
  private void updateAdminLocation(Admin admin){
    if(admin.getManagedLocation() != null){
      locationRepository.updateEmployeeLocation(admin.getId(),
                                                admin.getManagedLocation().getId());
    }else{
      locationRepository.removeEmployeeLocation(admin.getId());
    }
  }
}
