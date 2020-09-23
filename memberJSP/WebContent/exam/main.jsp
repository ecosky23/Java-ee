<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>** include directive**</h3>
<%@ include file="today.jsp"%><%--include는 today파일에 있는 모든 소스들을 가져온다 가져올때는 다른 <html>이나 <body> 같은 것들은 지워서 사용한다.--%>
				<%-- include를 사용하면 가져오는 파일과 변수명이 겹치면 안된다 --%>
<h3> ** include JSP tag**</h3>
<jsp:include page="image.jsp"/>

<%

String name ="홍길동";

%>
main.jsp name = <%=name%>

<h3> **3초뒤에 페이지 이동 ** </h3>
<% response.setHeader("Refresh", "3;url=input.jsp"); %>
<%-- 숫자 3은 초를 입력하는 위치 url은 그 주소 --%>

</body>
</html>