package barber.gerard.backend.infraestructure.adapters.in.http;


import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.infraestructure.mapping.admin.AdminMapper;
import barber.gerard.backend.infraestructure.mapping.admin.PublicAdminInfoDTO;
import barber.gerard.backend.infraestructure.ports.in.AdminInputPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/admins")
public class AdminController {
  private AdminInputPort adminInputPort;

  private AdminMapper adminMapper;

  @GetMapping("/{id}")
  public ResponseEntity<PublicAdminInfoDTO> getAdminById(@PathVariable Long id){
    Optional<Admin> admin = adminInputPort.getAdminById(id);

    //TODO HANDLE EXCEPTION
    return admin
            .map(adm -> new ResponseEntity<>(adminMapper.entityToPublicAdminInfoDTO(adm), HttpStatus.OK))
            .orElseThrow(()-> new RuntimeException("No se encontró el ADMIN"));
  }

}