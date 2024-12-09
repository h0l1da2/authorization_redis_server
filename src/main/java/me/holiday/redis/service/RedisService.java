package me.holiday.redis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.holiday.redis.api.dto.TokenRes.AccessTokenRes;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {

    private final StringRedisTemplate template;

    public AccessTokenRes getAccessTokenByMemberId(Long memberId) {
        if (memberId == null) {
            throw new RuntimeException();
        }

        String accessToken = template.opsForValue().get(memberId + "_access");

        return new AccessTokenRes(accessToken);
    }

}
