package ca.bc.gov.educ.api.sts.model.v1;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * The type Isd login roles id.
 */
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ISDLoginRolesID implements Serializable {
  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = 2428579416805274498L;
  /**
   * The Principal id.
   */
  @Column(name = "PRINICIPALID")
  @NonNull
  String principalId;

  /**
   * The Role.
   */
  @Column(name = "ROLE")
  String role;

  /**
   * The Role group.
   */
  @Column(name = "ROLEGROUP")
  String roleGroup;
}
