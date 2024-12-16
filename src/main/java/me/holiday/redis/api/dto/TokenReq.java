package me.holiday.redis.api.dto;

public record TokenReq(
        Long memberId,
        String access,
        Long accessTime,
        String refresh,
        Long refreshTime
) {
}
