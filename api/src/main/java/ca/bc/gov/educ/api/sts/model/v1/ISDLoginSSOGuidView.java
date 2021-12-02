package ca.bc.gov.educ.api.sts.model.v1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * The type Isd login sso guid view.
 */
@Entity
@Table(name = "ISD_LOGIN_SSO_GUID_VW")
@Getter
@Setter
@Immutable
public class ISDLoginSSOGuidView implements Serializable {
  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 151233591496796332L;
  /**
   * The Principal id.
   */
  @Id
  @Column(name = "PRINICIPALID")
  String principalId;

  /**
   * The Sso guid.
   */
  @Column(name = "SSOGUID")
  String ssoGuid;

  /**
   * The Type code.
   */
  @Column(name = "TYPECODE")
  String typeCode;
}
