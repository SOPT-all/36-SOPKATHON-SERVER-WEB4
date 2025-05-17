package org.sopkathon.web4.sopkathon36serverweb4.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserSignupRequestDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserSignupResponseDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserSignupResponseDto findByName(UserSignupRequestDto userSignupRequestDto){
        return new UserSignupResponseDto("test");
    }
}
