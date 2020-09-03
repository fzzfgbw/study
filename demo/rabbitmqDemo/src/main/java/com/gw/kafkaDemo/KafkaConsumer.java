package com.gw.kafkaDemo;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.requests.MetadataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class KafkaConsumer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    private static int x = 0;

//    @Bean
//    public ConsumerAwareListenerErrorHandler consumerAwareErrorHandler() {
//        return (message, exception, consumer) -> {
//            logger.error("消费异常："+message.getPayload());
//            return null;
//        };
//    }

    @KafkaListener(topics = "TrainRealtimeStatusByteData", groupId = "test0831"
    )
    public void listen(ConsumerRecord<?, ?> record, Consumer<String,String> consumer
                     ) {

        logger.info("begin topic = {}, offset = {}, value = {}", record.topic(), record.offset(), record.value());
        if (record.value().toString().equals("2")) {
//            if (x<7){
//                TopicPartition tp = new TopicPartition(record.topic(), record.partition());
//                consumer.seek(tp,record.offset());
                logger.info("end topic = {}, offset = {}, value = {}", record.topic(), record.offset(), record.value());
//           x++;
//            }else {
//                consumer.commitSync();
//            }
//
//             }else{
            consumer.commitSync();
        }
//        Map<TopicPartition, OffsetAndMetadata> map = new HashMap<>();
//        long offset = offsetAndMetadata.offset() - 1;
//        String metadata = offsetAndMetadata.metadata();
//        OffsetAndMetadata offsetAndMetadata1 = new OffsetAndMetadata(offset,metadata);
//        map.put(topicPartition,offsetAndMetadata1);
//        consumer.commitSync(map);



    }
}
