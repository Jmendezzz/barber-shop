package barber.gerard.backend.application.ports.in.constraints;

import barber.gerard.backend.infraestructure.commons.exceptions.LocationException;

public interface LocationConstraint {
  void doesLocationExist(Long locationId) throws LocationException;

}
