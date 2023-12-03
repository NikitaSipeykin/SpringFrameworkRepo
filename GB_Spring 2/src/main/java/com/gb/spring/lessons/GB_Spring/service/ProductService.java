package com.gb.spring.lessons.GB_Spring.service;

import com.gb.spring.lessons.GB_Spring.dto.Product;
import com.gb.spring.lessons.GB_Spring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getFullProductList() {
        return productRepository.getFullProductList();
    }

    public Product getOneProduct(int id) {
        return productRepository.getOneProduct(id);
    }

    public void addProductToRepo(Product product){
        productRepository.addProductToRepo(product);
    }

    public void displayProductInfo() {
        productRepository.displayProductInfo();
    }

    public void deleteProductById(int id){
        productRepository.deleteProductById(id);
    }
}
