package com.one1.mall.util;

import java.util.List;

public class Page <T>{

    private  Integer limit;
    private  Integer offset;
    private  Integer total;
    private List<T> results;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }



    public Integer getLimit() {
        return limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getTotal() {
        return total;
    }



    private  Integer result;
}
