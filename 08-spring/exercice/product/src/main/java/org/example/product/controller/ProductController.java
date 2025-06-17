package org.example.product.controller;


import org.example.product.model.Product;
import org.example.product.service.ProductService;
import org.example.product.util.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String homePage(Model model){
        model.addAttribute("categories",Category.values());
        return "home";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        model.addAttribute("errorSearch","");
        return "list";
    }


    @GetMapping("/detail/{productId}")
    public String detailPage(@PathVariable("productId") UUID productId, Model model){
        Product product = productService.findById(productId);
        model.addAttribute("product",product);
        return "details";
    }


    @GetMapping("/search")
    public String searchProducts(@RequestParam(value = "price",required = false) double price, @RequestParam(value = "category", required = false) Category category, Model model){
        List<Product> products = new ArrayList<>();
        String errorSearch = "";

        if(category != null){
            products = productService.findByCategory(category);
        }

        if(price > 0){
            if(!products.isEmpty()){
                List<Product> productsByPrice = productService.findByUnderAmount(price);
                products.addAll(productsByPrice);
            }
            else products = productService.findByUnderAmount(price);
        }

        if (products.isEmpty()){
            errorSearch = "Product not found";
            products = productService.findAll();
        }

        model.addAttribute("products",products);
        model.addAttribute("errorSearch",errorSearch);

        return "list";
    }

}
