package org.sopkathon.web4.sopkathon36serverweb4.global.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public record ApiResponse<T>(
    String code,
    String message,
    T data
) {

  public static <T> ApiResponse<T> success() {
    return new ApiResponse<>("S2000", "요청이 성공했습니다.", null);
  }

  public static <T> ApiResponse<T> success(T data) {
    return new ApiResponse<>("S2000", "요청이 성공했습니다.", data);
  }

  public static <T> ApiResponse<T> error(String code, String message) {
    return new ApiResponse<>(code, message, null);
  }
}
