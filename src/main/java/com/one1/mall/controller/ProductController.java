package com.one1.mall.controller;

import com.one1.mall.constant.ProductCategory;
import com.one1.mall.dto.ProductQueryParams;
import com.one1.mall.dto.ProductRequest;
import com.one1.mall.model.Product;
import com.one1.mall.server.ProductService;
import com.one1.mall.util.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.apache.catalina.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
public class ProductController {
    @Autowired
    private ProductService prodService;
    @GetMapping("/products")
    public  ResponseEntity<Page<Product>> getProducts(
            @RequestParam(required = false)  ProductCategory category,
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "desc") String sort,

            //pagination
            @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0)  Integer offset
    ){
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);

        List<Product> productList = prodService.getProducts(productQueryParams);
        Integer total = prodService.countProduct(productQueryParams);
        //分頁
        Page<Product> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(productList);
        return ResponseEntity.status(HttpStatus.OK).body(page);
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
