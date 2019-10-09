package com.wangyang.util;

public class SystemContext {
    private  final static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();
    private final  static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();

    public static int getPageIndex() {
        return pageIndex.get();
    }

    public static void setPageIndex(int _pageIndex) {
        pageIndex.set(_pageIndex);
    }
    public static void removePageIndex(){
        pageIndex.remove();
    }

    public static int getPageSize() {
        return pageSize.get();
    }
    public static void  setPageSize(int _pageSzie){
        pageSize.set(_pageSzie);
    }
    public static void removePageSize(){
        pageSize.remove();
    }
}
