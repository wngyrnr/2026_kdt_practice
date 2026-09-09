package com.example.practice.board;

public class BoardInsertController {



    // 데이터 들어옴 title, category, content , writer
    // 중복검사 x - boardId DB에서 자동 생성 AUTO_INCREMENT
    // dto에 저장 title, category, content , writer
    // insert - title, category, content , writer
    // DB저장 - boardId(AUTO_INCREMENT), title, category, content , writer, createat(CURRENT_TIMESTAMP)
    // mybatis - useGeneratedKeys = "true"로 boardid 반환 -> keyProperty="boardId" 객체의 boardId에 저장
    // 객체에 저장된 boardId 반환해줌.

}
