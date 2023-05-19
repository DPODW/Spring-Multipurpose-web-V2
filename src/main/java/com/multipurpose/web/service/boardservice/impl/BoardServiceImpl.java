package com.multipurpose.web.service.boardservice.impl;

import com.multipurpose.web.mapper.board.BoardMapper;
import com.multipurpose.web.service.boardservice.BoardService;
import com.multipurpose.web.vo.boardvo.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;


    @Override
    public void writeInsert(Board board) {
        boardMapper.boardInsert(board);
    }

    @Override
    public void writeUpdate(Board board) {
        boardMapper.boardUpdate(board);
    }

    @Override
    public void writeDelete(Integer number) {
        boardMapper.boardDelete(number);
    }
}
