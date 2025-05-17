package org.sopkathon.web4.sopkathon36serverweb4.domain.options;

import java.util.List;
import org.sopkathon.web4.sopkathon36serverweb4.domain.question.Question;

public interface OptionService {

  List<Option> findOptionsByQuestionIds(List<Long> questionIds);
}
