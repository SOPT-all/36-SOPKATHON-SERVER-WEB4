package org.sopkathon.web4.sopkathon36serverweb4.global.config;

import org.sopkathon.web4.sopkathon36serverweb4.global.util.LoggingUtil;
import org.sopkathon.web4.sopkathon36serverweb4.global.util.SystemPrintLoggingUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {

  @Bean
  public LoggingUtil loggingUtil() {
    return new SystemPrintLoggingUtil();
  }
}
