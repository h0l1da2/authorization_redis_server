package me.holiday.redis.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.holiday.redis.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static me.holiday.redis.api.dto.TokenRes.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/redis/api/v1")
public class RedisApi {

    private final RedisService redisService;

    @GetMapping("/access-token")
    public AccessTokenRes tokenReq(@RequestParam Long memberId) {
        return redisService.getAccessTokenByMemberId(memberId);
    }
}
