package ca.bc.gov.educ.api.sts.model.v1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Immutable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The type Isd login roles view.
 */
@Entity
@Table(name = "ISD_LOGIN_ROLES_VW")
@Getter
@Setter
@Immutable
public class ISDLoginRolesView implements Serializable {
  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = -6785276100057639554L;
  /**
   * The Isd login roles id.
   */
  @EmbeddedId
  private ISDLoginRolesID isdLoginRolesID;
}
