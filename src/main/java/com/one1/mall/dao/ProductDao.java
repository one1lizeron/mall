package com.one1.mall.dao;

import com.one1.mall.constant.ProductCategory;
import com.one1.mall.dto.ProductRequest;
import com.one1.mall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductCategory category,String search);
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId ,ProductRequest productRequest);
    void deleteProduct(Integer productId);
}
