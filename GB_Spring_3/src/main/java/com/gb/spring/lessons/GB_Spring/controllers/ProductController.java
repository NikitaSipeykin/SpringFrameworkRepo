package com.gb.spring.lessons.GB_Spring.controllers;

import com.gb.spring.lessons.GB_Spring.dto.Product;
import com.gb.spring.lessons.GB_Spring.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model){
        model.addAttribute("products", productService.getFullProductList());
        return "fullProductList";
    }

    @PostMapping("/productInfo")
    public String getProductInfo(@RequestParam Long id, Model model){
        model.addAttribute("product", productService.getOneProduct(id));
        return  "productInfo";
    }

    @GetMapping("/add")
    public String getProductAddForm(){
        return "productForm";
    }

    @PostMapping("/add")
    public String addProduct(Product product){
        productService.addProductToRepo(product);
        return "redirect:all";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Long id){
        productService.deleteProductById(id);
        return "redirect:all";
    }

}
