package com.delivery.ecommerce.modules.product.DTO;

import jakarta.validation.constraints.NotNull;

public record CategoryProductCreateDTO(
    @NotNull(message = "O name da categoria é obrigatório")
    String name
) {}


