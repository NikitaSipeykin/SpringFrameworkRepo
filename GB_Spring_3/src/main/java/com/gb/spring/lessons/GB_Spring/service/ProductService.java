package com.gb.spring.lessons.GB_Spring.service;

import com.gb.spring.lessons.GB_Spring.dto.Product;
import com.gb.spring.lessons.GB_Spring.repository.ProductDao;
import com.gb.spring.lessons.GB_Spring.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getFullProductList() {
        return productDao.findAll();
    }

    public Product getOneProduct(long id) {
        return productDao.findById(id);
    }

    public void addProductToRepo(Product product){
        productDao.saveOrUpdate(product);
    }



    public void deleteProductById(long id){
        productDao.deleteById(id);
    }
}
