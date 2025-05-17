package org.sopkathon.web4.sopkathon36serverweb4.domain.user.service;

import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserNameResponseDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserSignupRequestDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserSignupResponseDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserUpdateRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserSignupResponseDto getOrCreateGetUserToken(UserSignupRequestDto userSignupRequestDto);

    String getUserNameByToken(String token);
    UserSignupResponseDto registerNewMember(UserSignupRequestDto userSignupRequestDto);

    UserSignupResponseDto updateUserPart(UserUpdateRequestDto userUpdateRequestDto);
}
