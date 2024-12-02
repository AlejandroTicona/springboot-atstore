package com.springboot.atstore.springboot_atstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.atstore.springboot_atstore.entities.Product;
import com.springboot.atstore.springboot_atstore.repositories.IProductRepository;

@Service
public class ProductService {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getProductByName(String name) {
        return productRepository.getProductByName(name);
    }

    public Product saveProduct(Product product) {
        if (product.getCategory() == null) {
            throw new IllegalArgumentException("Product must have a category.");
        }
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
