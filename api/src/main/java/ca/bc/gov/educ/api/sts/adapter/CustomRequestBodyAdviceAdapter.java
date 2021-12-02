package ca.bc.gov.educ.api.sts.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;

/**
 * The type Custom request body advice adapter.
 */
@ControllerAdvice
public class CustomRequestBodyAdviceAdapter extends RequestBodyAdviceAdapter {

  /**
   * The Http servlet request.
   */
  HttpServletRequest httpServletRequest;

  /**
   * Sets http servlet request.
   *
   * @param httpServletRequest the http servlet request
   */
  @Autowired
  public void setHttpServletRequest(final HttpServletRequest httpServletRequest) {
    this.httpServletRequest = httpServletRequest;
  }

  /**
   * Supports boolean.
   *
   * @param methodParameter the method parameter
   * @param type            the type
   * @param aClass          the a class
   * @return the boolean
   */
  @Override
  public boolean supports(@NonNull final MethodParameter methodParameter, @NonNull final Type type, @NonNull final Class<? extends HttpMessageConverter<?>> aClass) {
    return true;
  }

  /**
   * After body read object.
   *
   * @param body          the body
   * @param inputMessage  the input message
   * @param parameter     the parameter
   * @param targetType    the target type
   * @param converterType the converter type
   * @return the object
   */
  @Override
  @NonNull
  public Object afterBodyRead(@NonNull final Object body, @NonNull final HttpInputMessage inputMessage, @NonNull final MethodParameter parameter, @NonNull final Type targetType,
                              @NonNull final Class<? extends HttpMessageConverter<?>> converterType) {
    this.httpServletRequest.setAttribute("payload", body);
    return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
  }
}
