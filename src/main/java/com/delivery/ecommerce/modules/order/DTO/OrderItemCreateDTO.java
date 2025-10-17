package com.delivery.ecommerce.modules.order.DTO;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderItemCreateDTO(
    String itemName,
    BigDecimal unitPrice,
    Integer quantity,
    UUID categoryId
) {}
