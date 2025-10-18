package com.delivery.ecommerce.modules.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.ecommerce.modules.order.DTO.OrderCreateDTO;
import com.delivery.ecommerce.modules.order.DTO.OrderResponseDTO;
import com.delivery.ecommerce.modules.order.entity.OrderEntity;
import com.delivery.ecommerce.modules.order.mappers.OrderMapper;
import com.delivery.ecommerce.modules.order.repository.OrderRepository;

@Service
public class OrderCreateService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public OrderResponseDTO execute(OrderCreateDTO orderDto) {
        OrderEntity orderEntity = orderMapper.toEntity(orderDto);
        OrderEntity savedOrder = orderRepository.save(orderEntity);

        return orderMapper.toResponse(savedOrder);
    }
}

