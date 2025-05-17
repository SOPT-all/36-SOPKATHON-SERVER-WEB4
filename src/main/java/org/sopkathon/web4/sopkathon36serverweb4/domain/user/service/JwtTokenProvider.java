package org.sopkathon.web4.sopkathon36serverweb4.domain.user.service;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.sopkathon.web4.sopkathon36serverweb4.global.constants.JwtTokenConstants;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;

import java.util.Date;


@Component
public class JwtTokenProvider {
    private static final long MILLIS_IN_MINUTE = 60000;

    String token(Long userId, String userName, int expMinutes) {

        Date expireAt = new Date(System.currentTimeMillis() + MILLIS_IN_MINUTE + expMinutes);

        return JWT.create()
                .withSubject(String.valueOf(userId))
                .withClaim("userName", userName)
                .withExpiresAt(expireAt)
                .sign(Algorithm.HMAC512(JwtTokenConstants.SECRET_KEY));
    }

    //  토큰에서 userName 클레임을 파싱해서 반환하는 부분
    public String getUserNameFromToken(String token){
        DecodedJWT jwt = JWT.require(Algorithm.HMAC512(JwtTokenConstants.SECRET_KEY)).build().verify(token);
        return jwt.getClaim("userName").asString();
    }
}
