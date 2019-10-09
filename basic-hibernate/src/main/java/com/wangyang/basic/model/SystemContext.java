package com.wangyang.basic.model;

public class SystemContext {
    private static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();
    /**
     * 分页的大小
     */
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
    /**
     * 分页的起始位置
     */
    private static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();
    /**
     * 列表的排序字段
     */
    private static ThreadLocal<String> sort = new ThreadLocal<String>();
    /**
     * 列表的排序方式
     */
    private static ThreadLocal<String> order=new ThreadLocal<String>();

    public static int getPageSize() {
        return pageSize.get();
    }

    public static void setPageSize(int _pageSize) {
        pageSize.set(_pageSize);
    }

    public static int getPageOffset() {
        return pageOffset.get();
    }

    public static void setPageOffset(int _pageOffset) {
        pageOffset.set(_pageOffset);
    }

    public static String getSort() {
        return sort.get();
    }

    public static void setSort(String _sort) {
        sort.set(_sort);
    }

    public static String getOrder() {
        return order.get();
    }
    public static void setPageIndex(int _pageIndex){
        pageIndex.set(_pageIndex);
    }
    public static int getPageIndex(){
        return pageIndex.get();
    }
    public static void remove(){
        pageIndex.remove();;
    }
    public static void setOrder(String _order) {
        order.set(_order);
    }
    public static void removePageSzie(){
        pageSize.remove();
    }
    public static void removePageOffset(){
        pageOffset.remove();
    }
    public static void removeSort(){
        sort.remove();
    }
    public static void rmoveOrder(){
        order.remove();
    }
}
