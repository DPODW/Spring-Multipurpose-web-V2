package com.multipurpose.web.mapper.member;

import com.multipurpose.web.vo.membervo.JoinMember;
import com.multipurpose.web.vo.membervo.LoginMember;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MemberMapper {

    void insert(JoinMember member);
    void update(JoinMember updateMember);
    void delete(JoinMember deleteMember);
    List<JoinMember> logins(LoginMember loginMember);
}
