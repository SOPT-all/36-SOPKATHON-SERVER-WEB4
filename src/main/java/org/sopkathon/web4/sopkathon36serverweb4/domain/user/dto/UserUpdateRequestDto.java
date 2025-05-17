package org.sopkathon.web4.sopkathon36serverweb4.domain.user.dto;

import lombok.Builder;

@Builder
public record UserUpdateRequestDto(
        String token,
        String part
) {
}
