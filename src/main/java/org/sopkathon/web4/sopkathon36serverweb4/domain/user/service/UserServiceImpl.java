package org.sopkathon.web4.sopkathon36serverweb4.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserSignupRequestDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserSignupResponseDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.entity.User;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private static final int TOKEN_EXPIRY_MINUTES = 60;

    @Override
    public UserSignupResponseDto findByName(UserSignupRequestDto userSignupRequestDto) {
        User user = userRepository
                .findByName(userSignupRequestDto.name())
                .orElseThrow(() -> new IllegalArgumentException(
                        "유효하지 않은 유저입니다.: " + userSignupRequestDto.name()
                ));
        String token = jwtTokenProvider.token(
                user.getId(),
                user.getName(),
                TOKEN_EXPIRY_MINUTES
        );
        return new UserSignupResponseDto(token);
    }

    @Override
    public UserSignupResponseDto registerNewMember(UserSignupRequestDto userSignupRequestDto){
        User newUser = User.builder()
                .name(userSignupRequestDto.name())
                .build();
        User savedUser = userRepository.save(newUser);

        return new UserSignupResponseDto(savedUser.getName());
    }
}
