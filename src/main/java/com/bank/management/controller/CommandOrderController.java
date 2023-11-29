package com.bank.management.controller;

import com.bank.management.entity.CommandOrder;
import com.bank.management.service.CommandOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/api/orders")
public class CommandOrderController {

    @Autowired
    CommandOrderService service;

    @PostMapping(value = "/createOrder",
            produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addOrder(@RequestBody CommandOrder order) {
        ResponseEntity<String> response = service.createOrder(order);
        return response;
    }

    @PostMapping(value = "/updateOrder/{orderId}/{status}",
            produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<CommandOrder> updateOrder(@PathVariable Long orderId,
                                                    @PathVariable String status) {
        return service.updateOrder(orderId, status);
    }
}
