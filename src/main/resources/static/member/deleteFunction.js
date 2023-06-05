
$(document).ready(function() {
    $("#request").click(function (event) {
        event.preventDefault(); // 폼의 기본 동작인 페이지 이동을 막습니다.

        const MemberData = {
            joinId: $("#DeleteId").val()
        };

        $.ajax({
            url: "/API/member2",
            type: "DELETE",
            async: true,
            data: JSON.stringify(MemberData),
            contentType: 'application/json',
            success: function (response) {
                alert("삭제 성공");
            },
            error: function (error) {
                alert("삭제 실패");
            }
        });
    });
});
