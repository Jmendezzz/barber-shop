package barber.gerard.backend.infraestructure.adapters.out.repository;

import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.infraestructure.entities.LocationEntity;
import barber.gerard.backend.infraestructure.mapping.location.LocationMapper;
import barber.gerard.backend.infraestructure.ports.out.LocationRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class LocationRepositoryImp implements LocationRepository {
  //TODO: Mapper
  private JpaLocationRepository jpaLocationRepository;
  private LocationMapper locationMapper;

  @Override
  public Location save(Location location) {
    LocationEntity locationEntity = locationMapper.domainToEntity(location);
    LocationEntity locationSaved = jpaLocationRepository.save(locationEntity);
    return locationMapper.entityToDomain(locationSaved);
  }

  @Override
  public Optional<Location> findById(Long id) {
    Optional<LocationEntity> locationEntity = jpaLocationRepository.findById(id);

    return locationEntity
            .map(loc -> locationMapper.entityToDomain(loc));
  }

  @Override
  public List<Location> findAll() {
    List<LocationEntity> locationEntities = jpaLocationRepository.findAll();
    return locationMapper.entityListToDomainList(locationEntities);
  }

  @Override
  public Optional<Location> update(Location locationUpdated) {
    if(jpaLocationRepository.existsById(locationUpdated.getId())){
      LocationEntity locationEntity = locationMapper.domainToEntity(locationUpdated);
      LocationEntity entityUpdated = jpaLocationRepository.save(locationEntity);
      return Optional.of(locationMapper.entityToDomain(entityUpdated));
    }else{
      return Optional.empty();
    }
  }

  @Override
  public Location deleteById(Long id) {
    return null;
  }
}
