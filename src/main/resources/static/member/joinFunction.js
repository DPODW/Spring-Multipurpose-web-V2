 function validateInputId() {
    const input = document.getElementById("JoinId");
    if (input.value === "") {
    alert("정보를 입력해주세요!");
}
}

    function validateInputPwd() {
        const input = document.getElementById("JoinPwdCheck");
        if (input.value === "") {
        alert("정보를 입력해주세요!");
    }
    }

    function validateInputCall() {
        const input = document.getElementById("JoinCall");
        if (input.value === "") {
        alert("정보를 입력해주세요!");
    }
    }


 $(document).ready(function() {
     $("#request").click(function(event) {
         event.preventDefault(); // 폼의 기본 동작인 페이지 이동을 막습니다.

         const MemberData = {
             joinName: $("#JoinName").val(),
             joinId: $("#JoinId").val(),
             joinPwd: $("#JoinPwd").val(),
             joinPwdCheck: $("#JoinPwdCheck").val(),
             joinCall: $("#JoinCall").val()
         };

         $.ajax({
             url: "/API/joins",
             type: "POST",
             async: true,
             data: JSON.stringify(MemberData),
             contentType: 'application/json',
             success: function(response) {
                 alert("저장 성공");
             },
             error: function(error) {
                 alert("저장 실패");
             }
         });
     });


     $("#checkId").click(function(event) {
         event.preventDefault(); // 폼의 기본 동작인 페이지 이동을 막습니다.

         const MemberData = {
             joinId: $("#JoinId").val()
         };

         $.ajax({
             url: "/JC/id",
             type: "POST",
             async: true,
             data: JSON.stringify(MemberData),
             contentType: 'application/json',
             success: function(response) {
                 alert(" 아이디 사용 가능");
             },
             error: function(error) {
                 alert("아이디 중복");
             }
         });
     });


     $("#checkPwd").click(function(event) {
         event.preventDefault(); // 폼의 기본 동작인 페이지 이동을 막습니다.

         const MemberData = {
             joinPwd: $("#JoinPwd").val(),
             joinPwdCheck: $("#JoinPwdCheck").val()
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
             error: function(error) {
                 alert("비밀번호 다름");
             }
         });
     });


     $("#checkCall").click(function(event) {
         event.preventDefault(); // 폼의 기본 동작인 페이지 이동을 막습니다.

         const MemberData = {
             joinCall: $("#JoinCall").val()
         };

         $.ajax({
             url: "/JC/call",
             type: "POST",
             async: true,
             data: JSON.stringify(MemberData),
             contentType: 'application/json',
             success: function(response) {
                 alert("전화번호 사용 가능");
             },
             error: function(error) {
                 alert("전화번호 중복, 사용불가");
             }
         });
     });
 });