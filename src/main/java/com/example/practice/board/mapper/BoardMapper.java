package com.example.practice.board.mapper;

import com.example.practice.board.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper
public interface BoardMapper {
    Long insert(BoardInsertDto dto);
    void insertBoardFiles(List<BoardFileDto> File);
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
