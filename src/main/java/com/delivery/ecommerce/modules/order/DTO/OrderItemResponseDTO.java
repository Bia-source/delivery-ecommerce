package com.delivery.ecommerce.modules.order.DTO;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderItemResponseDTO(
    UUID id,
    String itemName,
    Integer quantity,
    BigDecimal unitPrice,
    String category
) {}
