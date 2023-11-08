package com.one1.mall.model;

import java.util.Date;

public class Product {


    private Integer productId;
    private  String productName;
    private String category;
    private String imageUrl;
    private Integer price;
    private Integer stock;
    private String description;
    private Date createDate;
    private Date lastModifieDate;

    public Product() {
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getLasrModifieDate() {
        return lastModifieDate;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setLastModifieDate(Date lasrModifieDate) {
        this.lastModifieDate = lasrModifieDate;
    }



}
