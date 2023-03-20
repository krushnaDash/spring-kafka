package com.baeldung.kafka.ssl;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class KafkaConsumer {

    public static final String TOPIC = "wm-cth-salesstreams";
    public static final String TOPIC_EVENT="wm-cth-events";

    public final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = TOPIC, groupId = "buatest")
    public void receive(ConsumerRecord<String, String> consumerRecord) {
        log.info("Received payload: '{}'", consumerRecord.toString());
        System.out.println(consumerRecord.value()+">>>>");
        messages.add(consumerRecord.value());
    }

}
