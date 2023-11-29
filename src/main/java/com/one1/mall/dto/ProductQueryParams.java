package com.one1.mall.dto;

import com.one1.mall.constant.ProductCategory;

public class ProductQueryParams {
    private ProductCategory category;
    private String search;

    private String orderBy;
    private Integer limit;
    private Integer offset;

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public String getSort() {
        return sort;
    }

    private String sort;

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public String getSearch() {
        return search;
    }
}
