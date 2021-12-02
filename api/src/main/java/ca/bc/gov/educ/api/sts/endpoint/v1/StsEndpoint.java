package ca.bc.gov.educ.api.sts.endpoint.v1;

import ca.bc.gov.educ.api.sts.struct.v1.ISDLoginPrincipal;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static ca.bc.gov.educ.api.sts.constant.v1.URL.STS;

/**
 * The interface Sts endpoint.
 */
@RequestMapping(STS)
@OpenAPIDefinition(info = @Info(title = "API for STS.", description = "This API is related to STs data.", version = "1"),
  security = {@SecurityRequirement(name = "OAUTH2", scopes = {"READ_STS"})})
public interface StsEndpoint {
  /**
   * Gets isd login principal.
   *
   * @param ssoGuid the sso guid
   * @return the isd login principal
   */
  @GetMapping(value = "/{ssoGuid}")
  @PreAuthorize("hasAuthority('SCOPE_READ_STS')")
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "404", description = "NOT FOUND")})
  @Transactional(readOnly = true)
  @Tag(name = "Endpoint to get STs login principal.", description = "STs login principal.")
  ResponseEntity<ISDLoginPrincipal> getISDLoginPrincipal(@PathVariable String ssoGuid);

}
