package org.sopkathon.web4.sopkathon36serverweb4.domain.options;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sopkathon.web4.sopkathon36serverweb4.domain.question.Question;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OptionServiceImpl implements OptionService {

  private final OptionRepository optionRepository;

  @Override
  public List<Option> findOptionsByQuestionIds(final List<Long> questionIds) {

    return optionRepository.findAllByQuestionIdIn(questionIds);
  }
}
