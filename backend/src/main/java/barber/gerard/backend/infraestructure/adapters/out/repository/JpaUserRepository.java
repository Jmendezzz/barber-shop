package barber.gerard.backend.infraestructure.adapters.out.repository;

import barber.gerard.backend.domain.enums.Role;
import barber.gerard.backend.infraestructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserEntity,Long> {
  @Query("SELECT u FROM UserEntity u WHERE u.role = :rol")
  List<UserEntity> findByRole(@Param("rol") Role rol);

  Optional<UserEntity> findByEmail(String email);
}
