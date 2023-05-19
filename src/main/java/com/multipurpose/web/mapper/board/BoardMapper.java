package com.multipurpose.web.mapper.board;


import com.multipurpose.web.vo.boardvo.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardMapper {

    void boardInsert(Board board);

    void boardUpdate(Board board);

    void boardDelete(Integer number);
}
