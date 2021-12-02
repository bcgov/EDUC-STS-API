package ca.bc.gov.educ.api.sts.properties;

import lombok.Getter;

/**
 * Class holds all application properties
 *
 * @author Marco Villeneuve
 */
@Getter
public final class ApplicationProperties {
  private ApplicationProperties() {
    throw new IllegalStateException("Utility class");
  }

  public static final String STS_API = "STS-API";
  public static final String CORRELATION_ID = "correlationID";
}
