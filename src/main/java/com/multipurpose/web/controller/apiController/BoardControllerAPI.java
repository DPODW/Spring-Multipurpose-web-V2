package com.multipurpose.web.controller.apiController;

import com.multipurpose.web.service.boardservice.BoardCheckService;
import com.multipurpose.web.service.boardservice.BoardFindService;
import com.multipurpose.web.service.boardservice.BoardService;
import com.multipurpose.web.vo.boardvo.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/boardAPI")
public class BoardControllerAPI {
    private final BoardService boardService;

    private final BoardFindService boardFindService;

    private final BoardCheckService boardCheckService;

    /**
     * number field 에 null 이 넘어가도 DB 에 AUTO_INCREMENT 로 설계되어있어서
     * 저장시에는 정상적으로 번호가 부여됨.
     * 
     * UPDATE , DELETE 시에는 number 를 기준으로 작동되기 때문에
     * JSON 형식으로 데이터를 전송할때, NUMBER 을 특정해줘야함
     * */

    @PostMapping("/insert")
    public ResponseEntity<Board> insertBoard(@Validated @RequestBody Board board){
        boardService.writeInsert(board);
        log.info("작성 정상 작동");
        return ResponseEntity.ok(board);
    }

    @PatchMapping("/update")
    public ResponseEntity<Board> updateBoard(@Validated @RequestBody Board board){
        boardService.writeUpdate(board);
        return ResponseEntity.ok(board);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Integer> deleteBoard(@Validated @RequestBody Map<String,Integer> requestBody){
        Integer number = requestBody.get("number");
        boardService.writeDelete(number);
        log.info("삭제 정상 작동");
        return ResponseEntity.ok(number);
    }
}
