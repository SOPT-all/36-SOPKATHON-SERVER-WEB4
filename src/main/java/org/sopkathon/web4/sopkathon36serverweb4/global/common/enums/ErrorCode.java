package org.sopkathon.web4.sopkathon36serverweb4.global.common.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

  // 500번대 (Server Error)
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "s5000","알 수 없는 서버 오류가 발생했습니다."),
  DRINK_RESULT_NOT_FOUND(HttpStatus.NOT_FOUND, "d40401", "결과를 찾을 수 없습니다."),
  ;

  private final HttpStatus status;
  private final String code;
  private final String message;

  ErrorCode(HttpStatus status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }

}
