package com.delivery.ecommerce.modules.order.DTO;

import java.util.List;

import com.delivery.ecommerce.modules.order.enums.OrderPaymentTypeEnum;
import com.delivery.ecommerce.modules.product.DTO.ProductCreateDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record OrderCreateDTO(

    @NotNull(message = "O tipo de pagamento é obrigatório")
    OrderPaymentTypeEnum paymentType,
    
    @Size(min = 1, message = "Deve haver pelo menos um item no pedido")
    List<ProductCreateDTO> items,

    @NotNull(message = "O ID do cliente é obrigatório")
    String customerId
) {}
