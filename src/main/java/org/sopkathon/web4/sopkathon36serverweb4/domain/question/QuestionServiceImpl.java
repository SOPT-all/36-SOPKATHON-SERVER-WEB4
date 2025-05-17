package org.sopkathon.web4.sopkathon36serverweb4.domain.question;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

  private final QuestionRepository questionRepository;


  @Override
  public List<Question> findAllQuestion() {
    return questionRepository.findAll();
  }
}
