package com.example.urlShortener.helper;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

public class DecodeUrl {
    public static String decodeUrl(String id,StringRedisTemplate stringRedisTemplate){
        UrlValidator urlValidator = new UrlValidator(
                new String[]{"https","http"}
        );
        return stringRedisTemplate.opsForValue().get(id);
    }
}
