package com.ssm.bsms.common.pages;

import com.github.pagehelper.PageInfo;

/**
 * Created by Administrator on 2016/12/20.
 */
public class PageConverter<T> {
    public PagesObject<T> converter(PageInfo<T> pageInfo) {
        PagesObject pagesObject = new PagesObject();
        
        pagesObject.setData(pageInfo.getList());
        pagesObject.setPageNum(pageInfo.getPageNum());
        pagesObject.setPageSize(pageInfo.getPageSize());
        pagesObject.setSize(pageInfo.getSize());
        pagesObject.setSort(pageInfo.getOrderBy());
        pagesObject.setStartRow(pageInfo.getStartRow());
        pagesObject.setEndRow(pageInfo.getEndRow());
        pagesObject.setTotal(pageInfo.getTotal());
        pagesObject.setPages(pageInfo.getPages());
        
        return pagesObject;
    }
}
