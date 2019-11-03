package com.lty.learn;

import com.lty.learn.exception.RedisConnectException;
import com.lty.learn.redisService.RedisService;
import com.lty.learn.util.springUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnApplication {

    public static void main(String[] args) throws RedisConnectException {
        SpringApplication.run(LearnApplication.class, args);
//
//        RedisService bean = (RedisService) springUtil.getBean("redisService");//通过springutil获取bean
//        String set = bean.set("ltytest", "name");
//        System.out.println(set);

    }

}
