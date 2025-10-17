package com.delivery.ecommerce.modules.order.DTO;

import java.util.List;
import java.util.UUID;

import com.delivery.ecommerce.modules.order.enums.OrderPaymentTypeEnum;

public record OrderCreateDTO(
    OrderPaymentTypeEnum paymentType,
    List<OrderItemCreateDTO> items,
    UUID customerId
) {}
