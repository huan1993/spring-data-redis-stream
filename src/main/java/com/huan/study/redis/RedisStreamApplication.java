package com.huan.study.redis;

import com.huan.study.redis.constan.Constants;
import com.huan.study.redis.stream.producer.StreamProducer;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 */
@SpringBootApplication
@AllArgsConstructor
public class RedisStreamApplication implements ApplicationRunner {
    
    private final StreamProducer streamProducer;
    
    public static void main(String[] args) {
        SpringApplication.run(RedisStreamApplication.class, args);
    }
    
    @Override
    public void run(ApplicationArguments args) {
        streamProducer.sendRecord(Constants.STREAM_KEY_001);
    }
}
