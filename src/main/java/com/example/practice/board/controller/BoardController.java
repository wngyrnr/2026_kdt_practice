package com.example.practice.board.controller;


import com.example.practice.board.dto.*;
import com.example.practice.board.mapper.BoardMapper;
import com.example.practice.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardservice;

    @Autowired
    BoardMapper boardmapper;

    // 게시글 작성
    @PostMapping("/write")
    public Long boardInsert(@RequestBody BoardInsertDto dto) {
        return boardservice.board(dto);
    }

    //게시판 목록
    @GetMapping("/list")
    public List<BoardListDto> list(){
        return boardservice.select();
    }
    //게시글 상세페이지
    @GetMapping("/select/{boardId}")
    public BoardUpdateDto select(@PathVariable Long boardId){
        return boardservice.select(boardId);
    }

    //게시글 수정
    @PostMapping("/edit/{boardId}")
    public Long update(@RequestBody BoardUpdateDto dto){
        return boardservice.update(dto);
    }

    //게시글 삭제
    @DeleteMapping("/delete/{boardId}")
    public Long boardDelete(@PathVariable Long boardId){
        boardmapper.deleteMapper(boardId);
        return boardId; // 성공시 boardId반환
    }
}

