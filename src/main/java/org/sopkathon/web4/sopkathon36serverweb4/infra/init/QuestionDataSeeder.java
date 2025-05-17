package org.sopkathon.web4.sopkathon36serverweb4.infra.init;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
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
    List<Drink> dummyDrinks = IntStream.rangeClosed(1, 16)
        .mapToObj(i -> {
          String[][] data = {
              {"맑은내일 벚꽃주", "봄이되면 떠오르는 벚꽃의 색감과 향을 담은 달콤한 술, 청주 스타일, 진해군항제 기념주", "창원시"},
              {"장생도라지약주", "진주 지역의 특산물인 다년생 도라지를 활용. 건강 기능성과 전통의 맛을 동시에 즐길 수 있음", "진주시"},
              {"해원 소주", "바닷바람을 맞고 자란 섬 고구마를 활용한 증류식 소주.", "통영시"},
              {"키위와인: 7004S", "사천산 참다래로 만든 새콤달콤한 맛과 상큼한 향이 특징인 국내 유일의 키위 와인", "사천시"},
              {"김해 가야 막걸리", "감미료를 넣지 않고 쌀·물·누룩·효모만 사용해 깊고 부드러운 단맛, 참외와 꽃향, 아로마가 돋보임", "김해시"},
              {"밀양 딸기 아랑주", "딸기·쌀을 발효해 60일 저온 숙성하고 무첨가로 만든 고소·크리미한 분홍빛 프리미엄 막걸리", "밀양시"},
              {"행운 생유자 동동주", "따가운 햇살과 해풍을 맞고 건강하게 자란 100% 국내산 유자를 활용하여 만든 시트러스 막걸리.", "거제시"},
              {"물금 사과막걸리", "단맛이 거의 없고, 걸쭉한 질감과 은은한 사과향이 더해진 전통 생막걸리", "양산시"},
              {"달홀주", "옛방식 그대로 생쌀을 씻고 쪄서 만드는 효모균이 살아있는 건강한 생막걸리", "고성군"},
              {"울금막걸리", "남해산 울금을 삶아 쓴맛 없이 고소·부드럽고 유산균 생막걸리.", "남해군"},
              {"하동 꿀배주", "하동 배·벌꿀로 만든 리큐르, 청량·달콤해 아이스크림 같은 맛의 리큐르", "하동군"},
              {"솔송주", "함양의 개평마을 하동정씨 집안에서 500년간 제조법이 대대로 전해져 내려온 전통 프리미엄 약주.", "함양군"},
              {"부자막걸리", "53년 전통의 가업을 잇는 맛, 노동 후 허기짐과 목마름을 한 번에 해소시켜주는 의령의 대표 막걸리.", "의령군"},
              {"단감명작", "잘 익은 단감과 효모, 기다림의 시간으로 화이트 와인을 닮은 깨끗한 단감 와인.", "창녕군"},
              {"화비", "함안 낙화놀이서 영감 얻은 로스팅 찹쌀 막걸리 ‘화비’, 구수달달하며 매콤·짭짤 안주와 잘 어울림.", "함안군"},
              {"산내울 오미자주", "거창의 지역농가에서 직접 재배한 과실로 만들어 오미자의 오미를 잘 나타낸 술", "거창군"}
          };
          int idx = i - 1;
          return Drink.builder()
              .name(data[idx][0])
              .description(data[idx][1])
              .location(data[idx][2])
              .imageLink("image" + i + ".png")
              .build();
        })
        .toList();

    questionRepository.saveAll(dummyQuestions);
    optionRepository.saveAll(dummyOptions);
    drinkRepository.saveAll(dummyDrinks);

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
                .drink(drink)     // 엔티티 자체로 전달
                .option(option)   // 엔티티 자체로 전달
                .build()
        );
      }
    }

// 저장
    drinkOptionRepository.saveAll(drinkOptions);
  }
}
