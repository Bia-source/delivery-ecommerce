package com.delivery.ecommerce.modules.product.DTO;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponseDTO(
    UUID id,
    String itemName,
    Integer quantity,
    BigDecimal unitPrice,
    String barcode,
    CategoryProductResponseDTO category
) {}
