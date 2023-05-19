package com.multipurpose.web.service.memberservice;

import com.multipurpose.web.vo.membervo.JoinMember;
import com.multipurpose.web.vo.membervo.LoginMember;

import java.util.List;

public interface LoginService {

    List<JoinMember> loginCheck(LoginMember loginMember);
}
