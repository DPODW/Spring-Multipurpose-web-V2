
$(document).ready(function() {
    $("#request").click(function(event) {
        event.preventDefault(); // 폼의 기본 동작인 페이지 이동을 막습니다.

        const BoardData = {
            number:$("#number").val(),
            id: $("#UpdateName").val(),
            title: $("#UpdateTitle").val(),
            content: $("#UpdateContent").val()
        };

        $.ajax({
            url: "/boardAPI/update",
            type: "PATCH",
            async: true,
            data: JSON.stringify(BoardData),
            contentType: 'application/json',
            success: function(response) {
                alert("게시글 수정 성공");
            },
            error: function(error) {
                alert("게시글 수정 실패");
            }
        });
    });
});
