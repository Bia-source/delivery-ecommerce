package com.delivery.ecommerce.modules.order.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.delivery.ecommerce.modules.order.enums.OrderPaymentTypeEnum;
import com.delivery.ecommerce.modules.order.enums.OrderStatusEnum;
import com.delivery.ecommerce.modules.product.entity.ProductEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
    private UUID id;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status = OrderStatusEnum.PENDING;

    @Enumerated(EnumType.STRING)  
    private OrderPaymentTypeEnum paymentType;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductEntity> items = new ArrayList<>();

    private String customerId;

    @CreationTimestamp
    private LocalDate createdAt;

    public UUID getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }

    public OrderPaymentTypeEnum getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(OrderPaymentTypeEnum paymentType) {
        this.paymentType = paymentType;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public List<ProductEntity> getItems() {
        return items;
    }

    public void setItems(List<ProductEntity> items) {
        this.items = items;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

}
