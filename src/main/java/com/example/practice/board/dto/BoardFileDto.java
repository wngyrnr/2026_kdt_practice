package com.example.practice.board.dto;


import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class BoardFileDto {
    private Long fileId;
    private Long boardId;
    private Long fileSize;
    private String fileName;
    private String originalName;
    private String filePath;
    private String fileType;
}
