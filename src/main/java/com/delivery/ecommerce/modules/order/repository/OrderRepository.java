package com.delivery.ecommerce.modules.order.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.ecommerce.modules.order.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
    
}
