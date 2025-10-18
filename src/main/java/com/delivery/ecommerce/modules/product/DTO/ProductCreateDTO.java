package com.delivery.ecommerce.modules.product.DTO;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductCreateDTO(
    String itemName,
    BigDecimal unitPrice,
    Integer quantity,
    UUID categoryId,
    String barcode
) {}
