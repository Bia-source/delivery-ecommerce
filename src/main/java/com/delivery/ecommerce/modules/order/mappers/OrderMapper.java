package com.delivery.ecommerce.modules.order.mappers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.delivery.ecommerce.modules.order.DTO.OrderCreateDTO;
import com.delivery.ecommerce.modules.order.DTO.OrderResponseDTO;
import com.delivery.ecommerce.modules.order.entity.OrderEntity;
import com.delivery.ecommerce.modules.product.DTO.CategoryProductResponseDTO;
import com.delivery.ecommerce.modules.product.DTO.ProductCreateDTO;
import com.delivery.ecommerce.modules.product.DTO.ProductResponseDTO;
import com.delivery.ecommerce.modules.product.entity.CategoryProductEntity;
import com.delivery.ecommerce.modules.product.entity.ProductEntity;
import com.delivery.ecommerce.modules.product.repository.CategoryRepository;

@Component
public class OrderMapper {

    @Autowired
    private CategoryRepository orderCategoryRepository;

    public OrderEntity toEntity(OrderCreateDTO order) {
        var entity = new OrderEntity();
        entity.setPaymentType(order.paymentType());
        entity.setCustomerId(order.customerId());

        var items = order.items().stream()
            .map(this::toItemEntity)
            .toList();
        entity.setItems(items);

        items.forEach(i -> i.setOrder(entity));

        var totalAmount = items.stream()
        .map(i -> i.getUnitPrice().multiply(BigDecimal.valueOf(i.getQuantity())))
        .reduce(BigDecimal.ZERO, BigDecimal::add);

        entity.setAmount(totalAmount);

        return entity;
    }

    public ProductEntity toItemEntity(ProductCreateDTO item) {
        var entity = new ProductEntity();
        entity.setProductName(item.itemName());
        entity.setQuantity(item.quantity());
        entity.setUnitPrice(item.unitPrice());

        var category = orderCategoryRepository.findById(item.categoryId())
            .orElseThrow(() -> new RuntimeException(
                "Categoria não encontrada para o ID: " + item.categoryId()
            ));
        entity.setCategory(category);

        return entity;
    }

   public OrderResponseDTO toResponse(OrderEntity entity) {
    var items = entity.getItems().stream()
        .map(i -> new ProductResponseDTO(
            i.getId(),
            i.getProductName(),
            i.getQuantity(),
            i.getUnitPrice(),
            i.getBarcode(),
            i.getCategory() != null ? new CategoryProductResponseDTO(
                i.getCategory().getId(),
                i.getCategory().getName()
            ) : null
        ))
        .toList();

        return new OrderResponseDTO(
            entity.getId(),
            entity.getAmount(),
            entity.getStatus(),
            entity.getPaymentType(),
            entity.getCreatedAt(),
            items
        );
    }


    public CategoryProductResponseDTO toCategoryResponse(CategoryProductEntity category) {
        return new CategoryProductResponseDTO(category.getId(), category.getName());
    }
}