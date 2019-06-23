package com.target.myretail.controller;

import com.target.myretail.domain.ProductDetails;
import com.target.myretail.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/myretail", produces = "application/json;charset=UTF-8")
public class ProductController {
    @Autowired
    ProductDetailsService productDetailsService;

    @GetMapping("/product-details/{id}")
    public ProductDetails getProductDetails(@PathVariable String id) throws IOException {
        ProductDetails productDetails = productDetailsService.getProductDetailsById(id);
        return productDetails;
    }

    @PutMapping(value = "/product-details/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductDetails saveProductPrice(
            @PathVariable String id, @RequestBody ProductDetails productDetails) {
        return productDetailsService.saveProductPricing(productDetails);
    }
 }