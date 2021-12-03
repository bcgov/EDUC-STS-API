package ca.bc.gov.educ.api.sts.service.v1;

import ca.bc.gov.educ.api.sts.exception.EntityNotFoundException;
import ca.bc.gov.educ.api.sts.model.v1.ISDLoginRolesID;
import ca.bc.gov.educ.api.sts.model.v1.ISDLoginRolesView;
import ca.bc.gov.educ.api.sts.model.v1.ISDLoginSSOGuidView;
import ca.bc.gov.educ.api.sts.repository.v1.ISDLoginRolesViewRepository;
import ca.bc.gov.educ.api.sts.repository.v1.ISDLoginSSOGuidViewRepository;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Sts roles service.
 */
@Service
@Slf4j
public class StsRolesService {

  /**
   * The Sso guid view repository.
   */
  private final ISDLoginSSOGuidViewRepository ssoGuidViewRepository;
  /**
   * The Roles view repository.
   */
  private final ISDLoginRolesViewRepository rolesViewRepository;

  /**
   * Instantiates a new Sts roles service.
   *
   * @param ssoGuidViewRepository the sso guid view repository
   * @param rolesViewRepository   the roles view repository
   */
  public StsRolesService(final ISDLoginSSOGuidViewRepository ssoGuidViewRepository, final ISDLoginRolesViewRepository rolesViewRepository) {
    this.ssoGuidViewRepository = ssoGuidViewRepository;
    this.rolesViewRepository = rolesViewRepository;
  }

  /**
   * Gets login roles by sso guid.
   *
   * @param ssoGuid the sso guid
   * @return the login roles by sso guid
   */
  public List<ISDLoginRolesView> getLoginRolesBySsoGuid(final String ssoGuid) {
    val principalID = this.ssoGuidViewRepository.findBySsoGuid(ssoGuid).orElseThrow(() -> new EntityNotFoundException(ISDLoginSSOGuidView.class, "ssoGuid", ssoGuid)).getPrincipalId();
    return this.rolesViewRepository.findAllByIsdLoginRolesID_PrincipalId(principalID);
  }
}
