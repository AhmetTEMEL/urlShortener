package com.example.urlShortener.controller;

import com.example.urlShortener.helper.DecodeUrl;
import com.example.urlShortener.helper.EncyprtUrl;
import com.example.urlShortener.helper.ValidateUrl;
import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/rest/url")
public class URLShortenersController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/{id}")
    public String getUrl(@PathVariable String id){
        return DecodeUrl.decodeUrl(id,stringRedisTemplate);
    }

    @PostMapping()
    public String shortenUrl(@RequestBody String url){
       return EncyprtUrl.encyprtUrl(url,stringRedisTemplate);
    }

}
