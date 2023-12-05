package com.gb.spring.lessons.GB_Spring.controllers;

import com.gb.spring.lessons.GB_Spring.dto.Product;
import com.gb.spring.lessons.GB_Spring.service.ProductService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class ProductRestController {
    private ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model){
        model.addAttribute("products", productService.getFullProductList());
        return "fullProductList";
    }

    @GetMapping("/productInfo")
    public String getProductInfo(@RequestParam Integer id, Model model){
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
}
