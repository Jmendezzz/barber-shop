package barber.gerard.backend.application.constraints;

import barber.gerard.backend.application.ports.in.constraints.LocationConstraint;
import barber.gerard.backend.application.ports.out.LocationRepository;
import barber.gerard.backend.infraestructure.commons.exceptions.LocationException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import static barber.gerard.backend.infraestructure.commons.exceptions.messages.LocationExceptionMessage.LOCATION_NOT_FOUND;

@Component
@AllArgsConstructor
public class LocationConstraintImp implements LocationConstraint {
  private LocationRepository locationRepository;
  @Override
  public void doesLocationExist(Long locationId) throws LocationException {
    if (locationId == null) {
      throw new LocationException(LOCATION_NOT_FOUND, HttpStatus.BAD_REQUEST);
    }
    if(!locationRepository.locationExistsById(locationId)){
      throw new LocationException(LOCATION_NOT_FOUND, HttpStatus.NOT_FOUND);
    }

  }
}
