package com.one1.mall.server.Impl;

import com.one1.mall.constant.ProductCategory;
import com.one1.mall.dao.ProductDao;
import com.one1.mall.dto.ProductRequest;
import com.one1.mall.model.Product;
import com.one1.mall.server.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProducts(ProductCategory category,String search){
        return productDao.getProducts(category,search);
    }


    @Override
    public Integer createProduct(ProductRequest productRequest) {
       return productDao.createProduct(productRequest);
    }

    @Override
    public Product getProductById(Integer productId){
        return productDao.getProductById(productId);
    }

    public void updateProduct(Integer productId,ProductRequest productRequest){
        productDao.updateProduct(productId,productRequest);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productDao.deleteProduct(productId);
    }
}
