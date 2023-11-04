package barber.gerard.backend.infraestructure.adapters.out.repository.imp;

import barber.gerard.backend.domain.enums.Role;
import barber.gerard.backend.domain.models.User;
import barber.gerard.backend.infraestructure.adapters.out.repository.JpaUserRepository;
import barber.gerard.backend.infraestructure.entities.UserEntity;
import barber.gerard.backend.infraestructure.commons.mapping.user.UserMapper;
import barber.gerard.backend.application.ports.out.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepositoryImp implements UserRepository {
  private JpaUserRepository jpaUserRepository;
  private UserMapper userMapper;
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public User save(User user) {
    UserEntity userEntity = userMapper.domainToEntity(user);
    UserEntity userSaved = jpaUserRepository.save(userEntity);
    return userMapper.entityToDomain(userSaved);
  }

  @Override
  public Optional<User> findById(Long id) {
    Optional<UserEntity> userEntity = jpaUserRepository.findById(id);

    return userEntity
            .map(u -> userMapper.entityToDomain(u));
  }

  @Override
  public List<User> findAll() {
    return userMapper.entityListToDomainList(jpaUserRepository.findAll());
  }

  @Override
  public Optional<User> update(User userUpdated) {
    if(jpaUserRepository.existsById(userUpdated.getId())){
      UserEntity userEntity = userMapper.domainToEntity(userUpdated);
      UserEntity userEntityUpdated = jpaUserRepository.save(userEntity);
      return Optional.of(userMapper.entityToDomain(userEntityUpdated));
    }else{
      return Optional.empty();
    }
  }

  @Override
  public User deleteById(Long id) {
    jpaUserRepository.deleteById(id);
    //TODO: Return User Deleted
    return null;
  }

  @Override
  public List<User> findByRole(Role role) {
    return userMapper.entityListToDomainList(jpaUserRepository.findByRole(role));
  }

  @Override
  public boolean existsById(Long id) {
    return jpaUserRepository.existsById(id);
  }

  @Override
  public Optional<User> findByAnyField(String field, String value) {
    try{
      UserEntity userEntity = entityManager.createQuery("SELECT u FROM UserEntity u WHERE u."+field+" = :value", UserEntity.class)
              .setParameter("value", value)
              .getSingleResult();
      return Optional.of(userMapper.entityToDomain(userEntity));
    }catch (NoResultException e) {
      return Optional.empty();
    }
  }

  @Override
  public List<User> findPaginatedByRole(Role role, int page, int size) {
    return entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.role = :role", UserEntity.class)
            .setParameter("role", role)
            .setFirstResult((page-1) * size)
            .setMaxResults(size)
            .getResultList()
            .stream()
            .map(userEntity -> userMapper.entityToDomain(userEntity))
            .toList();
  }
}
