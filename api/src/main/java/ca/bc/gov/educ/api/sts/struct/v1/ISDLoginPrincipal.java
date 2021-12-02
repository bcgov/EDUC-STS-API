package ca.bc.gov.educ.api.sts.struct.v1;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * The type Isd login principal.
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class ISDLoginPrincipal implements Serializable {
  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = -3923367190666388407L;
  /**
   * The Principal id.
   */
  @NonNull
  String principalID;
  /**
   * The Isd roles.
   */
  List<ISDRole> isdRoles;
}
