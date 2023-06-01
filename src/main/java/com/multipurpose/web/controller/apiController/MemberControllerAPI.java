package com.multipurpose.web.controller.apiController;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.multipurpose.web.controller.memberController.LoginController;
import com.multipurpose.web.service.memberservice.JoinCheckService;
import com.multipurpose.web.service.memberservice.MemberService;
import com.multipurpose.web.vo.membervo.JoinMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/API")
public class MemberControllerAPI {

    private final MemberService memberService;

    private final LoginController loginController;
    private final JoinCheckService joinCheckService;


    /** 회원 가입 API */
    @PostMapping("/joins")
    public ResponseEntity<JoinMember> join(@Validated @RequestBody JoinMember joinMember, BindingResult bindingResult){
        log.info("{}",joinMember);
        JSONObject jsonObject = new JSONObject(joinMember);
        String joinId = jsonObject.getString("joinId");
        String joinPwdCheck = jsonObject.getString("joinPwdCheck");
        String joinCall = jsonObject.getString("joinCall");

        if(joinCheckService.duplicateIdCheck(joinId)&&
           joinCheckService.comparePwdCheck(joinPwdCheck,joinMember.getJoinPwd())&&
           joinCheckService.duplicateCallCheck(joinCall)){
            log.info("API 회원가입 정상 실행");

            memberService.joinOk(joinMember);
            return ResponseEntity.ok(joinMember);
        }else
        log.info("회원가입 실패");
        bindingResult.reject("joinCheckFail");
        return (ResponseEntity<JoinMember>) ResponseEntity.badRequest();
    }




    /** 회원 수정 API (서버 측에서 아이디 접근 금지 필요) */
    @PatchMapping("/member1")
    public ResponseEntity<JoinMember> memberUpdate(@Validated @RequestBody JoinMember updateMember){
        JSONObject jsonObject = new JSONObject(updateMember);
        String updatePwdCheck = jsonObject.getString("joinPwdCheck");
        String updateCall = jsonObject.getString("joinCall");

        if(joinCheckService.comparePwdCheck(updatePwdCheck,updateMember.getJoinPwd())&&
           (joinCheckService.existingCallPermitCheck(updateMember.getJoinId(),updateCall)||
           joinCheckService.duplicateCallCheck(updateCall))){
            log.info("회원 수정 성공");
            memberService.memberUpdate(updateMember);
            return ResponseEntity.ok(updateMember);
        }else
        log.info("회원 수정 실패");
        return (ResponseEntity<JoinMember>) ResponseEntity.badRequest();
    }


    @DeleteMapping("/member2")
    public ResponseEntity<String> memberDelete(@Validated @RequestBody Map<String,String> requestBody){
        String joinId = requestBody.get("joinId");
        memberService.memberDelete(joinId);
        return ResponseEntity.ok(joinId);
    }

}
