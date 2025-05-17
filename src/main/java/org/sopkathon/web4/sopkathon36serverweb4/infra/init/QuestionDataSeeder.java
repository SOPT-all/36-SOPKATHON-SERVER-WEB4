package org.sopkathon.web4.sopkathon36serverweb4.infra.init;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.sopkathon.web4.sopkathon36serverweb4.domain.drink.Drink;
import org.sopkathon.web4.sopkathon36serverweb4.domain.drink.DrinkRepository;
import org.sopkathon.web4.sopkathon36serverweb4.domain.drinkOption.DrinkOption;
import org.sopkathon.web4.sopkathon36serverweb4.domain.drinkOption.DrinkOptionRepository;
import org.sopkathon.web4.sopkathon36serverweb4.domain.options.Option;
import org.sopkathon.web4.sopkathon36serverweb4.domain.options.OptionRepository;
import org.sopkathon.web4.sopkathon36serverweb4.domain.question.Question;
import org.sopkathon.web4.sopkathon36serverweb4.domain.question.QuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@RequiredArgsConstructor
public class QuestionDataSeeder implements CommandLineRunner {

  private final QuestionRepository questionRepository;
  private final OptionRepository optionRepository;
  private final DrinkRepository drinkRepository;
  private final DrinkOptionRepository drinkOptionRepository;

  @Override
  @Transactional
  public void run(final String... args) throws Exception {

    if (questionRepository.count() > 0) {
      return;
    }

    // 1. 더미 질문 생성
    List<Question> dummyQuestions = Stream.of(
            "어떤 사람과 떠나고 싶나요?",
            "선호 풍경",
            "고르실 때는?",
            "음주량"
        ).map(str -> Question.builder().title(str).build())
        .toList();

// 2. 옵션 설명
    List<String> optionDescriptions = List.of(
        "알차게 계획 세우고 돌아다니기",    // 0
        "상황에 맞춰 즉흥적으로 즐기기",    // 1
        "푸른 숲·산속 풍경",              // 2
        "시원한 해변·호숫가",              // 3
        "새로운 전통주도 도전해볼래요",      // 4
        "익숙한 게 좋아요",                // 5
        "기분 좋을 정도로 가볍게 마셔요",    // 6
        "많이 마셔요"                     // 7
    );

// 3. 옵션을 질문별로 묶어서 생성 (매핑)
    List<Option> dummyOptions = new ArrayList<>();
    for (int i = 0; i < dummyQuestions.size(); i++) {
      Question question = dummyQuestions.get(i);
      // 각 질문에 대해 2개씩 옵션 생성
      int start = i * 2;
      int end = start + 2;
      for (int j = start; j < end; j++) {
        dummyOptions.add(
            Option.builder()
                .description(optionDescriptions.get(j))
                .question(question)
                .build()
        );
      }
    }
    List<Drink> dummyDrinks = Stream.of(
        new String[]{"맑은내일 벚꽃주", "창원시"},
        new String[]{"장생도라지약주", "진주시"},
        new String[]{"해원 소주", "통영시"},
        new String[]{"키위와인: 7004S", "사천시"},
        new String[]{"김해 가야 막걸리", "김해시"},
        new String[]{"밀양 딸기 아랑주", "밀양시"},
        new String[]{"행운 생유자 동동주", "거제시"},
        new String[]{"물금 사과막걸리", "양산시"},
        new String[]{"달홀주", "고성군"},
        new String[]{"울금막걸리", "남해군"},
        new String[]{"하동 꿀배주", "하동군"},
        new String[]{"솔송주", "함양군"},
        new String[]{"부자막걸리", "의령군"},
        new String[]{"단감명작", "창녕군"},
        new String[]{"화비", "함안군"},
        new String[]{"산내울 오미자주", "거창군"}
    ).map(arr -> Drink.builder()
        .name(arr[0])
        .location(arr[1])
        .description(null)
        .build()
    ).toList();

    questionRepository.saveAll(dummyQuestions);
    optionRepository.saveAll(dummyOptions);
    drinkRepository.saveAll(dummyDrinks);

    // drinks, options: id 오름차순 정렬된 리스트 (실제 DB PK 순서)
    List<Drink> drinks = drinkRepository.findAll(Sort.by("id")); // size 16
    List<Option> options = optionRepository.findAll(Sort.by("id")); // size 8

    int numQuestions = 4;
    int optionsPerQuestion = 2;

    List<DrinkOption> drinkOptions = new ArrayList<>();

    for (int drinkIdx = 0; drinkIdx < drinks.size(); drinkIdx++) {
      Drink drink = drinks.get(drinkIdx); // 실제 DB drink 엔티티
      for (int q = 0; q < numQuestions; q++) {
        int optionGroupStart = q * optionsPerQuestion;
        int selected = (drinkIdx >> q) & 1; // 0 or 1
        int optionIdx = optionGroupStart + selected;
        Option option = options.get(optionIdx); // 실제 DB option 엔티티
        drinkOptions.add(
            DrinkOption.builder()
                .drinkId(drink.getId())   // 실제 DB id 사용
                .optionId(option.getId()) // 실제 DB id 사용
                .build()
        );
      }
    }

// 저장
    drinkOptionRepository.saveAll(drinkOptions);
  }
}
