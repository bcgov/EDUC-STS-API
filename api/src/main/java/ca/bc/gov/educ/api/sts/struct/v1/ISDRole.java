package ca.bc.gov.educ.api.sts.struct.v1;

import lombok.Data;

import java.io.Serializable;

/**
 * The type Isd role.
 */
@Data
public class ISDRole implements Serializable {
  /**
   * The constant serialVersionUID.
   */
  private static final long serialVersionUID = -6418813121220247401L;
  /**
   * The Principal id.
   */
  String principalId;
  /**
   * The Role.
   */
  String role;
  /**
   * The Role group.
   */
  String roleGroup;
}
