<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/mvcMember/member/checkId.do"><%--checkIdService에서 request에 넣어둔 id를 requestScope를 이용해서 가져온다. --%>
${requestScope.id }는 사용불가능
<br><br>
아이디<input type="text" name="id">
<input type="submit" value="검색">

</form>
</body>
<script text="text/javascript">
window.onload=function(){
	alert("아이디가 중복됩니다.");
}
</script>
</html>