package org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto;

public record UserSignupResponseDto(
        boolean isExistingUser,
        String token
){}
