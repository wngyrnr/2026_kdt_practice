package com.example.practice.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


// 수정한 해당 게시판 boarId값 리턴받아서 확인


@AllArgsConstructor
@Setter
@Getter
// 게시판 데이터를 가져올 dto생성
public class BoardUpdateDto {
    private Long boardId;
    private String category;
    private String title;
    private String content;
    private String writer;
}