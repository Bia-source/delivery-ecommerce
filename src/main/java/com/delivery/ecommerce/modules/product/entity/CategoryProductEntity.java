package com.delivery.ecommerce.modules.product.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_categories")
public class CategoryProductEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
    private UUID id;

    private String name;

    @CreationTimestamp
    private LocalDate createdAt;

     public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
