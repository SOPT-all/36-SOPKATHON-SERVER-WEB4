package org.sopkathon.web4.sopkathon36serverweb4.global.error.exception;

import org.sopkathon.web4.sopkathon36serverweb4.global.common.enums.ErrorCode;
import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException{

  private final ErrorCode code;

  public ApiException(ErrorCode code) {
    this.code = code;
  }

  public HttpStatus getStatus() {
    return code.getStatus();
  }

  @Override
  public String getMessage() {
    return code.getMessage();
  }

  public ErrorCode getErrorCode() {
    return code;
  }
}
