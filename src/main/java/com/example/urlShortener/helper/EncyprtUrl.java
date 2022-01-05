package com.example.urlShortener.helper;

import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.nio.charset.StandardCharsets;

public class EncyprtUrl {


    public static String encyprtUrl(String url,StringRedisTemplate stringRedisTemplate){
        if (ValidateUrl.validateUrl(url)){
            String encryptedUrl = Hashing.murmur3_32_fixed().hashString(url, StandardCharsets.UTF_8).toString();
            stringRedisTemplate.opsForValue().set(encryptedUrl,url);
            return encryptedUrl;
        }
        throw new RuntimeException("invalid url ..");
    }
}
