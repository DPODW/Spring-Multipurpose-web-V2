
$(document).ready(function() {
    $("#request").click(function(event) {
        event.preventDefault(); // 폼의 기본 동작인 페이지 이동을 막습니다.

        const BoardData = {
            id: $("#WriterName").val(),
            title: $("#WriteTitle").val(),
            content: $("#WriterContent").val(),
        };

        $.ajax({
            url: "/board/insert",
            type: "POST",
            async: true,
            data: JSON.stringify(BoardData),
            contentType: 'application/json',
            success: function(response) {
                alert("게시글 저장 성공");
            },
            error: function(error) {
                alert("게시글 저장 실패");
            }
        });
    });
});
