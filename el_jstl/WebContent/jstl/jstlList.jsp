<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<sql:query var="rs" dataSource="jdbc/oracle">
	select * from usertable
</sql:query>
<%--sql:query은 select와 같은 말이다 usertable의 모든내용을 가져와라
dataSource="jdbc/oracle"은 connectionPool의 DB연결방식이다. var="rs"결과갑을 받아오는 방식이다.--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
 <!-- 컬럼명 -->
 <tr>
  <c:forEach var="colName" items="${rs.columnNames }">
  	<th>${colName }</th>
  </c:forEach>
  <th width="150">비고</th>
 </tr>

 <c:forEach var="row" items="${rs.rowsByIndex }"><%-- var=변수, items="rs의 행을 구해오기"--%>
  <tr>
  	<c:forEach var="col" items="${row }"> <%--열 row의 값을 하나씩 col에 넣어준다 --%>
  	 <td width="100" align="center">${col }</td>
  	</c:forEach>
  	 <td align="center">
  	  <input type="button" value="수정" onclick="location.href='jstlModifyForm.jsp?id=${row[1]}'">
  	  <input type="button" value="삭제" onclick="location.href='jstlDelete.jsp?id=${row[1]}'"><%-- 열의 첫번째 열이 id라서 row[1]의 값을 넘겨줘야 한다. --%>
  	 </td>
  </tr>
 </c:forEach>
</table>
</body>
</html> 