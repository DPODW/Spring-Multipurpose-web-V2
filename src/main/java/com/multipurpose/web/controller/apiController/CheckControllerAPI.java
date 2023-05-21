package com.multipurpose.web.controller.apiController;

import com.multipurpose.web.service.memberservice.JoinCheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class CheckControllerAPI {

    private final JoinCheckService joinCheckService;

    /**
     * 검증 기능 컨트롤러 API
     * MAP 으로 JSON 객체 추출
     * */
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

    @PostMapping("/pwd")
    public ResponseEntity<String> pwdSameCheck(@Validated  @RequestBody Map<String,String> requestBody){
        String joinPwd = requestBody.get("joinPwd");
        String joinPwdCheck = requestBody.get("joinPwdCheck");
        if(joinCheckService.comparePwdCheck(joinPwdCheck,joinPwd) == true){
            log.info("비밀번호 동일");
            return ResponseEntity.ok(joinPwdCheck);
        }else
            log.info("비밀번호 다름");
            return (ResponseEntity<String>) ResponseEntity.badRequest();
    }



    @PostMapping("/call")
    public ResponseEntity<String> callDuplicationCheck(@Validated @RequestBody Map<String,String> requestBody){
        String joinCall = requestBody.get("joinCall");
        if(joinCheckService.duplicateCallCheck(joinCall)){
            log.info("전화번호 o");
            return ResponseEntity.ok(joinCall);
        }else
            log.info("전화번호 중복");
            return (ResponseEntity<String>) ResponseEntity.badRequest();
    }


    @PostMapping("/call1")
    public ResponseEntity<String> UcallDuplicationCheck(@Validated @RequestBody Map<String,String> requestBody){
        String joinCall = requestBody.get("joinCall");
        String joinId = requestBody.get("joinId");
        if(joinCheckService.duplicateCallCheck(joinCall) == true ||
           joinCheckService.existingCallPermitCheck(joinId,joinCall)){
            log.info("현재 전화번호 or 변경 가능한 전화번호 ");
            return ResponseEntity.ok(joinCall);
        }else
            log.info("전화번호 중복");
        return (ResponseEntity<String>) ResponseEntity.badRequest();
    }



}
