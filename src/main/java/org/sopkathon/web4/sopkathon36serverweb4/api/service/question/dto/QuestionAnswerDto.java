package org.sopkathon.web4.sopkathon36serverweb4.api.service.question.dto;

import lombok.Builder;

@Builder
public record QuestionAnswerDto(
    String userName,
    String imageUrl,
    String location,
    String drinkName,
    String drinkDescription
) {

}
