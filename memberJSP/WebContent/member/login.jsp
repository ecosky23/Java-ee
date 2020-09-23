<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>   
<%@page import="java.net.URLEncoder"%>
    
<% 
//데이터 받아오기
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	

//DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	MemberDTO memberDTO = memberDAO.loginMember(id, pwd);
	
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<%-- 
<%if(name==null){ %>
	아이디 또는 비밀번호가 맞지 않습니다.<br><br>
	<input type="button" value="회원가입" onclick="location.href='writeForm.jsp'"><!-- 주소는 무조건 싱글따옴표로 감싸줘야 한다. -->
	<input type="button" value="로그인" onclick="location.href='loginForm.jsp'">

<%}else{%>
	<%=name%>님 로그인
	<br><br>
	<input type="button" value="로그아웃" onclick="">
	<input type="button" value="회원정보수정" onclick="location.href='modifyForm.jsp?id=<%=id%>'">

<%}%>
--%>

<%if(memberDTO == null){//DB에 아이디와 비밀번호가 같은게 없다면 NULL값이 와서 로그인 실패
	//페이지 이동
	response.sendRedirect("loginFail.jsp");	


}else{
	
	//쿠키 생성
	/*Cookie cookie = new Cookie("memName",name);//쿠키만들기 (변수명, 쿠키에 닮을 변수)
	cookie.setMaxAge(30*60);//초단위 30분 뒤에 사라짐
	response.addCookie(cookie);//클라이언트에게 쿠키를 보내기 반드시  보내줘야 한다.
	
	Cookie cookie2 = new Cookie("memId",id);//쿠키만들기 (변수명, 쿠키에 닮을 변수)
	cookie2.setMaxAge(30*60);//초단위
	response.addCookie(cookie2);//클라이언트에게 쿠키를 보내기 반드시  보내줘야 한다.*/
	
	//세션 생성
	//HttpSession session = request.getSession();// 세션 생성 session은 내장객체 라서 따로 생성안해도 된다. 그러나 java에서는 생성해야 한다.

	session.setAttribute("memName", memberDTO.getName());//세션 부여하기
	session.setAttribute("memId",id);//세션 부여하기
	session.setAttribute("memEmail",memberDTO.getEmail1()+"@"+memberDTO.getEmail2());//세션부여하기
	
	session.setAttribute("memDTO", memberDTO);// 아에 session에 DTO를 담아버리기 위의 것처럼 따로따로 담거나 이것처럼 한번에 담거나 선택하기
	

	//페이지 이동
	response.sendRedirect("loginOk.jsp");
	//response.sendRedirect("loginOk.jsp?name="+ URLEncoder.encode(name,"UTF-8")+"&id="+id); 주소에 실어서 아이디 보내기
	
} %>

</body>
</html>