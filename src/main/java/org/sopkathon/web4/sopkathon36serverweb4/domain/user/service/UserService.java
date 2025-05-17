package org.sopkathon.web4.sopkathon36serverweb4.domain.user.service;

import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserNameResponseDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserSignupRequestDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserSignupResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserSignupResponseDto getOrCreateGetUserToken(UserSignupRequestDto userSignupRequestDto);
    UserNameResponseDto getUserNameByToken(String token);
    UserSignupResponseDto registerNewMember(UserSignupRequestDto userSignupRequestDto);
}
