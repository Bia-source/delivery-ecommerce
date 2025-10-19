package com.delivery.ecommerce.modules.order.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.ecommerce.modules.order.DTO.OrderCreateDTO;
import com.delivery.ecommerce.modules.order.DTO.OrderResponseDTO;
import com.delivery.ecommerce.modules.order.services.OrderCreateService;

import jakarta.validation.Valid;

@RequestMapping("/order")
@RestController
public class OrderController {
    
    @Autowired
    private OrderCreateService orderCreateService;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@Valid @RequestBody OrderCreateDTO order) {
        OrderResponseDTO created = orderCreateService.execute(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
