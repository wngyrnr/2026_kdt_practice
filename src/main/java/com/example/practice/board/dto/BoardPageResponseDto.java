package com.example.practice.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@AllArgsConstructor
@Getter
public class BoardPageResponseDto {
    private List<BoardListDto> list;
    private PageInfo pageInfo;
    private SearchCondition searchCondition;
}
