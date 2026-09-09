package com.example.practice.board;



public class boardinsert {

}





interface mapper{

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

// 데이터 input (writer, category, title, content) -> DTO에 담음
// board_id는 받지않음 - mybatis - useGeneratedKeys가 키를 생성해줌
// service에서 mapper 호출 dto넘김
// interface mapper에서 메서드와 xml의 id값과 같은 mapper를 찾음
// dto의 키값과 같은 이름을 가진 애들을 찾아 값으로 넣어줌
// DB에 저장됨 이때 AUTO_INCREMENT로 키가 자동으로 생성됨
// DEFAULT CURRENT_TIMESTAMP로 설정한 시간도 자동으로 저장됨.
// 생성된 board_id를 mybatis에 useGeneratedKey="true"로 가져옴
// 가져온 board_id를 keyProperty="boardId"로 객체의 boardId에 stter로 넣음
// Dto의 boardId 반환