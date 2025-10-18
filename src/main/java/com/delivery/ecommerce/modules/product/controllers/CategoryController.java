package com.delivery.ecommerce.modules.product.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.ecommerce.modules.product.DTO.CategoryProductCreateDTO;
import com.delivery.ecommerce.modules.product.DTO.CategoryProductResponseDTO;
import com.delivery.ecommerce.modules.product.services.CategoryCreateService;

@RequestMapping("/category")
@RestController
public class CategoryController {
  
  @Autowired
  private CategoryCreateService categoryCreateService;

  @PostMapping
  public CategoryProductResponseDTO createCategory(@RequestBody CategoryProductCreateDTO category) {
      System.out.println("category received: " + category.name());
      return categoryCreateService.execute(category.name());       
  }
}
