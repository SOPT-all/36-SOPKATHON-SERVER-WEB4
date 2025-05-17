package org.sopkathon.web4.sopkathon36serverweb4.api.controller.question;

import static org.sopkathon.web4.sopkathon36serverweb4.global.constants.AppConstants.API_PREFIX;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopkathon.web4.sopkathon36serverweb4.api.service.question.QuestionApiService;
import org.sopkathon.web4.sopkathon36serverweb4.api.service.question.dto.QuestionAnswerDto;
import org.sopkathon.web4.sopkathon36serverweb4.api.service.question.dto.QuestionItemDto;
import org.sopkathon.web4.sopkathon36serverweb4.api.service.question.dto.QuestionRequestDto;
import org.sopkathon.web4.sopkathon36serverweb4.global.common.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(API_PREFIX + "/questions")
public class QuestionController {

  private final QuestionApiService questionService;

  @GetMapping
  public ResponseEntity<ApiResponse<List<QuestionItemDto>>> list() {

    return ResponseEntity.ok(ApiResponse.success(questionService.list()));
  }

  @PostMapping("/answer")
  public ResponseEntity<ApiResponse<QuestionAnswerDto>> answer(
      @RequestBody QuestionRequestDto questionRequestDto) {
    return ResponseEntity.ok(ApiResponse.success(questionService.searchAnswer(questionRequestDto)));
  }
}
