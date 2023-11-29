package com.bank.management.messaging;

import com.bank.management.entity.Event;
import com.bank.management.service.CommandOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommandOrderEventReceiver {

    private static final String TOPIC_ORDER_CREATED = "orderCreatedTopic";

    @Autowired
    CommandOrderService service;

    @KafkaListener(topics = TOPIC_ORDER_CREATED, groupId = "command=order-group", containerFactory = "tranRecordListener")
    private void listenOrderCreatedEvent(Event event) throws Exception {
        log.info("Received message :" + event + " in " + TOPIC_ORDER_CREATED);
        System.out.println("Received message :" + event + " in " + TOPIC_ORDER_CREATED);
        service.fetchOrder(event);

    }
}
