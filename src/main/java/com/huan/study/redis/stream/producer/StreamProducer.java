package com.huan.study.redis.stream.producer;

import com.huan.study.redis.entity.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 消息生产者
 *
 * @author huan.fu 2021/11/1 - 下午5:09
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class StreamProducer {
    
    private final RedisTemplate<String, Object> redisTemplate;
    
    public void sendRecord(String streamKey) {
        Book book = Book.create();
        log.info("generator book info :[{}]", book);
        
        ObjectRecord<String, Book> record = StreamRecords.newRecord()
                .in(streamKey)
                .ofObject(book)
                .withId(RecordId.autoGenerate());
        
        RecordId recordId = redisTemplate.opsForStream()
                .add(record);
        
        log.info("return record-id:[{}]", recordId);
    }
}
