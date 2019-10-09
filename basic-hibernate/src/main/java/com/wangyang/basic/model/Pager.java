package com.wangyang.basic.model;

import java.util.List;

/**
 * 分页对象
 * @param <T>
 */
public class Pager<T> {
    private long totalPage;
    /**
     * 第几页
     */
    private int pageIndex;

    /**
     * 分页的大小
     */
    private int size;
    /**
     * 分页的起始位置
     */
    private int offset;
    /**
     * 总的记录数
     */
    private long total;
    /**
     * 分页的数据
     */
    private List<T> datas;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }
}
