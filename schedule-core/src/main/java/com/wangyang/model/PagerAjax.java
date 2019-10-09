package com.wangyang.model;

import java.util.List;

public class PagerAjax<T> {
    /**
     * 总的记录数
     */
    private int totalRecord;
    /**
     *当前时第几页
     */
    private int pageIndex;

    private List<T> datas;

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
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
}
