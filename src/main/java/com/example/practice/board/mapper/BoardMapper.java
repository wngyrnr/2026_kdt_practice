package com.example.practice.board.mapper;

import com.example.practice.board.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    Long insert(BoardInsertDto dto);
    List<BoardListDto> selectAll();
    BoardUpdateDto selectBoardId(Long boardId);
    Long updateBoard(BoardUpdateDto dto);
    Long deleteMapper(Long boardId);


}
