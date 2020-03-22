package com.example.junwei.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showEndPage;
    private Integer page;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;


    public void setPagination(Integer totalCount, Integer page, Integer size) {

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        //如果输入页面小于1，则输出第一个页面
        if (page < 1) {
            page = 1;
        }
        //如果输入页面大于最多页面，则输出最后一个页面
        if (page > totalPage) {
            page = totalPage;
        }
        this.page = page;
        pages.add(page);//传进来的当前页码
        for (int i = 1; i <= 3; i++) {
            if (page - 1 > 0 && page - i > 0) {
                pages.add(0, page - i);//循环传左边三个页码
            }
            if (page + i <= totalPage) {
                pages.add(page + i); //循环传右边三个页码
            }
        }




        //是否展示上一页
        if (page == 1) {
            showPrevious = false;
        } else {
            showPrevious = true;
        }

        //是否展示到下一页
        if (page == totalPage) {
            showNext = false;
        } else {
            showNext = true;
        }

        //是否展示第一页标签
        if (pages.contains(1)) {
            showFirstPage = false;
        } else {
            showFirstPage = true;
        }

        //是否展示最后一页标签
        if (pages.contains(totalPage)) {
            showEndPage = false;
        } else {
            showEndPage = true;
        }

    }
}
