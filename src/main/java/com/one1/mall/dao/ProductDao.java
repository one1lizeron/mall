package com.one1.mall.dao;

import com.one1.mall.dto.ProductRequest;
import com.one1.mall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId ,ProductRequest productRequest);
}
