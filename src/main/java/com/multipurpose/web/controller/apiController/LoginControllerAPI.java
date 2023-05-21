package com.multipurpose.web.controller.apiController;


import com.multipurpose.web.service.memberservice.LoginService;
import com.multipurpose.web.vo.membervo.LoginMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/loginAPI")
public class LoginControllerAPI {

    private final LoginService loginService;

    @PostMapping("/logins")
    public ResponseEntity<LoginMember> logins(@Validated @RequestBody LoginMember loginMember){
        if(!loginService.loginCheck(loginMember).isEmpty()){
            log.info("정상 로그인");
            return ResponseEntity.ok(loginMember);
        }else
            log.info("로그인 실패");
            return (ResponseEntity<LoginMember>) ResponseEntity.badRequest();
    }


    /**
     * VIEW 와 연동 되어야 정상적인 세션 관리 가능
     * */
    @PostMapping("/logout")
    public ResponseEntity<String> logout (HttpServletRequest request, @RequestBody LoginMember loginMember){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
          return  ResponseEntity.ok("(세션 삭제)로그아웃");
        }else
          return ResponseEntity.ok("(세션 이미 없음) 로그아웃");
    }
}
