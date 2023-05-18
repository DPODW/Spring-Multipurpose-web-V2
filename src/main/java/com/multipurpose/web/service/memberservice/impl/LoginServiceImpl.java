package com.multipurpose.web.service.memberservice.impl;

import com.multipurpose.web.mapper.MemberMapper;
import com.multipurpose.web.service.memberservice.LoginService;
import com.multipurpose.web.vo.membervo.LoginMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {


    private final MemberMapper memberMapper;

        @Override
        public List<LoginMember> loginCheck(LoginMember loginMember){
            return memberMapper.logins(loginMember);
    }
}
