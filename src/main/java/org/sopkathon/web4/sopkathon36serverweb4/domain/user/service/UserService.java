package org.sopkathon.web4.sopkathon36serverweb4.domain.user.service;

import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserSignupRequestDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserSignupResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserSignupResponseDto findByName(UserSignupRequestDto userSignupRequestDto);
}
