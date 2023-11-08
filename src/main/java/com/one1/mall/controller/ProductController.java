package com.one1.mall.controller;

import com.one1.mall.model.Product;
import com.one1.mall.server.ProductService;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Autowired
    private ProductService prodService;
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
              Product product = prodService.getProductById(productId);
              if (product != null){
                  return  ResponseEntity.status(HttpStatus.OK).body(product);
              }else {
                  return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
              }

    }
}
