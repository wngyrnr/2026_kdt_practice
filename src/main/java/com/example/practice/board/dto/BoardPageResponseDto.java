package com.example.practice.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@AllArgsConstructor
@Getter
public class BoardPageResponseDto {
    private List<BoardListDto> list;
    private PageInfo pageInfo;
    private SearchCondition searchCondition;
}
