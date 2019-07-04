package com.zst.demo.redis;

import org.apache.ibatis.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedisCahe implements Cache {

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    /**
     * Jedis客户端
     */

    @Autowired
    private Jedis redisClient = createClient();

    private String id;

    public RedisCahe(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("必须传入ID");
        }
        System.out.println("MybatisRedisCache:id=" + id);
        this.id = id;
    }

    public void clear() {
        redisClient.flushDB();
    }

    public String getId() {
        return this.id;
    }

    public Object getObject(Object key) {
        byte[] ob = redisClient.get(SerializeUtil.serialize(key.toString()));
        if (ob == null) {
            return null;
        }
        Object value = SerializeUtil.unSerialize(ob);
        return value;
    }

    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    public int getSize() {
        return Integer.valueOf(redisClient.dbSize().toString());
    }

    public void putObject(Object key, Object value) {
        redisClient.set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));
    }

    public Object removeObject(Object key) {
        return redisClient.expire(SerializeUtil.serialize(key.toString()), 0);
    }

    protected static Jedis createClient() {

        try {
            @SuppressWarnings("resource")
            JedisPool pool = new JedisPool(new JedisPoolConfig(), "127.0.0.1", 6379);
            return pool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("初始化连接池错误");
    }

}
