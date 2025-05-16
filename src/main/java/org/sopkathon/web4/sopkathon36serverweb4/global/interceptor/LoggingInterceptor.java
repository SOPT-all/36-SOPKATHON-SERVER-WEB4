package org.sopkathon.web4.sopkathon36serverweb4.global.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler) throws Exception {
    System.out.println("[LOG] " + request.getMethod() + " " + request.getRequestURI());
    return true;
  }

  @Override
  public void afterCompletion(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    System.out.println("[LOG] Response Status: " + response.getStatus());
  }
}
