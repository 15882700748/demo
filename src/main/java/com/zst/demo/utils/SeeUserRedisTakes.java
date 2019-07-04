package com.zst.demo.utils;

import com.zst.demo.entity.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by zxm on 2017/8/12.
 *
 */
@Component("seeUserRedisTakes")
public class SeeUserRedisTakes implements RedisBaiseTakes<String,String, User>{
    @Resource(name="redisTemplate")
    private RedisTemplate redisTemplate;

    private Logger logger = Logger.getLogger(String.valueOf(SeeUserRedisTakes.class));
    public void add(String key, String value) {
        if(redisTemplate==null){
            logger.warning("redisTemplate 实例化失败");
            return;
        }else{
            redisTemplate.opsForValue().set(key,value);
        }
    }

    public void addObj(String objectKey, String key, User object) {
        if(redisTemplate==null){
            logger.warning("redisTemplate 实例化失败");
            return;
        }else{
            redisTemplate.opsForHash().put(objectKey,key,object);
        }
    }

    public void delete(String key) {

    }

    public void delete(List<String> listKeys) {

    }

    public void deletObj(String objecyKey, String key) {

    }

    public void update(String key, String value) {

    }

    public void updateObj(String objectKey, String key, User object) {

    }

    public String get(String key) {
        String value = (String) redisTemplate.opsForValue().get(key);
        return value;
    }

    public User getObj(String objectKey, String key) {
        User seeUser = (User) redisTemplate.opsForHash().get(objectKey,key);
        return seeUser;
    }
}

