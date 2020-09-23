<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

String name = null;
String id = null;

//쿠키 
/*
Cookie[] ar = request.getCookies(); // 특정 쿠키를 얻지 못하고 모든 쿠키를 얻어와야한다. 그래서 배열로 생성된다.
if(ar != null){
	for(int i = 0; i<ar.length; i++){
		//String cookieName = ar[i].getName();//쿠키명
		//String cookieValue = ar[i].getValue();//값
		//System.out.println("쿠키명="+cookieName+"\t 값= "+cookieValue);
		
		if(ar[i].getName().equals("memName")) name = ar[i].getValue();
		else if(ar[i].getName().equals("memId")) id = ar[i].getValue();
	}//for
}*/

//세션

name = (String)session.getAttribute("memName");//세션으로 name 얻어오게
id = (String)session.getAttribute("memId");

//String name = request.getParameter("name"); login.jsp에서 name를 받아오기
//String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img alt="" src="../image/mon.jpg" width="100" height="100" onclick="location.href='../main/index.jsp'" style="cursor:pointer;"><br>

<br><%=name %>님 로그인
<br><br>
<input type="button" value="로그아웃" onclick="location.href='logout.jsp'">
<input type="button" value="회원정보수정" onclick="location.href='modifyForm.jsp'">

</body>
</html>