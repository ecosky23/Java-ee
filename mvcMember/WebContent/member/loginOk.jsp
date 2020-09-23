<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img alt="" src="../image/mon.jpg" width="100" height="100" onclick="location.href='../main/index.jsp'" style="cursor:pointer;"><br>

<br>${sessionScope.memName}님 로그인<%--session에서 가져오기 --%>
<br><br>
<input type="button" value="로그아웃" onclick="location.href='/mvcMember/member/logout.do'">
<input type="button" value="회원정보수정" onclick="location.href=''">

</body>
</html>