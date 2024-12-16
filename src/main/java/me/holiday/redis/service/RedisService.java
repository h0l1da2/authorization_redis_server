package me.holiday.redis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.holiday.redis.api.dto.TokenReq;
import me.holiday.redis.api.dto.TokenRes;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {

    private final StringRedisTemplate template;

    public TokenRes.AccessTokenRes getAccessTokenByMemberId(final Long memberId) {
        return new TokenRes.AccessTokenRes(template.opsForValue().get(memberId + "_access"));
    }

    public void saveToken(TokenReq tokenReq) {
        template.opsForValue().set(
                tokenReq.memberId() + "_access",
                tokenReq.access(),
                Duration.ofSeconds(tokenReq.accessTime()));

        template.opsForValue().set(
                tokenReq.memberId() + "_refresh",
                tokenReq.refresh(),
                Duration.ofSeconds(tokenReq.refreshTime()));

        log.info("[Token] 저장 성공");
    }
}
