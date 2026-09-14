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

    //게시글 목록 페이징처리
    public BoardPageResponseDto getBoards(int currentpage,String category,String keyword,String searchType){
        SearchCondition searchCondition = new SearchCondition(category,keyword,searchType);
        // 원하는 페이지를 가져오기 위해 한페이지 게시글수 , 시작할 offset 값을 가지고 mapper.pagenation호출
        // 검색 조건 시 해당 조건에 만족하는 게시글만 가져오기 위해 조건을 만족하는 row만 게시글 수 계산
        int totalCount = boardmapper.selectCount(searchCondition.getCategory(),searchCondition.getKeyword(),searchCondition.getSearchType());
        PageInfo pageInfo = new PageInfo(currentpage,totalCount);//페이지 계산을 위한 pageInfo생성자
        // 가져온 게시글 List<BoardListDto>에 저장.
        List<BoardListDto> list = boardmapper.pagenation(pageInfo.getPageSize(), pageInfo.getOffset(),
                                                        searchCondition.getCategory(),searchCondition.getKeyword(),
                                                        searchCondition.getSearchType());
        return new BoardPageResponseDto(list,pageInfo,searchCondition);
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
