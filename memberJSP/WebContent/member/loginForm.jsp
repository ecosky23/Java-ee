<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form name="loginForm" method="post" action="/memberJSP/member/login.jsp">
 <h3>로그인</h3>
 
 <table border="1" cellspacing="0" cellpadding="3">
 	<tr>
 	 <td align="center">아이디</td>
 	 <td><input type="text" name="id" placeholder="id 입력">
 	 </td>
 	</tr>
 	<tr>
 	 <td align ="center">비밀번호</td>
 	 <td><input type="password" name="pwd">
 	 </td>
 	 
 	 <tr>
 	  <td colspan="2" align="center">
 	  <input type="button" value="로그인" onclick="checkLoginForm()">
 	  <input type="button" value="회원가입" onclick="location.href='writeForm.jsp'">
 
 </table>
 </form>
 <script type="text/javascript" src="../js/member.js"></script>
</body>
</html>