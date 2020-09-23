<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
    
<%
request.setCharacterEncoding("UTF-8");
%>    
<jsp:useBean id="memberDTO" class="member.bean.MemberDTO" scope="session"/><%-- memberDTO 객체 생성하기 --%>
<jsp:setProperty property="*" name="memberDTO"/><%-- property에 *를 넣어서 memberDTO로 넣어주기 *를 넣어서 한번에 표시하기  그럼 아래와 같은 효과가 발생한다--%>
  <%--
<jsp:setProperty property="name" name="memberDTO"/> 
 	<jsp:setProperty property="id" name="memberDTO"/>setName와 같은것 memberDTO에 넣기
	<jsp:setProperty property="pwd" name="memberDTO"/>
	<jsp:setProperty property="gender" name="memberDTO"/>
	<jsp:setProperty property="email1" name="memberDTO"/>
	<jsp:setProperty property="email2" name="memberDTO"/>
	<jsp:setProperty property="tel1" name="memberDTO"/>
	<jsp:setProperty property="tel2" name="memberDTO"/>
	<jsp:setProperty property="tel3" name="memberDTO"/>
	<jsp:setProperty property="zipcode" name="memberDTO"/>
	<jsp:setProperty property="addr1" name="memberDTO"/>
	<jsp:setProperty property="addr2" name="memberDTO"/>--%>
    
<%



/*String name = request.getParameter("name");
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String gender = request.getParameter("gender");
String email1 = request.getParameter("email1");
String email2 = request.getParameter("email2");
String tel1 = request.getParameter("tel1");
String tel2 = request.getParameter("tel2");
String tel3 = request.getParameter("tel3");
String zipcode = request.getParameter("zipcode");
String addr1 = request.getParameter("addr1");
String addr2 = request.getParameter("addr2"); 

MemberDTO memberDTO = new MemberDTO();
memberDTO.setName(name);
memberDTO.setId(id);
memberDTO.setPwd(pwd);
memberDTO.setGender(gender);
memberDTO.setEmail1(email1);
memberDTO.setEmail2(email2);
memberDTO.setTel1(tel1);
memberDTO.setTel2(tel2);
memberDTO.setTel3(tel3);
memberDTO.setZipcode(zipcode);
memberDTO.setAddr1(addr1);
memberDTO.setAddr2(addr2);*/
		
//DB
MemberDAO memberDAO = MemberDAO.getInstance();
memberDAO.writeMember(memberDTO);


%>    
    






 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:getProperty property="name" name="memberDTO"/> 
<jsp:getProperty property="id" name="memberDTO"/>
<jsp:getProperty property="pwd" name="memberDTO"/>
<jsp:getProperty property="gender" name="memberDTO"/>
<jsp:getProperty property="email1" name="memberDTO"/>
<jsp:getProperty property="email2" name="memberDTO"/>
<jsp:getProperty property="tel1" name="memberDTO"/>
<jsp:getProperty property="tel2" name="memberDTO"/>
<jsp:getProperty property="tel3" name="memberDTO"/>
<jsp:getProperty property="zipcode" name="memberDTO"/>
<jsp:getProperty property="addr1" name="memberDTO"/>
<jsp:getProperty property="addr2" name="memberDTO"/>
<%=memberDAO.writeMember(memberDTO)%>
</body>




<script type="text/javascript">
window.onload=function(){
	alert("회원가입  완료");
	location.href="loginForm.jsp"
}
</script>
</html>