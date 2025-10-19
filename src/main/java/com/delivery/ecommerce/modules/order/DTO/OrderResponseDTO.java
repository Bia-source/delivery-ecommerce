package com.delivery.ecommerce.modules.order.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.delivery.ecommerce.modules.order.enums.OrderPaymentTypeEnum;
import com.delivery.ecommerce.modules.order.enums.OrderStatusEnum;
import com.delivery.ecommerce.modules.product.DTO.ProductResponseDTO;

public record OrderResponseDTO(
     UUID id,
     BigDecimal amount, 
     OrderStatusEnum status,
     OrderPaymentTypeEnum paymentType,
     LocalDateTime createdAt,
     List<ProductResponseDTO> items
){}