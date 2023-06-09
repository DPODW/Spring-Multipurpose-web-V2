package com.multipurpose.web.mapper.member;

import com.multipurpose.web.vo.membervo.JoinMember;
import com.multipurpose.web.vo.membervo.LoginMember;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FindMemberMapper {

    List<JoinMember> findMemberUseLoginInfo(LoginMember loginMember);

    List<JoinMember> findDuplicateId(String duplicateId);

    List<JoinMember> findDuplicateCall(String duplicateCall);

    List<JoinMember> findCallById(String existingCallId);
}
