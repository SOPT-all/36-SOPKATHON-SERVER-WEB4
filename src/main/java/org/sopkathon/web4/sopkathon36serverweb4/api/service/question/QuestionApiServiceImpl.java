package org.sopkathon.web4.sopkathon36serverweb4.api.service.question;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.sopkathon.web4.sopkathon36serverweb4.api.service.question.dto.QuestionAnswerDto;
import org.sopkathon.web4.sopkathon36serverweb4.api.service.question.dto.QuestionItemDto;
import org.sopkathon.web4.sopkathon36serverweb4.api.service.question.dto.QuestionItemDto.QuestionOptionDto;
import org.sopkathon.web4.sopkathon36serverweb4.api.service.question.dto.QuestionRequestDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.drink.Drink;
import org.sopkathon.web4.sopkathon36serverweb4.domain.drink.DrinkService;
import org.sopkathon.web4.sopkathon36serverweb4.domain.drinkOption.DrinkOptionService;
import org.sopkathon.web4.sopkathon36serverweb4.domain.options.Option;
import org.sopkathon.web4.sopkathon36serverweb4.domain.options.OptionService;
import org.sopkathon.web4.sopkathon36serverweb4.domain.question.Question;
import org.sopkathon.web4.sopkathon36serverweb4.domain.question.QuestionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionApiServiceImpl implements QuestionApiService {

  private final QuestionService questionService;
  private final OptionService optionService;
  private final DrinkOptionService drinkOptionService;
  private final DrinkService drinkService;

  @Override
  public List<QuestionItemDto> list() {

    List<Question> questions = questionService.findAllQuestion();
    List<Long> questionIds = questions.stream().map(Question::getId).toList();
    List<Option> options = optionService.findOptionsByQuestionIds(questionIds);

    Map<Long, List<QuestionOptionDto>> optionsByQuestionId = options.stream()
        .collect(Collectors.groupingBy(
            o -> o.getQuestion().getId(),
            Collectors.mapping(
                o -> QuestionItemDto.QuestionOptionDto.builder()
                    .id(o.getId())
                    .description(o.getDescription())
                    .build(),
                Collectors.toList()
            )
        ));

    return questions.stream()
        .map(q -> QuestionItemDto.builder()
            .title(q.getTitle())
            .options(optionsByQuestionId.getOrDefault(q.getId(), Collections.emptyList()))
            .build())
        .toList();
  }

  @Override
  public QuestionAnswerDto searchAnswer(final QuestionRequestDto questionRequestDto) {
    List<Long> options = questionRequestDto.options();
    Long drinkId = drinkOptionService.searchDrinkIdByOptions(options);
    Drink drink = drinkService.findFirstDrink(drinkId);

    return QuestionAnswerDto.builder()
        .location(drink.getLocation())
        .drinkName(drink.getName())
        .drinkDescription(drink.getDescription())
        .userName("test")
        .build();
  }
}
