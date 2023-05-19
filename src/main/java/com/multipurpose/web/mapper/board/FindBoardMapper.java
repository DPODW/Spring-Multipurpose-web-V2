package com.multipurpose.web.mapper.board;

import com.multipurpose.web.vo.boardvo.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FindBoardMapper {
    List<Board> findAll (Board board);

    List<Board> findContent (Integer number);
}
