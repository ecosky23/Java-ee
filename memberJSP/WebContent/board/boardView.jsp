<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>

<%     
    request.setCharacterEncoding("UTF-8");

String memId = (String)session.getAttribute("memId");

//boardList에서 데이터 받기
int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));

	
//DB에서 데이터 끌고 오기
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
 <table border="1" cellpadding="3" cellspacing="0" frame="hsides" rules="rows">
  <tr>
   <td colspan="3">제목: <%=boardDTO.getSubject()%></td>
  </tr>
  
  <tr>
   <td align="center" width="150">글번호: <%=boardDTO.getSeq()%> </td>
   <td align="center" width="150">작성자: <%=boardDTO.getId()%> </td>
   <td align="center" width="150">조회수: <%=boardDTO.getHit()%> </td>
  </tr>
  
  <tr>
   <td colspan="3" width="300" height="300" valign="top"><pre><%=boardDTO.getContent()%></pre></td>
  </tr><%-- valign은 정렬방향 나오게 하는 것 --%>
 
 </table>
 <input type="button" value="목록" onclick="location.href='boardList.jsp?pg=<%=pg%>'"><%--pg값을 넘겨주면서 1페에지가 아니라 원래있던 페이지로 돌아간다. --%>
 <%if(memId.equals(boardDTO.getId())){ %>
 <input type="button" value="글수정" onclick="location.href='boardModifyForm.jsp?seq=<%=boardDTO.getSeq()%>&pg=<%=pg%>'">
 <input type="button" value="글삭제" onclick="">
 <%} %>
</body>
</html>