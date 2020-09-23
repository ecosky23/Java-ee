

<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    <%
    
    //데이터 받아오기
   
    String id = request.getParameter("id");
    
    
    
    //DB
    MemberDAO memberDAO = MemberDAO.getInstance();
    boolean exist = memberDAO.isExistId(id);
    String check;
    if(exist == true){
    	check = "사용중인 아이디 입니다.";
 
    }else{
    	check = "사용가능한 아이디 입니다.";
    }
    
    
    //아이디가 있으면 exist에 true 없으면 exist에 false
    
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인</title>
</head>
<body>
<form method="post" action="checkId.jsp">
아이디 :<%=id%><br> <%=check%>
<br>

<%if(exist == true){ %>

<input type="text" name="id" size="10">
<input type="submit" value="검색" >
<%   }else{ %>
<br>
<input type="button" value="사용하기" onclick="checkIdClose('<%=id%>')" <%--id도 같이 넘겨줘야 한다 --%>>
</form>
</body>
<% }%>
<script type="text/javascript" src="../js/member.js">

</script>
</html>