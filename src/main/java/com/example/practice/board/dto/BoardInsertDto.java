package com.example.practice.board.dto;


import lombok.Getter;
import lombok.Setter;


// 중복검사 x - boardId DB에서 자동 생성 AUTO_INCREMENT
// dto에 저장 title, category, content , writer
@Setter
@Getter
public class BoardInsertDto {
private Long boardId; // DB에 저장 후 반환된 board를 저장
private String title; // 게시글 제목
private String category; // 게시글 카테고리
private String content; // 게시글 내용
private String writer; // 게시글 작성자
}
    // insert - title, category, content , writer


// DB저장 - boardId(AUTO_INCREMENT), title, category, content , writer, createat(CURRENT_TIMESTAMP)
    // mybatis - useGeneratedKeys = "true"로 boardid 반환 -> keyProperty="boardId" 객체의 boardId에 저장
    // 객체에 저장된 boardId 반환해줌.



//Required by:
//         root project 'practice'

//1. spring 3.x 기준 자바 17사용 - 문제없음 17사용중
//2. JVM도 17.x
//3. gradle. 의존성 문제