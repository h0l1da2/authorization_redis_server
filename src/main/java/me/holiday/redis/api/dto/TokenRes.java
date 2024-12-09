package me.holiday.redis.api.dto;

public record TokenRes() {
    public record AccessTokenRes(
            String accessToken
    ) {

    }
}
