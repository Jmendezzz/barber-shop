package barber.gerard.backend.infraestructure.adapters.out.repository;

import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.infraestructure.entities.AdminEntity;
import barber.gerard.backend.infraestructure.mapping.admin.AdminMapper;
import barber.gerard.backend.infraestructure.ports.out.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class AdminRepositoryImp implements AdminRepository {
  private JpaAdminRepository jpaAdminRepository;
  private AdminMapper adminMapper;

  @Override
  public Admin save(Admin admin) {
    AdminEntity adminEntity = adminMapper.domainToEntity(admin);
    AdminEntity entitySaved =  jpaAdminRepository.save(adminEntity);
    return adminMapper.entityToDomain(entitySaved);
  }

  @Override
  public Optional<Admin> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public List<Admin> findAll() {
    return null;
  }

  @Override
  public Optional<Admin> update(Admin adminUpdated) {
    return Optional.empty();
  }

  @Override
  public Admin deleteById(Long id) {
    return null;
  }
}
