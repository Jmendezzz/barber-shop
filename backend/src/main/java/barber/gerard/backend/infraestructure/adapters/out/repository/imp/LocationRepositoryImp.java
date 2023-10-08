package barber.gerard.backend.infraestructure.adapters.out.repository.imp;

import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.infraestructure.adapters.out.repository.JpaLocationRepository;
import barber.gerard.backend.infraestructure.entities.LocationEntity;
import barber.gerard.backend.infraestructure.mapping.config.CycleAvoidingMappingContext;
import barber.gerard.backend.infraestructure.mapping.location.LocationMapper;
import barber.gerard.backend.infraestructure.ports.out.LocationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@AllArgsConstructor
public class LocationRepositoryImp implements LocationRepository {
  private JpaLocationRepository jpaLocationRepository;
  private LocationMapper locationMapper;
  @PersistenceContext
  private EntityManager entityManager;
  @Override
  public Location save(Location location) {
    LocationEntity locationEntity = locationMapper.domainToEntity(location, new CycleAvoidingMappingContext());
    LocationEntity locationSaved = jpaLocationRepository.save(locationEntity);
    return locationMapper.entityToDomain(locationSaved, new CycleAvoidingMappingContext());
  }

  @Override
  public Optional<Location> findById(Long id) {
    Optional<LocationEntity> locationEntity = jpaLocationRepository.findById(id);

    return locationEntity
            .map(loc -> locationMapper.entityToDomain(loc, new CycleAvoidingMappingContext()));
  }

  @Override
  public List<Location> findAll() {
    List<LocationEntity> locationEntities = jpaLocationRepository.findAll();
    return locationMapper.entityListToDomainList(locationEntities, new CycleAvoidingMappingContext());
  }

  @Override
  public Optional<Location> update(Location locationUpdated) {
    if(jpaLocationRepository.existsById(locationUpdated.getId())){
      LocationEntity locationEntity = locationMapper.domainToEntity(locationUpdated, new CycleAvoidingMappingContext());
      LocationEntity entityUpdated = jpaLocationRepository.save(locationEntity);
      return Optional.of(locationMapper.entityToDomain(entityUpdated, new CycleAvoidingMappingContext()));
    }else{
      return Optional.empty();
    }
  }

  @Override
  public Location deleteById(Long id) {
    jpaLocationRepository.deleteById(id);
    //TODO Return Location
    return null;
  }

  @Override
  public Location assignEmplooyeLocation(Long locationId,Long employeeId) {
     entityManager.createNativeQuery("INSERT INTO employee_location (employee_id,location_id) VALUES(?,?)")
                  .setParameter(1,employeeId)
                  .setParameter(2, locationId)
                  .executeUpdate();

    //TODO return Location
    return null;
  }
}
