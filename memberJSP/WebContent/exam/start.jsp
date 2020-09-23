<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<font color="red"><b>
start.jsp - sendProc.jsp - sendResult.jsp 페이지 이동합니다.<br>
sendRedirect로 이동하므로 데이터는 공유하지 않습니다.<br>
주소는 sendResult.jsp가 보인다.<br>
데이터 공유없이 각각 데이터를 가지고 있음<br>
 페이지를 이동해도 데이터가 공유하지 않음
</b></font>
<br>

<font color="blue"><b>
start.jsp - forwardProc.jsp - forwardResult.jsp 페이지 이동합니다.<br>
forward로 이동하므로 데이터는 공유합니다.<br>
주소는 forwardProc.jsp로 보이지만 결과는 forwardResult.jsp가 나온다<br>
페이지가 이동하면 데이터도 공유가됨<br>
각각의 페이지가 있지만 request하면 하나의 데이터가 전체적으로 공유됨
</b></font>
<br>

<input type = "button" value="sendRedirect" 
onclick="location.href='sendProc.jsp'">
<input type ="button" value="forward"
onclick="location.href='forwardProc.jsp'">

</body>
</html>