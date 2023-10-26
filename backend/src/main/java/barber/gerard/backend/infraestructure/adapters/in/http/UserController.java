package barber.gerard.backend.infraestructure.adapters.in.http;

import barber.gerard.backend.application.ports.in.UserInputPort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
  private UserInputPort userInputPort;
}
