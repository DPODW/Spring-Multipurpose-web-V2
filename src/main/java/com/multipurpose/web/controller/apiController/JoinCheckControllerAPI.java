package com.multipurpose.web.controller.apiController;

import com.multipurpose.web.service.memberservice.JoinCheckService;
import com.multipurpose.web.vo.membervo.JoinMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/JC")
public class JoinCheckControllerAPI {

    private final JoinCheckService joinCheckService;

    @PostMapping("/id")
    public ResponseEntity<JoinMember> idDuplicationCheck(@Validated @RequestBody JoinMember joinMember){
        JSONObject jsonObject = new JSONObject(joinMember);
        String joinId = jsonObject.getString("joinId");
        if(joinCheckService.duplicateIdCheck(joinId) == true){
            log.info("사용 가능 아이디");
            return ResponseEntity.ok(joinMember);
        }else
            log.info("중복 아이디 ");
            return (ResponseEntity<JoinMember>) ResponseEntity.badRequest();
    }

    @PostMapping("/id2")
    public ResponseEntity<String> idDuplicationCheck1(@Validated @RequestBody String joinId){
        JSONObject jsonObject = new JSONObject(joinId);
        String joinId1 = jsonObject.getString("joinId");
        if(joinCheckService.duplicateIdCheck(joinId1) == true){
            log.info("사용 가능 아이디");
            return ResponseEntity.ok(joinId1);
        }else
            log.info("중복 아이디 ");
        return (ResponseEntity<String>) ResponseEntity.badRequest();
    }






}
