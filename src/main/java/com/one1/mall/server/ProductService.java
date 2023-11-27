package com.one1.mall.server;

import com.one1.mall.constant.ProductCategory;
import com.one1.mall.dto.ProductQueryParams;
import com.one1.mall.dto.ProductRequest;
import com.one1.mall.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById(Integer productId);
    Integer  createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProduct(Integer productId);
}
