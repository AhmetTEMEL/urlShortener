package com.example.urlShortener.helper;

import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.nio.charset.StandardCharsets;

public class ValidateUrl {

    public static boolean validateUrl(String url){
        UrlValidator urlValidator = new UrlValidator(
                new String[]{"https","http"}
        );
        if (urlValidator.isValid(url)){
            return true;
        }
        else return false;
    }
}
