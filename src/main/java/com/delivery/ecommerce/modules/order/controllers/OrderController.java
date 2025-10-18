package com.delivery.ecommerce.modules.order.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.ecommerce.modules.order.DTO.OrderCreateDTO;
import com.delivery.ecommerce.modules.order.DTO.OrderResponseDTO;
import com.delivery.ecommerce.modules.order.services.OrderCreateService;

@RequestMapping("/order")
@RestController
public class OrderController {
    
    @Autowired
    private OrderCreateService orderCreateService;

    @PostMapping
    public OrderResponseDTO createOrder(@RequestBody OrderCreateDTO order) {
        var result = orderCreateService.execute(order);
        return result;
    }
}
