package com.multipurpose.web.controller.boardController;


import com.multipurpose.web.mapper.SessionConst;
import com.multipurpose.web.service.boardservice.BoardCheckService;
import com.multipurpose.web.service.boardservice.BoardFindService;
import com.multipurpose.web.service.boardservice.BoardService;
import com.multipurpose.web.vo.boardvo.Board;
import com.multipurpose.web.vo.membervo.LoginMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    private final BoardFindService boardFindService;

    private final BoardCheckService boardCheckService;

    /**
     * 접근 컨트롤러
     * */
    @GetMapping("")
    public String writeBoardForm(HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);
        LoginMember writerInfo = (LoginMember) session.getAttribute(SessionConst.LOGIN_MEMBER);
        model.addAttribute("id",writerInfo);
        return "boards/BoardWrite";
    }


    @GetMapping("/board1/{number}/{id}")
    public String updateBoardForm(@PathVariable("number") Integer number, @PathVariable("id") String id,
                                  HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);
        LoginMember updaterInfo = (LoginMember) session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(boardCheckService.accessCheck(id,updaterInfo.getLoginId())==true){
            List<Board> updateContentList = boardFindService.findContent(number);
            Board updateContent = updateContentList.get(0);
            model.addAttribute("updateContent",updateContent);
            return "boards/BoardUpdate";
        } else {
            return "redirect:/boardHome";
        }
    }


    @GetMapping("/board2/{number}/{id}")
    public String deleteBoardForm(@PathVariable("number") Integer number, @PathVariable("id") String id,
                                  HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);
        LoginMember deleterInfo = (LoginMember) session.getAttribute(SessionConst.LOGIN_MEMBER);
        if(boardCheckService.accessCheck(id,deleterInfo.getLoginId())==true){
            List<Board> deleteContentList = boardFindService.findContent(number);
            Board deleteContent = deleteContentList.get(0);
            model.addAttribute("deleteContent",deleteContent);
            return "boards/BoardDelete";
        }else{
            return "redirect:/boardHome";
        }
    }


    @PostMapping("")
    public String writeBoard(@Validated @ModelAttribute Board board){
        boardService.writeInsert(board);
        return "redirect:/boardHome";
    }


    @PostMapping("/board1")
    public String updateBoard(@Validated @ModelAttribute Board board){
        log.info("{}",board);
        boardService.writeUpdate(board);
        return "redirect:/boardHome";
    }


    @PostMapping("/board2")
    public String deleteBoard(@RequestParam("number") Integer number){
        log.info("{}",number);
        boardService.writeDelete(number);
        return "redirect:/boardHome";
    }
}
