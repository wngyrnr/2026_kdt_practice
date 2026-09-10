package com.example.practice.board.service;

import com.example.practice.board.dto.*;
import com.example.practice.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardMapper boardmapper;

    // 게시글 작성
    public Long board(BoardInsertDto dto){
        boardmapper.insert(dto);
        return dto.getBoardId();
    }

    // 게시글 목록
    public List<BoardListDto> select(){
        List<BoardListDto> list = boardmapper.selectAll();
        return list;
    }

    // 게시글 상세페이지
    public BoardUpdateDto select(Long boardId){
        return boardmapper.selectBoardId(boardId);
    }

    // 게시글 수정
    public Long update(BoardUpdateDto dto){
        boardmapper.updateBoard(dto);
        return dto.getBoardId();
    }

}
