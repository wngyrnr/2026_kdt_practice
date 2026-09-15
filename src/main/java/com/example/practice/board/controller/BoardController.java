package com.example.practice.board.controller;


import com.example.practice.board.dto.*;
import com.example.practice.board.mapper.BoardMapper;
import com.example.practice.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public Long boardInsert(@ModelAttribute BoardInsertDto dto,
                            @RequestParam(value = "file", required = false) MultipartFile file
                            ) {
        return boardservice.board(dto, file);
    }

    //게시판 목록
    @GetMapping("/list")
    public BoardPageResponseDto boardgetBoards(@RequestParam(name = "page", required = false, defaultValue = "1") int currentPage,
                                               @RequestParam(name = "category", required = false, defaultValue = "전체") String category,
                                               @RequestParam(name = "keyword", required = false) String keyword,
                                               @RequestParam(name = "searchType", required = false, defaultValue = "title") String searchType
                                               ){
        return boardservice.getBoards(currentPage,category,keyword,searchType);
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

// 파일 업로드
// insert
// 파일 업로드 형식 - multipart/form-data
// 파일과 게시판 분리해서 parameter받기
// this.boardId = boardId;
//        this.orgFileName = orgFileName;
//        this.savedFileName = savedFileName;
//        this.savedPath = savedPath;
//        this.fileSize = fileSize; 저장
// board_table에는 saveFileName만 저장
// Controller에서 파일이 없거나 빈 파일 조건
// 저장됐는지 Transaction걸어서 확인하기
// DB에는 file_id / board_id / file_name / original_name / file_path
//      created_at / file_size / file_type
// 만 저장하고 실제 사진은 local에 따로 저장
// board_id를 fk로 설정
// 저장성공 시 board_id반환