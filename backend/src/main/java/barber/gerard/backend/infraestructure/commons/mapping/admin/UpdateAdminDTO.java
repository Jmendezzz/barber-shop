package barber.gerard.backend.infraestructure.commons.mapping.admin;

import barber.gerard.backend.infraestructure.commons.mapping.location.LocationDTO;

import java.time.LocalDate;

public record UpdateAdminDTO (
        Long id,
        String firstName,
        String lastName,
        String nid,
        String cellphoneNumber,
        LocalDate birthday,
        String email,
        String password,
        LocationDTO managedLocation

){
}
