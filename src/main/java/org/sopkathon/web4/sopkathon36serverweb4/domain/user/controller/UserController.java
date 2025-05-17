package org.sopkathon.web4.sopkathon36serverweb4.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserSignupRequestDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserSignupResponseDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserUpdateRequestDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.service.UserService;
import org.sopkathon.web4.sopkathon36serverweb4.global.common.response.ApiResponse;
import org.sopkathon.web4.sopkathon36serverweb4.global.constants.AppConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppConstants.API_PREFIX + "/users")
public class UserController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<ApiResponse<UserSignupResponseDto>> loginAndSignUp(
      @RequestBody UserSignupRequestDto userSignupRequestDto) {
    return ResponseEntity.ok(
        ApiResponse.success(userService.getOrCreateGetUserToken(userSignupRequestDto)));
  }

  @PatchMapping
  public ResponseEntity<ApiResponse<UserSignupResponseDto>> updateUserPart(
      @RequestBody UserUpdateRequestDto userUpdateRequestDto) {
    return ResponseEntity.ok(
        ApiResponse.success(userService.updateUserPart(userUpdateRequestDto)));
  }


}
