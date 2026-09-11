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
    @GetMapping("/list/{currentPage}")
    public BoardPageResponseDto boardgetBoards(@PathVariable int currentPage){
        return boardservice.getBoards(currentPage);
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


//게시글 검색 처리
// category / content,title,writer 에 대한 정보 input
// 그럼 정보를 어떻게 받아와야될까 ? category는 전체라는 값이 있을 수 있어서 content,title,writer랑 분리해서 조건처리함
// when category, title, writer, content 정보를 받아옴
// 그 정보에 맞는 mapper 작성 후 db에서 검색 조건만 뽑아서 정렬 후 페이징처리된 상태로 list반환 > 검색조건을 페이징에 앞에 넣으면 될듯
// search(list<dto>,검색조건,페이징)형태로 전달하는게 좋아보임