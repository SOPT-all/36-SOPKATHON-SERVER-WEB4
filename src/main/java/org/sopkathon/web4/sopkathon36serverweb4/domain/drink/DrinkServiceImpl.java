package org.sopkathon.web4.sopkathon36serverweb4.domain.drink;

import lombok.RequiredArgsConstructor;
import org.sopkathon.web4.sopkathon36serverweb4.global.common.enums.ErrorCode;
import org.sopkathon.web4.sopkathon36serverweb4.global.error.exception.ApiException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DrinkServiceImpl implements DrinkService {

  private final DrinkRepository drinkRepository;


  @Override
  public Drink findFirstDrink(final Long drinkId) {

    return drinkRepository.findFirstById(drinkId)
        .orElseThrow(() -> new ApiException(ErrorCode.DRINK_RESULT_NOT_FOUND));
  }
}
