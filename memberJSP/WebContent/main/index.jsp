<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> *** 메인화면 *** </h3>


<%if(session.getAttribute("memId")==null){ %> <%-- 로그인을 하지 않은 경우 session에 저장 되어 있지 않기 때문에 뜨는 창 --%>
만약에 세션이 없으면 <br>
<a href="http://localhost:8080/memberJSP/member/writeForm.jsp">회원가입</a><br>
<a href="../member/loginForm.jsp">로그인</a><br>
<%}else{ %>
만약에 세션이 있으면<br>
<a href="../member/modifyForm.jsp">회원정보수정</a><br>
<a href="../member/logout.jsp">로그아웃</a><br>
<a href="../board/boardWriteForm.jsp">글쓰기</a><br>
<%} %>

<a href="../board/boardList.jsp?pg=1">목록</a><br><%-- 1페이지값을 넘겨 줌 무조건 1페이지에 나오기 넘어가는 것은 무조건 String 타입이다.--%>

</body>
</html>