package barber.gerard.backend.infraestructure.adapters.in.http;

import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.infraestructure.mapping.admin.AdminMapper;
import barber.gerard.backend.infraestructure.mapping.admin.CreateAdminDTO;
import barber.gerard.backend.infraestructure.mapping.admin.PublicAdminInfoDTO;
import barber.gerard.backend.infraestructure.mapping.admin.UpdateAdminDTO;
import barber.gerard.backend.infraestructure.ports.in.AdminInputPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/admins")
public class AdminController {
  private AdminInputPort adminInputPort;

  private AdminMapper adminMapper;

  @PostMapping("/create")
  public ResponseEntity<PublicAdminInfoDTO> createAdmin(@RequestBody CreateAdminDTO createAdminDTO){
    Admin adminDomain = adminMapper.createAdminDTOToEntity(createAdminDTO);
    Admin adminCreated = adminInputPort.createAdmin(adminDomain);

    return new ResponseEntity<>(
            adminMapper.domainToPublicAdminInfoDTO(adminCreated),
            HttpStatus.CREATED);
  }

  @GetMapping("/")
  public ResponseEntity<List<PublicAdminInfoDTO>> getAllAdmins(){
    List<PublicAdminInfoDTO> admins = adminMapper.domainListToPublicAdminInfoDTOList(adminInputPort.getAllAdmins());
    return new ResponseEntity<>(
            admins,
            HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PublicAdminInfoDTO> getAdminById(@PathVariable Long id){
    Optional<Admin> admin = adminInputPort.getAdminById(id);

    //TODO HANDLE EXCEPTION
    return admin
            .map(adm -> new ResponseEntity<>(
                    adminMapper.domainToPublicAdminInfoDTO(adm),
                    HttpStatus.OK))
            .orElseThrow(()-> new RuntimeException("No se encontró el ADMIN"));
  }

  @PutMapping("/update")
  public ResponseEntity<PublicAdminInfoDTO> updateAdmin(@RequestBody UpdateAdminDTO updateAdminDTO){
    Admin adminDomain = adminMapper.updateAdminDTOToEntity(updateAdminDTO);
    Admin adminUpdated = adminInputPort.updateAdmin(adminDomain);

    return new ResponseEntity<>(
            adminMapper.domainToPublicAdminInfoDTO(adminUpdated),
            HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<PublicAdminInfoDTO> deleteAdminById(@PathVariable Long id){
    Admin adminDeleted = adminInputPort.deleteAdminById(id);

    return new ResponseEntity<>(
            adminMapper.domainToPublicAdminInfoDTO(adminDeleted),
            HttpStatus.OK);
  }

}