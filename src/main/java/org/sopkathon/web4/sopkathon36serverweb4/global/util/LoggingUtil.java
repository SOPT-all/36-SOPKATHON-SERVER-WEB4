package org.sopkathon.web4.sopkathon36serverweb4.global.util;


public interface LoggingUtil {

  public void info(String message, Object... data);

  public void error(Exception exception);
}
