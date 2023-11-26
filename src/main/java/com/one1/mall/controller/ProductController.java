package com.one1.mall.controller;

import com.one1.mall.constant.ProductCategory;
import com.one1.mall.dto.ProductRequest;
import com.one1.mall.model.Product;
import com.one1.mall.server.ProductService;
import jakarta.validation.Valid;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService prodService;
    @GetMapping("/products")
    public  ResponseEntity<List<Product>> getProducts(
            @RequestParam(required = false)  ProductCategory category,
            @RequestParam(required = false) String search
    ){

        List<Product> productList = prodService.getProducts(category,search);
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
              Product product = prodService.getProductById(productId);
              if (product != null){
                  return  ResponseEntity.status(HttpStatus.OK).body(product);
              }else {
                  return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
              }

    }
    @PostMapping("/products")
    public  ResponseEntity<Product> createProduct(@RequestBody @Valid  ProductRequest productRequest){
              Integer productId = prodService.createProduct(productRequest);
              Product product = prodService.getProductById(productId);
              return  ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @PutMapping("/products/{productId}")
    public  ResponseEntity<Product> updateProduct(@PathVariable Integer productId,@RequestBody @Valid ProductRequest productRequest){

        Product product = prodService.getProductById(productId);
        if (product == null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        prodService.updateProduct(productId,productRequest);
        Product updateProduct = prodService.getProductById(productId);
        return  ResponseEntity.status((HttpStatus.OK)).body(updateProduct);

    }
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        prodService.deleteProduct(productId);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
