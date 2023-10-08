package barber.gerard.backend.infraestructure.adapters.out.repository.imp;

import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.infraestructure.adapters.out.repository.JpaAdminRepository;
import barber.gerard.backend.infraestructure.entities.AdminEntity;
import barber.gerard.backend.infraestructure.mapping.admin.AdminMapper;
import barber.gerard.backend.infraestructure.mapping.config.CycleAvoidingMappingContext;
import barber.gerard.backend.infraestructure.ports.out.AdminRepository;
import barber.gerard.backend.infraestructure.ports.out.LocationRepository;
import barber.gerard.backend.infraestructure.ports.out.UserRepository;
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
    System.out.println(admin);
    Admin adminSaved = adminMapper.userToAdmin(userRepository.save(admin));
    Location location = locationRepository.assignEmplooyeLocation(admin.getManagedLocation().getId(),
                                                                  adminSaved.getId());
    adminSaved.setManagedLocation(location);

    return adminSaved;
  }

  @Override
  public Optional<Admin> findById(Long id) {
    Optional<AdminEntity> adminEntity = jpaAdminRepository.findById(id);

    return adminEntity
            .map(adm-> adminMapper.entityToDomain(adm, new CycleAvoidingMappingContext()));
  }

  @Override
  public List<Admin> findAll() {
    return adminMapper.entityListToDomainList(jpaAdminRepository.findAll(), new CycleAvoidingMappingContext());
  }

  @Override
  public Optional<Admin> update(Admin adminUpdated) {
    if(jpaAdminRepository.existsById(adminUpdated.getId())){
      AdminEntity adminEntity = adminMapper.domainToEntity(adminUpdated, new CycleAvoidingMappingContext());
      AdminEntity entityUpdated =  jpaAdminRepository.save(adminEntity);
      return Optional.of(
              adminMapper.entityToDomain(entityUpdated, new CycleAvoidingMappingContext())
      );
    }else {
      return Optional.empty();
    }

  }

  @Override
  public Admin deleteById(Long id) {
    Optional<AdminEntity> admin =  jpaAdminRepository.findById(id);
    //TODO: Handle exception.
    return admin
            .map(adm -> adminMapper.entityToDomain(adm, new CycleAvoidingMappingContext()))
            .orElseThrow(()-> new RuntimeException());

  }
}
