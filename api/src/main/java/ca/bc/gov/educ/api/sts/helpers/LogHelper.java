package ca.bc.gov.educ.api.sts.helpers;

import ca.bc.gov.educ.api.sts.properties.ApplicationProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.lang.NonNull;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Log helper.
 */
@Slf4j
public final class LogHelper {
  /**
   * The constant mapper.
   */
  private static final ObjectMapper mapper = new ObjectMapper();

  /**
   * Instantiates a new Log helper.
   */
  private LogHelper() {

  }

  /**
   * Log server http req response details.
   *
   * @param request  the request
   * @param response the response
   */
  public static void logServerHttpReqResponseDetails(@NonNull final HttpServletRequest request, final HttpServletResponse response) {
    try {
      final int status = response.getStatus();
      val totalTime = Instant.now().toEpochMilli() - (Long) request.getAttribute("startTime");
      final Map<String, Object> httpMap = new HashMap<>();
      httpMap.put("server_http_response_code", status);
      httpMap.put("server_http_request_method", request.getMethod());
      if (StringUtils.isNotBlank(request.getQueryString())) {
        httpMap.put("server_http_query_params", request.getQueryString());
      }
      val correlationID = request.getHeader(ApplicationProperties.CORRELATION_ID);
      if (correlationID != null) {
        httpMap.put("correlation_id", correlationID);
      }
      httpMap.put("server_http_request_url", String.valueOf(request.getRequestURL()));
      httpMap.put("server_http_request_processing_time_ms", totalTime);
      if (request.getAttribute("payload") != null) {
        httpMap.put("server_http_request_payload", String.valueOf(request.getAttribute("payload")));
      }
      httpMap.put("server_http_request_remote_address", request.getRemoteAddr());
      if (StringUtils.isNotBlank(request.getHeader("X-Client-Name"))) {
        httpMap.put("server_http_request_client_name", request.getHeader("X-Client-Name"));
      }
      MDC.putCloseable("httpEvent", mapper.writeValueAsString(httpMap));
      log.info("");
      MDC.clear();
    } catch (final Exception exception) {
      log.error("Exception ", exception);
    }
  }

}
