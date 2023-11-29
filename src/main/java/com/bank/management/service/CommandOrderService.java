package com.bank.management.service;

import com.bank.management.entity.Event;
import com.bank.management.entity.CommandOrder;
import com.bank.management.messaging.CommandOrderEventProducer;
import com.bank.management.repository.CommandOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CommandOrderService {

    @Autowired
    private CommandOrderRepository repository;
    @Autowired
    private CommandOrderEventProducer eventProducer;

    public ResponseEntity<String> createOrder(CommandOrder o) {

        o.setStatus("PLACED");
        repository.save(o);
        Event event = new Event();
        event.setOrderId(o.getOrderId());
        event.setPhase("Order");
        event.setEventStatus("PLACED");
        placeOrderCreatedEvent(event);
        return new ResponseEntity<>("Order creation status : " + o.getStatus(), HttpStatus.OK);
    }

    public void placeOrderCreatedEvent(Event event) {
        eventProducer.createSuccessEvent(event);
    }

    public ResponseEntity<CommandOrder> updateOrder(Long orderId, String status) {
        Optional<CommandOrder> order = repository.findById(orderId);
        order.get().setStatus(status);
        repository.save(order.get());
        return new ResponseEntity<CommandOrder>(repository.save(order.get()), HttpStatus.OK);
    }

    public CommandOrder fetchOrder(Event event) {
        Optional<CommandOrder> order = repository.findById(event.getOrderId());
        return order.get();
    }
}