package com.example.practice.board.service;

import com.example.practice.board.dto.*;

import java.util.List;


public interface BoardService {
    Long board(BoardInsertDto dto); //게시글 작성 - boardId반환
    List<BoardListDto> select(); // 게시판 목록 - List<BoardListDto> 반환함.
    BoardUpdateDto select(Long boardId); // 게시글 상세페이지 - BoardUpdateDto 반환함.
    Long update(BoardUpdateDto dto); // 게시글 수정 - BoardId 반환.

}
