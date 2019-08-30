package com.react.train.util;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;

import java.util.List;

/**
 * @description:
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/8/19
 */
public class PageUtil {
    public static final String DEFAULT_PAGE = "0";
    public static final String DEFAULT_SIZE = "10";

    private PageUtil() {
    }

    public static Page getPage(Pagination pagination, List records) {
        Page page = new Page();
        page.setSize(pagination.getSize());
        page.setCurrent(pagination.getCurrent());
        page.setRecords(records);
        page.setTotal(pagination.getTotal());
        return page;
    }

    public static void startPage(int page, int size) {
        PageHelper.startPage(page + 1, size);
    }

    public static Page getPage(int page, int size) {
        return new Page(page + 1, size);
    }

    public static void remove() {
        PageHelper.remove();
    }

    public static Page getPage(Pageable pageable) {
        return new Page(pageable.getPageNumber() + 1, pageable.getPageSize());
    }

    /** @deprecated */
    @Deprecated
    public static HttpHeaders generateHttpHeaders(Page<?> page, String baseURL) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-total-count", "" + page.getTotal());
        headers.add("Link", baseURL);
        return headers;
    }

    public static HttpHeaders getTotalHeader(Page<?> page) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-total-count", "" + page.getTotal());
        return headers;
    }

    public static Integer getPageStartIndex(Page<?> page) {
        int start = (page.getCurrent() - 1) * page.getSize();
        return start < 0 ? 0 : start;
    }

    public static Integer getPageEndIndex(Page<?> page) {
        int end = page.getCurrent() * page.getSize();
        return end;
    }

    public static <T> Page<T> getPage(Page<T> page, List<T> collection) {
        page.setRecords(pageHandler(page, collection));
        return page;
    }

    public static <T> List<T> pageHandler(Page<T> page, List<T> collection) {
        int total = collection.size();
        Integer pageEndIndex = getPageEndIndex(page);
        List<T> subList = collection.subList(getPageStartIndex(page), pageEndIndex > total ? total : pageEndIndex);
        page.setTotal((long)total);
        return subList;
    }
}
