package org.sopkathon.web4.sopkathon36serverweb4.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserNameResponseDto;
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

        UserNameResponseDto userNameResponseDto = getUserNameByToken(token);
        System.out.println(userNameResponseDto.userName());
        return new UserSignupResponseDto(token);
    }

    @Override
    public UserSignupResponseDto registerNewMember(UserSignupRequestDto userSignupRequestDto) {
        User newUser = User.builder()
                .name(userSignupRequestDto.name())
                .build();
        User savedUser = userRepository.save(newUser);

        return new UserSignupResponseDto(savedUser.getName());
    }

    @Override
    public UserNameResponseDto getUserNameByToken(String token) {
        // 정적 호출이 아니라, 주입된 jwtTokenProvider 인스턴스를 사용
        String userName = jwtTokenProvider.getUserNameFromToken(token);
        return new UserNameResponseDto(userName);
    }
}
