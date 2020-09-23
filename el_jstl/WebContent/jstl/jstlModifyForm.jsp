<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8"/>

<sql:query var="rs" dataSource="jdbc/oracle">
 select * from usertable where id='${param.id}'
</sql:query>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="jstlModify.jsp">

<%-- <c:forEach var="row" items="${rs.rowsByIndex }"> --%>
<c:forEach var="row" items="${rs.rows }">
<table border="1">
			<tr>
				<td width="70" align="center">이름</td>
				<td>
				<%-- <input type="text" name="name" value="${row[0] }"> --%>
 				  <input type="text" name="name" value="${row.name }"></td>
			</tr><%--DB의 첫번째 행이 이름이다. --%>

			<tr>
				<td align="center">아이디</td>
				<td>
				<%-- <input type="text" name="id" value="${row[1] }" readonly> --%>
  				 <input type="text" name="id" value="${row.id }" readonly></td>
			</tr><%--DB의 두번째 행이 ID값이다 --%>

			<tr>
				<td align="center">비밀번호</td>
				<td><input type="password" name="pwd" size="30"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="수정">
				<input type="button" value="목록" onclick="location.href='jstlList.jsp'">
				<input type="reset" value="취소">
				</td>
			</tr>
</table>
</c:forEach>
</form>
</body>
</html>