package barber.gerard.backend.infraestructure.adapters.in.http;

import barber.gerard.backend.domain.models.Admin;
import barber.gerard.backend.infraestructure.commons.exceptions.AdminException;
import barber.gerard.backend.infraestructure.commons.mapping.admin.AdminMapper;
import barber.gerard.backend.infraestructure.commons.mapping.admin.CreateAdminDTO;
import barber.gerard.backend.infraestructure.commons.mapping.admin.PublicAdminInfoDTO;
import barber.gerard.backend.infraestructure.commons.mapping.admin.UpdateAdminDTO;
import barber.gerard.backend.infraestructure.commons.validator.ObjectValidator;
import barber.gerard.backend.application.ports.in.AdminInputPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import static barber.gerard.backend.infraestructure.commons.exceptions.messages.AdminExceptionMessage.ADMIN_NOT_FOUND;

@RestController
@AllArgsConstructor
@RequestMapping("/admins")
public class AdminController {
  private AdminInputPort adminInputPort;
  private AdminMapper adminMapper;
  private ObjectValidator objectValidator;

  @PostMapping("/create")
  public ResponseEntity<PublicAdminInfoDTO> createAdmin(@RequestBody CreateAdminDTO createAdminDTO){
    objectValidator.validate(createAdminDTO);
    Admin adminDomain = adminMapper.createAdminDTOToDomain(createAdminDTO);
    Admin adminCreated = adminInputPort.createAdmin(adminDomain);

    return new ResponseEntity<>(
            adminMapper.domainToPublicAdminInfoDTO(adminCreated),
            HttpStatus.CREATED);
  }

  @GetMapping("")
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
            .orElseThrow(()-> new AdminException(ADMIN_NOT_FOUND,HttpStatus.NOT_FOUND));
  }

  @PutMapping("/update")
  public ResponseEntity<PublicAdminInfoDTO> updateAdmin(@RequestBody UpdateAdminDTO updateAdminDTO){
    objectValidator.validate(updateAdminDTO);

    Admin adminDomainUpdated = adminMapper.updateAdminDTOToDomain(updateAdminDTO);
    Optional<Admin> adminUpdated = adminInputPort.updateAdmin(adminDomainUpdated);

    return adminUpdated
            .map(adm -> new ResponseEntity<>(
                          adminMapper.domainToPublicAdminInfoDTO(adm),
                          HttpStatus.OK))
            .orElseThrow(()-> new AdminException(ADMIN_NOT_FOUND,HttpStatus.NOT_FOUND));

  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<PublicAdminInfoDTO> deleteAdminById(@PathVariable Long id){
    Admin adminDeleted = adminInputPort.deleteAdminById(id);

    return new ResponseEntity<>(
            adminMapper.domainToPublicAdminInfoDTO(adminDeleted),
            HttpStatus.OK);
  }

}