package com.delivery.ecommerce.modules.order.DTO;

import java.util.List;

import com.delivery.ecommerce.modules.order.enums.OrderPaymentTypeEnum;
import com.delivery.ecommerce.modules.product.DTO.ProductCreateDTO;

public record OrderCreateDTO(
    OrderPaymentTypeEnum paymentType,
    List<ProductCreateDTO> items,
    String customerId
) {}
