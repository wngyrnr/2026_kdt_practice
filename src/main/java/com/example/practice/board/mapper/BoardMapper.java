package com.example.practice.board.mapper;

import com.example.practice.board.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {
    Long insert(BoardInsertDto dto);
    int selectCount(@Param("category")String category,
                    @Param("keyword")String keyword,
                    @Param("searchType")String searchType);
    List<BoardListDto> pagenation(@Param("pageSize")int pageSize,
                                  @Param("offSet")int offSet,
                                  @Param("category")String category,
                                  @Param("keyword")String keyword,
                                  @Param("searchType")String searchType);
    BoardUpdateDto selectBoardId(Long boardId);
    Long updateBoard(BoardUpdateDto dto);
    Long deleteMapper(Long boardId);


}
