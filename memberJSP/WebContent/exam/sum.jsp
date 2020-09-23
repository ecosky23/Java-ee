<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<jsp:useBean id="dataDTO" class="exam.bean.DataDTO" scope="session"/><!-- 데이터 생성 jsp:usebean 객체를 사용하기 위해 사용  -->    
    						<!-- id=객체명 class="풀쿼리명을 따쓰기 앞의 패키지 명까지 다쓰기" scope="유효범위" session -> 로그인이 되있는동안 사용한다.-->

<jsp:setProperty property="x" name="dataDTO"/><!-- property의 x는 dataDTO.setX 를 의미 -->
<jsp:setProperty property="y" name="dataDTO"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="mul.jsp">
<jsp:getProperty property="x" name="dataDTO"/>+
<jsp:getProperty property="y" name="dataDTO"/>=
<%=dataDTO.getX() + dataDTO.getY()%><br><br>


<br><input type="button" value="곱구하기" onclick="location.href='mul.jsp'"> <!-- 주소는 띄어쓰기 하면 안된다. x와 y를 보내서 리퀘스트로 받아준다.-->
<%--  <input type="hidden" name="x" value="<%=x%>">
<input type="hidden" name="y" value="<%=y%>">--%>
<input type="submit" value="곱구하기"><!-- 히든으로 x값과 y값을 넣어서 보내주는 것  위의 것과 2개중에 하나 선택해서 사용하면 된다.-->
</form>
</body>
</html>