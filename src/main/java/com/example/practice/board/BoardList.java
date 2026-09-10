package com.example.practice.board;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardList {

    @Autowired
    ListMapper listmapper;

    // 게시판목록 조회
    //select
    // 게시판 목록 요청
    // db에 select요청함
    @GetMapping("/list")
    List<BoardListDto> select(){
        List<BoardListDto> list = listmapper.selectAll();
        return list;
    }
}




// list<dto>에 담아서 반환
// list에서 dto하나씩 꺼내서 반환
@Mapper
interface ListMapper{
     List<BoardListDto> selectAll();
    }




@AllArgsConstructor
@Getter
class BoardListDto{
    private String category;
    private String title;
    private String writer;
    private LocalDateTime createdAt;

}