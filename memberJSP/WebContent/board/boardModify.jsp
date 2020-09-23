<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
    
<%
//boardModifyForm에서 데이터 받기

request.setCharacterEncoding("UTF-8");

int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));
String subject = request.getParameter("subject");
String content = request.getParameter("content");


//DB
BoardDAO boardDAO = BoardDAO.getInstance();
boardDAO.boardViewModify(seq, subject, content);//seq를 보내서 seq로 글의 모든 것을 찾아오기 위해 보낸다.

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
window.onload=function(){//이창이 떴을때 자동으로 실행
	alert("회원정보 수정완료");
	location.href="boardList.jsp?pg=<%=pg%>";
}
</script>
</html>