
$(document).ready(function() {
    $("#request").click(function(event) {
        event.preventDefault(); // 폼의 기본 동작인 페이지 이동을 막습니다.

        const BoardData = {
            number: $("#number").val()
        };

        $.ajax({
            url: "/boardAPI/delete",
            type: "DELETE",
            async: true,
            data: JSON.stringify(BoardData),
            contentType: 'application/json',
            success: function(response) {
                alert("게시글 삭제 성공");
            },
            error: function(error) {
                alert("게시글 삭제 실패");
            }
        });
    });
});
