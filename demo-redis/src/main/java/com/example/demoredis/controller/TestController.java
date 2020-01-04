package com.example.demoredis.controller;

import com.example.demoredis.utils.RedisUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TestController {

    @Resource
    private RedisUtils redisUtils;

    @RequestMapping("/getValue")
    @ResponseBody
    public String getValue(String key){
        String value=(String) redisUtils.get(key);
        return value;
    }


    @RequestMapping("/setValue")
    @ResponseBody
    public String set(String k,String v){
        boolean b = redisUtils.set(k, v);
        if (b){
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(String k){
        boolean b = redisUtils.expire(k,123);
        if (b){
            return "success";
        }else {
            return "fail";
        }
    }

}
