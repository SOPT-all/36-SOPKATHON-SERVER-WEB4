package org.sopkathon.web4.sopkathon36serverweb4.api.service.question.dto;

import java.util.List;
import lombok.Builder;

@Builder
public record QuestionItemDto(
    String imageUrl,
    String title,
    List<QuestionOptionDto> options
) {

  @Builder
  public record QuestionOptionDto(
      Long id,
      String description
  ) {


  }
}
