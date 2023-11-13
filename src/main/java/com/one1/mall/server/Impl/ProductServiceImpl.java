package com.one1.mall.server.Impl;

import com.one1.mall.dao.ProductDao;
import com.one1.mall.dto.ProductRequest;
import com.one1.mall.model.Product;
import com.one1.mall.server.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Integer createProduct(ProductRequest productRequest) {
       return productDao.createProduct(productRequest);
    }

    @Override
    public Product getProductById(Integer productId){
        return productDao.getProductById(productId);
    }

}
