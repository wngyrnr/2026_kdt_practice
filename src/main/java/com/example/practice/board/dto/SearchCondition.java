package com.example.practice.board.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SearchCondition {
    private String category; // 카테고리
    private String keyword; // 검색어
    private String searchType; // 작성자 / 글내용 / 글제목 분류

}
