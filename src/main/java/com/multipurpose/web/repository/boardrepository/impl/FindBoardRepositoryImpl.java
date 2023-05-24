package com.multipurpose.web.repository.boardrepository.impl;

import com.multipurpose.web.mapperJDBC.boardmapper.BoardHomeMapper;
import com.multipurpose.web.mapperJDBC.boardmapper.BoardMapper;
import com.multipurpose.web.repository.boardrepository.FindBoardRepository;
import com.multipurpose.web.vo.boardvo.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Repository
public class FindBoardRepositoryImpl implements FindBoardRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FindBoardRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    public List<Board> findAll(Board board) {
        String QueryBoardFindAll = "select * from board";
        return jdbcTemplate.query(QueryBoardFindAll, new BoardHomeMapper());
    }

    @Override
    public List<Board> findContent(Integer number) {
        String QueryBoardFindContent = "select * from board where number=?";
        log.info("{}", number);
        return jdbcTemplate.query(QueryBoardFindContent, new BoardMapper(), number);
    }
}
