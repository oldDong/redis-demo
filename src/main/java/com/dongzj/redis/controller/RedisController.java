package com.dongzj.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: dongzj
 * Mail: dongzj@shinemo.com
 * Date: 2018/10/23
 * Time: 14:26
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/set")
    public void set() {
        redisTemplate.opsForValue().set("test", "4321");
        stringRedisTemplate.opsForValue().set("tests","4321s");
    }

    @GetMapping("/show")
    public String Show() {
//       return stringRedisTemplate.opsForValue().get("tests").toString();
        return redisTemplate.opsForValue().get("test").toString();
    }
}
