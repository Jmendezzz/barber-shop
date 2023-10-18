package barber.gerard.backend.infraestructure.adapters.out.repository.imp;

import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.infraestructure.adapters.out.repository.JpaLocationRepository;
import barber.gerard.backend.infraestructure.entities.LocationEntity;
import barber.gerard.backend.infraestructure.commons.mapping.config.CycleAvoidingMappingContext;
import barber.gerard.backend.infraestructure.commons.mapping.location.LocationMapper;
import barber.gerard.backend.infraestructure.ports.out.LocationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
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
  public Optional<Location> findLocationByEmployeeId(Long employeeId) {
    try{
      Long locationId = (long) entityManager.createNativeQuery("SELECT location_id FROM employee_location WHERE employee_id=?")
              .setParameter(1,employeeId)
              .getSingleResult();
      return findById(locationId);
    }catch (NoResultException ex){
      return Optional.empty();
    }
  }

  @Override
  public void updateEmployeeLocation(Long employeeId, Long updatedLocationId) {
    removeEmployeeLocation(employeeId);
    assignEmplooyeLocation(updatedLocationId,employeeId);
  }

  @Override
  public boolean removeEmployeeLocation(Long employeeId) {
    //TODO: Transaction..
    entityManager.createNativeQuery("DELETE FROM employee_location WHERE employee_id = ? ")
            .setParameter(1,employeeId)
            .executeUpdate();
    return true;
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
