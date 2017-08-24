package com.ssm.bsms.common.pages;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */
public class PagesObject<T> {
    /**
     * 请求状态
     */
    private Integer status = 0;

    /**
     * 状态信息
     */
    private String message = "成功";

    /**
     * 分页数据
     */
    private List<T> data;

    /**
     * 当前页码
     */
    private Integer pageNum = 1;

    /**
     * 每页显示数量
     */
    private Integer pageSize = 10;

    /**
     * 排序字段|排序方式
     */
    private String sort;

    /**
     * 当前页显示数量
     */
    private int size = 0;

    /**
     * 当前页面第一个元素在数据库中的行号
     */
    private int startRow = 0;

    /**
     * 当前页面最后一个元素在数据库中的行号
     */
    private int endRow = 0;

    /**
     * 总数量
     */
    private long total = 0;

    /**
     * 总页数
     */
    private int pages = 0;

    /**
     * 首页页码
     */
    private int firstPage = 0;

    /**
     * 上一页页码
     */
    private int prePage = 0;

    /**
     * 下一页页码
     */
    private int nextPage = 0;

    /**
     * 尾页页码
     */
    private int lastPage = 0;

    /**
     * 是否为第一页
     */
    private boolean onFirstPage = false;

    /**
     * 是否为最后一页
     */
    private boolean onLastPage = false;

    /**
     * 是否有前一页
     */
    private boolean hasPreviousPage = false;

    /**
     * 是否有下一页
     */
    private boolean hasNextPage = false;

    /**
     * 所有导航页号
     */
    private int navigatePages = 0;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public boolean isOnFirstPage() {
        return onFirstPage;
    }

    public void setOnFirstPage(boolean onFirstPage) {
        this.onFirstPage = onFirstPage;
    }

    public boolean isOnLastPage() {
        return onLastPage;
    }

    public void setOnLastPage(boolean onLastPage) {
        this.onLastPage = onLastPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }
}
