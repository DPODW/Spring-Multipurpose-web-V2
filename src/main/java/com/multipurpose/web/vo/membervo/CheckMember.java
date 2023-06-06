package com.multipurpose.web.vo.membervo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
public class CheckMember {

    @Nullable
    @Pattern(regexp = "[a-zA-Z0-9\uAC00-\uD7AF]*")//한글  영어 숫자 허용
    @Length(min=2, max= 20)
    private String joinName;

    @Nullable
    @Length(min=2, max= 20)
    private String joinId;

    @Nullable
    @Length(min=10, max= 20)
    private String joinPwd;

    @Nullable
    @Length(min=11, max= 11)
    private String joinCall;

    @Nullable
    private String joinPwdCheck;


    public CheckMember(String joinName, String joinId, String joinPwd, String joinCall) {
        this.joinName = joinName;
        this.joinId = joinId;
        this.joinPwd = joinPwd;
        this.joinCall = joinCall;
    }
}
