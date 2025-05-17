package org.sopkathon.web4.sopkathon36serverweb4.domain.user.service;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserNameResponseDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserSignupRequestDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserSignupResponseDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto.UserUpdateRequestDto;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.entity.User;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.enums.Part;
import org.sopkathon.web4.sopkathon36serverweb4.domain.user.repository.UserRepository;
import org.sopkathon.web4.sopkathon36serverweb4.global.common.enums.ErrorCode;
import org.sopkathon.web4.sopkathon36serverweb4.global.error.exception.ApiException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final JwtTokenProvider jwtTokenProvider;
  private static final int TOKEN_EXPIRY_MINUTES = 60;

  @Override
  public UserSignupResponseDto getOrCreateGetUserToken(UserSignupRequestDto userSignupRequestDto) {
    // 1. 유저 조회
    Optional<User> optionalUser = userRepository.findByName(userSignupRequestDto.name());

    User user;
    boolean isExistingUser;

    if (optionalUser.isPresent()) {
      // 기존 유저
      user = optionalUser.get();
      isExistingUser = true;
    } else {
      // 신규 유저 생성
      user = userRepository.save(
          User.builder()
              .name(userSignupRequestDto.name())
              .build()
      );
      isExistingUser = false;
    }

    String token = jwtTokenProvider.token(
        user.getId(),
        user.getName(),
        TOKEN_EXPIRY_MINUTES
    );

    return new UserSignupResponseDto(isExistingUser, token);
  }

  @Override
  public UserSignupResponseDto registerNewMember(UserSignupRequestDto userSignupRequestDto) {
    User newUser = User.builder()
        .name(userSignupRequestDto.name())
        .build();
    User savedUser = userRepository.save(newUser);

    return new UserSignupResponseDto(false, savedUser.getName());
  }

  @Override
  public UserSignupResponseDto updateUserPart(final UserUpdateRequestDto userUpdateRequestDto) {

    String name = getUserNameByToken(userUpdateRequestDto.token());
    User user = userRepository.findByName(name)
        .orElseThrow(() -> new ApiException(ErrorCode.USER_NOT_FOUND));
    user.setPart(Part.valueOf(userUpdateRequestDto.part()));
    userRepository.save(user);

    return UserSignupResponseDto.builder().isExistingUser(true).token(userUpdateRequestDto.token())
        .build();
  }

  @Override
  public String getUserNameByToken(String token) {
    // 정적 호출이 아니라, 주입된 jwtTokenProvider 인스턴스를 사용
    return jwtTokenProvider.getUserNameFromToken(token);
  }
}
