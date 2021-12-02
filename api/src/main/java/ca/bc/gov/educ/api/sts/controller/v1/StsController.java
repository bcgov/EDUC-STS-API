package ca.bc.gov.educ.api.sts.controller.v1;

import ca.bc.gov.educ.api.sts.endpoint.v1.StsEndpoint;
import ca.bc.gov.educ.api.sts.exception.StsRuntimeException;
import ca.bc.gov.educ.api.sts.mappers.v1.StsMapper;
import ca.bc.gov.educ.api.sts.model.v1.ISDLoginRolesView;
import ca.bc.gov.educ.api.sts.service.v1.StsRolesService;
import ca.bc.gov.educ.api.sts.struct.v1.ISDLoginPrincipal;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;


/**
 * Student controller
 *
 * @author John Cox
 */
@RestController
@Slf4j
public class StsController implements StsEndpoint {

  /**
   * The Roles service.
   */
  private final StsRolesService rolesService;

  /**
   * Instantiates a new Sts controller.
   *
   * @param rolesService the roles service
   */
  public StsController(final StsRolesService rolesService) {
    this.rolesService = rolesService;
  }

  /**
   * Gets isd login principal.
   *
   * @param ssoGuid the sso guid
   * @return the isd login principal
   */
  @Override
  public ResponseEntity<ISDLoginPrincipal> getISDLoginPrincipal(final String ssoGuid) {
    val roles = this.rolesService.getLoginRolesBySsoGuid(ssoGuid);
    if (roles.isEmpty()) {
      throw new StsRuntimeException("Roles is empty for ssoGuid: " + ssoGuid);
    }
    return ResponseEntity.ok(new ISDLoginPrincipal(roles.get(0).getIsdLoginRolesID().getPrincipalId(), roles.stream().map(ISDLoginRolesView::getIsdLoginRolesID).map(StsMapper.mapper::toISDRole).collect(Collectors.toList())));
  }
}
