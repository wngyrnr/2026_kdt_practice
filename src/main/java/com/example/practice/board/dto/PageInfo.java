package com.example.practice.board.dto;

import lombok.Getter;


@Getter
public class PageInfo {

    private int currentPage; // 현재 페이지 번호
    private int pageSize =10; // 페이지당 출력할 게시글 수
    private int totalCount; // 총 게시글 수
    private int maxPage; // 총 페이지 수
    private int offset; // DB 인덱스 번호

    public PageInfo(int currentpage,int totalCount){
        currentPage = currentpage;
        this.totalCount = totalCount;
        this.maxPage = ((int)Math.ceil((double)totalCount / pageSize));
        this.offset = (currentpage-1)*pageSize;
    }
}

