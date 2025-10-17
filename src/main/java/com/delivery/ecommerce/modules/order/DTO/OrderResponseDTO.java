package com.delivery.ecommerce.modules.order.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.delivery.ecommerce.modules.order.enums.OrderPaymentTypeEnum;
import com.delivery.ecommerce.modules.order.enums.OrderStatusEnum;

public record OrderResponseDTO(
     UUID id,
     BigDecimal amount, 
     OrderStatusEnum status,
     OrderPaymentTypeEnum paymentType,
     LocalDate createdAt,
     List<OrderItemResponseDTO> items
){}