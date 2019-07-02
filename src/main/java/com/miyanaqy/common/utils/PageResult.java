package com.miyanaqy.common.utils;

import java.util.List;

public class PageResult<T> {
	private long total;//总条数
    private List<T> rows;//返回的数据集
    public PageResult() {
    }
    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List<T> getRows() {
        return rows;
    }
    public void setRows(List<T> rows) {
        this.rows = rows;
    }
    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
