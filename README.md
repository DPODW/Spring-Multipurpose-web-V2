기본적인 CRUD 프로젝트 <br>
[intellij , MyBatis , Spring boot , ajax] 

웹 동작을 위한 **일반 Controller 와** , **API 구현을 위한 API Controller** 가 있음.<br>

아이디 중복 등의 검증은 API 를 통한 비동기식으로 이루어짐.<br>

나머지 작업 (가입 , 수정 등등) 은 일반 Controller 로 동기식으로 이루어짐.
<hr>
게시판 부분은 Bean Validation 이 적용되어 있지 않음.<br>

API 는 전송 방식을 다양하게 쓰며 REST FULL 하게 되어있지만, 일반 Controller는 X

