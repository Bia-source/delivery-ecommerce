package com.delivery.ecommerce.modules.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.ecommerce.modules.product.DTO.CategoryProductCreateDTO;
import com.delivery.ecommerce.modules.product.DTO.CategoryProductResponseDTO;
import com.delivery.ecommerce.modules.product.services.CategoryCreateService;

import jakarta.validation.Valid;

@RequestMapping("/category")
@RestController
public class CategoryController {
  
  @Autowired
  private CategoryCreateService categoryCreateService;

  @PostMapping
  public ResponseEntity<CategoryProductResponseDTO> createCategory(@Valid @RequestBody CategoryProductCreateDTO category) {
      CategoryProductResponseDTO created = categoryCreateService.execute(category.name());
      return ResponseEntity.status(HttpStatus.CREATED).body(created);       
  }
}
