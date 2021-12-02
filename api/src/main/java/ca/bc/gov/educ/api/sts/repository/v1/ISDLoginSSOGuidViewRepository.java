package ca.bc.gov.educ.api.sts.repository.v1;

import ca.bc.gov.educ.api.sts.model.v1.ISDLoginSSOGuidView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Isd login sso guid view repository.
 */
@Repository
public interface ISDLoginSSOGuidViewRepository extends JpaRepository<ISDLoginSSOGuidView, String> {
  /**
   * Find by sso guid optional.
   *
   * @param ssoGuid the sso guid
   * @return the optional
   */
  Optional<ISDLoginSSOGuidView> findBySsoGuid(String ssoGuid);
}
