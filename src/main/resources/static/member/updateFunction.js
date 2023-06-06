

$(document).ready(function() {
    $("#request").click(function(event) {
        event.preventDefault(); // 폼의 기본 동작인 페이지 이동을 막습니다.

        const MemberData = {
            joinName: $("#UpdateName").val(),
            joinId: $("#UpdateId").val(),
            joinPwd: $("#UpdatePwd").val(),
            joinPwdCheck: $("#updatePwdCheck").val(),
            joinCall: $("#updateCall").val()
        };

        $.ajax({
            url: "/API/member1",
            type: "PATCH",
            async: true,
            data: JSON.stringify(MemberData),
            contentType: 'application/json',
            success: function(response) {
                alert("수정 성공");
            },
            error: function(error) {
                alert("수정 실패");
            }
        });
    });


    $("#checkPwd").click(function(event) {
        event.preventDefault(); // 폼의 기본 동작인 페이지 이동을 막습니다.

        const MemberData = {
            joinPwd: $("#UpdatePwd").val(),
            joinPwdCheck: $("#updatePwdCheck").val()
        };

        $.ajax({
            url: "/JC/pwd",
            type: "POST",
            async: true,
            data: JSON.stringify(MemberData),
            contentType: 'application/json',
            success: function(response) {
                alert("비밀번호 동일");
            },
            error: function(jqXHR) {
                if(jqXHR.status == 400){
                    alert("비밀번호 형식을 다시 확인해주세요");
                }else if(jqXHR.status == 500){
                    alert("비밀번호가 동일하지 않습니다");
                }else
                    alert("예기치 않은 오류");
            }
        });
    });


    $("#checkCall").click(function(event) {
        event.preventDefault(); // 폼의 기본 동작인 페이지 이동을 막습니다.

        const MemberData = {
            joinId: $("#UpdateId").val(),
            joinCall: $("#updateCall").val()
        };

        $.ajax({
            url: "/JC/call1",
            type: "POST",
            async: true,
            data: JSON.stringify(MemberData),
            contentType: 'application/json',
            success: function(response) {
                alert("전화번호 사용 가능");
            },
            error: function(jqXHR, textStatus, errorThrown) {
                if(jqXHR.status == 400){
                    alert("전화번호 형식을 다시 확인해주세요");
                }else if(jqXHR.status == 500){
                    alert("전화번호 중복 입니다");
                }else
                    alert("예기치 않은 오류");
            }
        });
    });
});