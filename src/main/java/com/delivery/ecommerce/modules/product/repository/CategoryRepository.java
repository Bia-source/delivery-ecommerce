package com.delivery.ecommerce.modules.product.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.ecommerce.modules.product.entity.CategoryProductEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryProductEntity, UUID> {

}
