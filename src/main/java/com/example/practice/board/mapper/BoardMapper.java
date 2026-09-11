package com.example.practice.board.mapper;

import com.example.practice.board.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    Long insert(BoardInsertDto dto);
    int selectCount();
    List<BoardListDto> pagenation(int pageSize, int offSet);
    BoardUpdateDto selectBoardId(Long boardId);
    Long updateBoard(BoardUpdateDto dto);
    Long deleteMapper(Long boardId);


}
