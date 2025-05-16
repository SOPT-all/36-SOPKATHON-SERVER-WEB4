package org.sopkathon.web4.sopkathon36serverweb4.global.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class DotenvConfig {
    @Bean
    public Dotenv dotenv() {
        return Dotenv.load(); // 기본적으로 .env 파일을 로드
    }
}
