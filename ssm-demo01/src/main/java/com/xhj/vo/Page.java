package com.xhj.vo;

public class Page {
    private Integer pageNow;//当前页数
    private Integer rowCount;//总行数
    private Integer pageSize;//每一页行数

    public Page() {
    }
    //总页数
    public Integer getPageCount() {
        Integer pageCount = rowCount%pageSize==0?rowCount/pageSize:(rowCount/pageSize+1);
        return pageCount;
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
