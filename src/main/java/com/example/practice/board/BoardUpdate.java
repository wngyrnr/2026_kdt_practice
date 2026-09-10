package com.example.practice.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;



// 게시판 수정
// update
@RestController
@RequestMapping("/board")
public class BoardUpdate {

    @Autowired
    BoardSelectService boardselectservice;

    // edit/boardId로 게시판 데이터 페이지 요청
    // 가져온 데이터 확인
    @GetMapping("/select/{boardId}")
    BoardUpdateDto select(@PathVariable Long boardId){
        return boardselectservice.select(boardId);
    }
    @PostMapping("/edit/{boardId}")
    Long update(@RequestBody BoardUpdateDto dto){
        return null;
    }

}

    @Service
    class BoardSelectService{

        @Autowired
        MapperUpdate mapperupdate;

        BoardUpdateDto select(Long boardId){
            return mapperupdate.selectBoardId(boardId);
        }
    }







// 수정 후 db에 update로 삽입
// 수정한 해당 게시판 boarId값 리턴받아서 확인









    // db에 select로 게시판 데이터 가져옴
    @Mapper
    interface MapperUpdate{
        BoardUpdateDto selectBoardId(Long boardId);
    }



@AllArgsConstructor
@Setter
@Getter
// 게시판 데이터를 가져올 dto생성
class BoardUpdateDto{
    private Long boardId;
    private String category;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime updatedAt;
}