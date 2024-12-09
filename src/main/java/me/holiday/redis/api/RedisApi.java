package me.holiday.redis.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.holiday.redis.common.Receiver;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/redis")
public class RedisApi {

    private final StringRedisTemplate template;
    private final Receiver receiver;

    @GetMapping
    public void love() throws InterruptedException {
        while (receiver.getCnt() == 0) {
            log.info("[Message] GET");
            template.convertAndSend("chat", "HelloRedis");
            Thread.sleep(500L);
        }
    }
}
