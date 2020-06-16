/**
 * 
 */
package egovframework.cmmn.interceptor;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author GMTC_JH
 *
 */
public class RequestInterceptor extends HandlerInterceptorAdapter {
  Logger log = LoggerFactory.getLogger(this.getClass());

  @SuppressWarnings("rawtypes")
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    if (log.isDebugEnabled()) {
      log.debug("===================      REQUEST INTERCEPTOR START       ===================");
      log.debug("Request URI\t:  " + request.getRequestURI());

      log.debug("  Request Params -->");
      Enumeration params = request.getParameterNames();
      int paramCnt = 0;
      while (params.hasMoreElements()) {
        paramCnt++;
        String key = (String) params.nextElement();
        String value = request.getParameter(key);

        value = value.isEmpty() ? " " : value;

        log.debug("\t{} : {}", key, value);
      }
      log.debug("  <-- Count : {}", paramCnt);
    }
    log.debug("===================       REQUEST INTERCEPTOR END        ===================");
    return super.preHandle(request, response, handler);
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {

    if (log.isDebugEnabled()) {
      log.debug("===================              REQUEST END             ===================\n\n\n");
    }
  }

}
