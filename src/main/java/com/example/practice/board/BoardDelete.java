package com.example.practice.board;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


// 게시판 삭제
// delete
@RestController
@RequestMapping("/board")
public class BoardDelete {

    @Autowired
    DeleteMapper deletemapper;

    // 게시판 delete/boardid 로 요청
    @DeleteMapping("/delete/{boardId}")
    Long boardDelete(@PathVariable Long boardId){
        deletemapper.deleteMapper(boardId);
        // 성공시 기존 boardid반환
        return boardId;
    }

}

// db접속 후 해당 board_table - boardid delete
    @Mapper
    interface DeleteMapper{
    Long deleteMapper(Long boardId);
    }





