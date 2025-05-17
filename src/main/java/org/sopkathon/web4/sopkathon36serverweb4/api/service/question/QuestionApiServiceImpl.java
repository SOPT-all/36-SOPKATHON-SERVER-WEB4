package org.sopkathon.web4.sopkathon36serverweb4.api.service.question;

import java.util.List;
import java.util.stream.Stream;
import org.sopkathon.web4.sopkathon36serverweb4.api.service.question.dto.QuestionItemDto;
import org.sopkathon.web4.sopkathon36serverweb4.api.service.question.dto.QuestionItemDto.QuestionOptionDto;
import org.springframework.stereotype.Service;

@Service
public class QuestionApiServiceImpl implements QuestionApiService {

  @Override
  public List<QuestionItemDto> list() {
    return List.of(QuestionItemDto
        .builder()
        .title("어떤 사람과 떠나고 싶나요?")
        .imageUrl("test")
        .options(
            Stream.of("알차게 계획 세고 돌아다니기",
                    "상황 맞춰 즉흥적으로 즐기기"
                ).map(str -> QuestionOptionDto.builder().title(str).id(1L).build())
                .toList()
        )
        .build());
  }
}
