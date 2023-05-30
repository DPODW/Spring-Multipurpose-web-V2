package com.multipurpose.web.controller.apiController;

import com.multipurpose.web.service.memberservice.JoinCheckService;
import com.multipurpose.web.vo.membervo.JoinMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/JC")
public class JoinCheckControllerAPI {

    private final JoinCheckService joinCheckService;

    @PostMapping("/id")
    public ResponseEntity<String> idDuplicationCheck1(@Validated @RequestBody Map<String ,String> requestBody){
        String joinId = requestBody.get("joinId");
        if(joinCheckService.duplicateIdCheck(joinId) == true){
            log.info("사용 가능 아이디");
            log.info("{}",joinId);
            return ResponseEntity.ok(joinId);
        }else
            log.info("중복 아이디 ");
            log.info("{}",joinId);
        return (ResponseEntity<String>) ResponseEntity.badRequest();
    }

    



}
