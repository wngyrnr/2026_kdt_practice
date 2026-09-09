package com.example.practice.board;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class boardinsert {

}

// 게시판CRUD insert, select, update, delete
// 게시글 작성 , 게시글 조회, 게시글 수정, 게시글 삭제

// 게시글 작성
// insert

// schema
//board_id    BIGINT AUTO_INCREMENT PRIMARY KEY,
//                             category    VARCHAR(50)  NOT NULL,
//                             title       VARCHAR(200) NOT NULL,
//                             writer      VARCHAR(50)  NOT NULL,
//                             content     TEXT         NOT NULL,
//                             created_at  DATETIME     DEFAULT CURRENT_TIMESTAMP,
//                             updated_at




// IO파이프라인 재작성
// 데이터 input -controller에서 /write로 받음
@RestController
@RequestMapping("/board")
class boardInsertController{

    @Autowired
    private boardInsertService boardinsertserive;

    @PostMapping("/write")
        Long insertBoard(@RequestBody BoardInsertDto dto){
        boardinsertserive.boardinsert(dto);
        return dto.getBoardId();

    }
}


// 중복검사 x - db에서 키 자동 생성
// service에서 mapper로 넘김
@Service
class boardInsertService {
    @Autowired
    private Mapper mapper;

    Long boardinsert(BoardInsertDto dto) {
        mapper.insert(dto);
        return dto.getBoardId();

    }
}


    // mapper에서 db에 insert
    @org.apache.ibatis.annotations.Mapper
    interface Mapper {
        Long insert(BoardInsertDto dto);
    }


    // 데이터는 Dto에 저장함
// 데이터 input (writer, category, title, content) -> DTO에 담음
// board_id는 받지않음 - mybatis - useGeneratedKeys가 키를 생성해줌
    @Getter
    @Setter
    class BoardInsertDto {
        private Long boardId; // DB에 저장 후 반환된 board를 저장
        private String title; // 게시글 제목
        private String category; // 게시글 카테고리
        private String content; // 게시글 내용
        private String writer; // 게시글 작성자
    }












// interface mapper에서 메서드와 xml의 id값과 같은 mapper를 찾음
// dto의 키값과 같은 이름을 가진 애들을 찾아 값으로 넣어줌
// DB에 저장됨 이때 AUTO_INCREMENT로 키가 자동으로 생성됨
// DEFAULT CURRENT_TIMESTAMP로 설정한 시간도 자동으로 저장됨.
// 생성된 board_id를 mybatis에 useGeneratedKey="true"로 가져옴
// 가져온 board_id를 keyProperty="boardId"로 객체의 boardId에 stter로 넣음
// Dto의 boardId 반환

// 파이프라인 작성 - 9분