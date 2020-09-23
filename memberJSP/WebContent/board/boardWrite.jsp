<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="member.bean.MemberDTO"%>
    
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
    
<%
request.setCharacterEncoding("UTF-8");
//데이터 받아오기
String subject = request.getParameter("subject");
String content = request.getParameter("content");


String id = (String)session.getAttribute("memId");//세션에서 아이디 받아오기
String name = (String)session.getAttribute("memName");
String email = (String)session.getAttribute("memEmail");

BoardDTO boardDTO = new BoardDTO();


Map<String,String> map = new HashMap<String,String>();
map.put("id",id);
map.put("name",name);
map.put("email",email);
map.put("subject",subject);
map.put("content",content);

//DB

String write;

BoardDAO boardDAO = BoardDAO.getInstance();
boardDAO.writeBoard(map);

%>   
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
<script type="text/javascript">
window.onload=function(){
	alert("작성하신 글을 저장하였습니다.");
	location.href="../main/index.jsp"
}
</script>
</html>