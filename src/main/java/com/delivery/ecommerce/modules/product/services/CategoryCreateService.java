package com.delivery.ecommerce.modules.product.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delivery.ecommerce.modules.product.DTO.CategoryProductResponseDTO;
import com.delivery.ecommerce.modules.product.entity.CategoryProductEntity;
import com.delivery.ecommerce.modules.product.repository.CategoryRepository;

@Service
public class CategoryCreateService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryProductResponseDTO execute(String name) {
        var category = new CategoryProductEntity();
        category.setName(name);

        var saved = categoryRepository.save(category);

        return new CategoryProductResponseDTO(saved.getId(), saved.getName());
    }
}
