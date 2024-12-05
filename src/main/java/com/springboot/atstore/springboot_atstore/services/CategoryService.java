package com.springboot.atstore.springboot_atstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.atstore.springboot_atstore.entities.Category;
import com.springboot.atstore.springboot_atstore.entities.Product;
import com.springboot.atstore.springboot_atstore.repositories.ICategoryRepository;
import com.springboot.atstore.springboot_atstore.repositories.IProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {
    private final ICategoryRepository categoryRepository;
    private final IProductRepository productRepository;

    public CategoryService(ICategoryRepository categoryRepository, IProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }


    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));

        List<Product> products = productRepository.findByCategoryId(id);
        for (Product product : products) {
            product.setCategory(null);
            productRepository.save(product);
        }

        // Ahora elimina la tienda
        categoryRepository.delete(category);
    }
}
