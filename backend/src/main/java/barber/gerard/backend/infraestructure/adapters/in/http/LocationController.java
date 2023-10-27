package barber.gerard.backend.infraestructure.adapters.in.http;

import barber.gerard.backend.domain.models.Location;
import barber.gerard.backend.infraestructure.commons.exceptions.LocationException;
import barber.gerard.backend.infraestructure.commons.mapping.location.CreateLocationDTO;
import barber.gerard.backend.infraestructure.commons.mapping.location.LocationDTO;
import barber.gerard.backend.infraestructure.commons.mapping.location.LocationMapper;
import barber.gerard.backend.infraestructure.commons.mapping.location.UpdateLocationDTO;
import barber.gerard.backend.infraestructure.commons.validator.ObjectValidator;
import barber.gerard.backend.application.ports.in.services.LocationInputPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import static barber.gerard.backend.infraestructure.commons.exceptions.messages.LocationExceptionMessage.LOCATION_NOT_FOUND;

@AllArgsConstructor
@RestController
@RequestMapping("/locations")
public class LocationController {
  private LocationInputPort locationInputPort;
  private LocationMapper locationMapper;
  private ObjectValidator objectValidator;
  @PostMapping("/create")
  public ResponseEntity<LocationDTO> createLocation(@RequestBody CreateLocationDTO createLocationDTO){
    objectValidator.validate(createLocationDTO);

    Location location = locationMapper.createLocationDTOToDomain(createLocationDTO);
    Location locationCreated = locationInputPort.createLocation(location);

    return new ResponseEntity<>(
            locationMapper.entityToDTO(locationCreated),
            HttpStatus.CREATED);

  }

  @GetMapping("")
  public ResponseEntity<List<LocationDTO>> getAllLocations(){
    List<LocationDTO> locations =  locationMapper.entityListToDTOList(locationInputPort.getAllLocations());
    return new ResponseEntity<>(
            locations,
            HttpStatus.OK
    );
  }

  @GetMapping("/{id}")
  public ResponseEntity<LocationDTO> getLocationById(@PathVariable Long id){
    Optional<Location> location = locationInputPort.getLocationById(id);
    return location
            .map(loc -> new ResponseEntity<>(
                          locationMapper.entityToDTO(loc),
                          HttpStatus.OK))
            .orElseThrow(()-> new LocationException(LOCATION_NOT_FOUND, HttpStatus.NOT_FOUND));

  }

  @PutMapping("/update")
  public ResponseEntity<LocationDTO> updateLocation(@RequestBody UpdateLocationDTO updateLocationDTO){
    Location locationDomainUpdated = locationMapper.updateLocationDTOToDomain(updateLocationDTO);
    Optional<Location> locationUpdated = locationInputPort.updateLocation(locationDomainUpdated);
    return locationUpdated
            .map(loc -> new ResponseEntity<>(
                          locationMapper.entityToDTO(loc),
                          HttpStatus.OK))
            .orElseThrow(()-> new LocationException(LOCATION_NOT_FOUND, HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<LocationDTO> deleteLocation(@PathVariable Long id){
    Location locationDeleted = locationInputPort.deleteLocationById(id);
    return new ResponseEntity<>(
            locationMapper.entityToDTO(locationDeleted),
            HttpStatus.OK
    );
  }

}
