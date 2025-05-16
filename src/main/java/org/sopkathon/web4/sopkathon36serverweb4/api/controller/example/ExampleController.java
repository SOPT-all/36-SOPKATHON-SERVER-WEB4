package org.sopkathon.web4.sopkathon36serverweb4.api.controller.example;

import static org.sopkathon.web4.sopkathon36serverweb4.global.constants.AppConstants.API_PREFIX;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.sopkathon.web4.sopkathon36serverweb4.domain.example.ExampleService;
import org.sopkathon.web4.sopkathon36serverweb4.global.common.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping( API_PREFIX + "/examples")
public class ExampleController {

  private final ExampleService exampleService;

  @GetMapping
  public ResponseEntity<ApiResponse<Valid>> list() {

    return ResponseEntity.ok(ApiResponse.success());
  }
}
