package org.sopkathon.web4.sopkathon36serverweb4.domain.drinkOption;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.sopkathon.web4.sopkathon36serverweb4.global.common.enums.ErrorCode;
import org.sopkathon.web4.sopkathon36serverweb4.global.error.exception.ApiException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DrinkOptionServiceImpl implements DrinkOptionService {

  private final DrinkOptionRepository drinkOptionRepository;

  @Override
  public Long searchDrinkIdByOptions(final List<Long> optionIds) {

     return drinkOptionRepository.findFirstByOptionIds(optionIds)
         .orElseThrow(
             () -> new ApiException(ErrorCode.DRINK_RESULT_NOT_FOUND)
         )
         .getDrinkId();
  }
}
