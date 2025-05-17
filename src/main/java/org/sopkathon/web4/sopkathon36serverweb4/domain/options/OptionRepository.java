package org.sopkathon.web4.sopkathon36serverweb4.domain.options;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {

  public List<Option> findAllByQuestionIdIn(List<Long> ids);
}
