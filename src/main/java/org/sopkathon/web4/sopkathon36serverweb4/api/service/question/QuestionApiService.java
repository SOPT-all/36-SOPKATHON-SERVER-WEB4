package org.sopkathon.web4.sopkathon36serverweb4.api.service.question;

import java.util.List;
import org.sopkathon.web4.sopkathon36serverweb4.api.service.question.dto.QuestionAnswerDto;
import org.sopkathon.web4.sopkathon36serverweb4.api.service.question.dto.QuestionItemDto;
import org.sopkathon.web4.sopkathon36serverweb4.api.service.question.dto.QuestionRequestDto;

public interface QuestionApiService {

  List<QuestionItemDto> list();

  QuestionAnswerDto searchAnswer(QuestionRequestDto questionRequestDto);
}
