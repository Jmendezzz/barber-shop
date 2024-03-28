package barber.gerard.backend.infraestructure.commons.mapping.auth;
import java.time.LocalDate;
//TODO Add validations
public record AuthSignUpRequest(

        String firstName,
        String lastName,
        String cellphoneNumber,
        LocalDate birthday,
        String email,
        String password
) {

}
