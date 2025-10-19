package com.delivery.ecommerce.modules.product.DTO;

import java.math.BigDecimal;
import java.util.UUID;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ProductCreateDTO(
    @NotNull(message = "O name do produto é obrigatório")
    String itemName,

    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero")
    BigDecimal unitPrice,

    @Min(value = 1, message = "A quantidade deve ser maior que zero")
    Integer quantity,

    @NotNull(message = "O categoryId do produto é obrigatório")
    UUID categoryId,

    @NotNull(message = "O código de barras do produto é obrigatório")
    String barcode
) {}
