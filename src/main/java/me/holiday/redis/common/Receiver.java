package me.holiday.redis.common;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Receiver {

    private final AtomicInteger counter = new AtomicInteger();

    public void receiveMessage(String message) {
        log.info("[Redis] 새 메시지 수신");
        counter.incrementAndGet();
    }

    public int getCnt() {
        return counter.get();
    }
}
