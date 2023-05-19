package com.multipurpose.web.service.boardservice.impl;

import com.multipurpose.web.mapper.board.FindBoardMapper;
import com.multipurpose.web.service.boardservice.BoardFindService;
import com.multipurpose.web.vo.boardvo.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardFindServiceImpl implements BoardFindService {



    private final FindBoardMapper findBoardMapper;



    @Override
    public List<Board> findAll(Board board) {
        return findBoardMapper.findAll(board);
    }

    @Override
    public List<Board> findContent(Integer number) {
        return findBoardMapper.findContent(number);
    }
}
