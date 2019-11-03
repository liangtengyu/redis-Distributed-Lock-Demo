package com.lty.learn.function;

import com.lty.learn.exception.RedisConnectException;

public interface JedisExecutor<T, R> {
    R excute(T t) throws RedisConnectException;
}