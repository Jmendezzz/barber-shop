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
    Optional<AdminEntity> adminEntity = jpaAdminRepository.findById(id);

    return adminEntity
            .map(adm-> adminMapper.entityToDomain(adm));
  }

  @Override
  public List<Admin> findAll() {
    return adminMapper.entityListToDomainList(jpaAdminRepository.findAll());
  }

  @Override
  public Admin update(Admin adminUpdated) {
    AdminEntity adminEntity = adminMapper.domainToEntity(adminUpdated);
    AdminEntity entityUpdated =  jpaAdminRepository.save(adminEntity);
    return adminMapper.entityToDomain(entityUpdated);
  }

  @Override
  public Admin deleteById(Long id) {
    Optional<AdminEntity> admin =  jpaAdminRepository.findById(id);
    //TODO: Handle exception.
    return admin
            .map(adm -> adminMapper.entityToDomain(adm))
            .orElseThrow(()-> new RuntimeException());

  }
}
