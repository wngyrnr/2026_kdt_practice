package com.example.practice.board.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
public class BoardListDto {
    private String category;
    private String title;
    private String writer;
    private LocalDateTime createdAt;

}