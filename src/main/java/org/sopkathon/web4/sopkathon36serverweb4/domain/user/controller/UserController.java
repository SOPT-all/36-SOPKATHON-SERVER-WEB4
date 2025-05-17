package org.sopkathon.web4.sopkathon36serverweb4.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserSignupRequestDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserSignupResponseDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.service.UserService;
import org.sopkathon.web4.sopkathon36serverweb4.global.common.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserSignupResponseDto>> getByName(@RequestBody UserSignupRequestDto userSignupRequestDto) {
        return ResponseEntity.ok(ApiResponse.success(userService.findByName(userSignupRequestDto)));
    }
}
