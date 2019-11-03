package com.lty.learn;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lty.learn.Dao.GetDao;
import com.lty.learn.exception.RedisConnectException;
import com.lty.learn.redisService.RedisService;
import com.lty.learn.util.springUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.UUID;

@RestController
public class GetController {

    @Autowired
    private GetDao getDao;

    @RequestMapping("get")
    public Map getUser(@RequestBody String jsonData) throws InterruptedException, RedisConnectException {
        JSONObject jsonObject = JSON.parseObject(jsonData);
        String userId = jsonObject.getString("userId");
        RedisService bean = (RedisService) springUtil.getBean("redisService");//通过springutil获取bean
        boolean lock1 = bean.getLock(userId, UUID.randomUUID().toString(), 200000000);
        System.out.println("上锁 结果  "+lock1);


        Thread.sleep(1000);
        Map user = getDao.getUser();
        return user;
    }
 @RequestMapping("release")
    public Map re(@RequestBody String jsonData) throws InterruptedException, RedisConnectException {
        JSONObject jsonObject = JSON.parseObject(jsonData);
        String key = jsonObject.getString("key");
        RedisService bean = (RedisService) springUtil.getBean("redisService");//通过springutil获取bean
        boolean lock1 = bean.releaseLock(key, "e0683dad-b77c-4749-bb4d-d790732cc41f");
        System.out.println("解锁  "+lock1);


        Thread.sleep(1000);
        Map user = getDao.getUser();
        return user;
    }



}
