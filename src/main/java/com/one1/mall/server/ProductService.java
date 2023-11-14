package com.one1.mall.server;

import com.one1.mall.dto.ProductRequest;
import com.one1.mall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);
    Integer  createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
