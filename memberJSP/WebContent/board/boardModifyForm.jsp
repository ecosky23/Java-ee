<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
    
    
<%
//seq와 pg를 받기
int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));

//DB
BoardDAO boardDAO = BoardDAO.getInstance();
BoardDTO boardDTO = boardDAO.boardView(seq);//seq를 보내서 seq로 글의 모든 것을 찾아오기 위해 보낸다.


%>    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="boardModifyForm" method="post" action="boardModify.jsp">

<input type="hidden" name="seq" value="<%=seq%>"><%-- 히든을 통해 데이터를 넘기는 방법 히든으로 boardModify로 데이터가 넘어간다. --%>
<input type="hidden" name="pg" value="<%=pg%>">
<h3>글수정</h3>
<table border="1" cellspacing="0" cellpadding="3">
	<tr>
	 <td align="center" width="70">제목</td>
	 <td><input type="text" name="subject" id="subject" size="55" value="<%=boardDTO.getSubject()%>"></td>
	</tr>
	<tr>
	 <td align="center">내용</td>
	 <td><textarea rows="15" cols="60" name="content" id="content" style="resize:none;"><%=boardDTO.getContent()%></textarea></td>
	</tr>
	<tr>
	 <td colspan="2" align="center">
	 <input type="submit" value="글수정">
 	  <input type="reset" value="다시작성">
	 </td>
	 </tr>

</table>
</form>
</body>
</html>