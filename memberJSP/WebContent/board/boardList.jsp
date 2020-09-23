<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.bean.BoardPaging"%>
<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.List"%>
    
    
<%
//pg 데이터 받아오기
int pg = Integer.parseInt(request.getParameter("pg"));

//DB
BoardDAO boardDAO = BoardDAO.getInstance();

//페이징 처리
int endNum = pg*5;
int startNum = endNum-4;
List<BoardDTO> list = boardDAO.getBoardList(startNum, endNum);

BoardPaging boardPaging = new BoardPaging();
int totalA = boardDAO.getTotalA();
boardPaging.setCurrentPage(pg);
boardPaging.setPageBlock(3);
boardPaging.setPageSize(5);
boardPaging.setTotalA(totalA);
boardPaging.makePagingHTML();


//세션값 얻어오기
String memId = (String)session.getAttribute("memId");
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css"> <%--글에다가 스타일 부여하기 --%>

.subjectA:link{color:black; text-decoration: none;}
.subjectA:visited{color:black; text-decoration: none;}
.subjectA:hover{color:green; text-decoration: underline;} /*마우스가 올라갔을때*/
.subjectA:active{color:black; text-decoration: none;} /*누르고 있을때*/

#paging{
color: black; 
text-decoration: none;
}

#currentPaging{
color: red; 
text-decoration: underline;
}

</style>
</head>
<h3>게시판</h3>
<body>
<form name="boardList" method="post" action="boardView.jsp">
<input type="text" name="search">
<input type="button" value="검색" onclick="">
<table border="1" cellspacing="0" cellpadding="3" frame="hsides" rules="rows">
	<tr><%-- frame="hsides" rules="rows" 테이블 세로선 없애기--%>
	 <td align="center" width="100">글번호</td>
	 <td align="center" width="200">제목</td>
	 <td align="center" width="100">작성자</td>
	 <td align="center" width="100">작성일</td>
	 <td align="center" width="100">조회수</td>
	</tr>
<%if(list != null){%> 

<%for(BoardDTO boardDTO : list){ %>
	<tr>
	 <td><%=boardDTO.getSeq()%></td><%--class처리해주고 이름을 subjectA넣어주고 위에 style를 넣어줘서 css 처리를 해준다. --%>
	 <td><a class="subjectA" href="#" onclick="checkLogin('<%=memId%>',<%=boardDTO.getSeq()%>,<%=pg%>)"><%=boardDTO.getSubject()%></a></td><%--#은 주소가 필요없고 onclick를 누르고 더 자세히 보고 싶다는 것 #에 주소를 추가하면 거기로 이동됨 --%>
	 <td><%=boardDTO.getId()%></td><%--자바스크립트에서는 문자인 경우에 따옴표를 해줘야 한다 숫자는 필요없다. 그래서 memId에 따옴표해준다. --%>
	 <td><%=boardDTO.getLogtime()%></td>
	 <td><%=boardDTO.getHit()%></td>
	</tr>
<%} %>

<%} %>
</table>
<div style="border:solid 1px red; width: 700px; text-align: center;"><%=boardPaging.getPagingHTML()%></div>	
<br><input type="button" value="글쓰기" onclick="location.href='boardWriteForm.jsp'">
</form>
<script type="text/javascript">
function checkLogin(memId, seq, pg){/*위에서 넘겨준것을 받아준것 자바스크립에는 자료형이 없어서 바로써준다.*/
	if(memId=='null'){/*checkLogin에서 memId를 따옴표치고 들어왔기 때문에 아래의 null에서 ''를 춰줘야 한다.'*/
		alert("로그인 하세요");	
	}else{
		location.href="boardView.jsp?seq="+seq+"&pg="+pg;/*seq의 값과 pg의 값을 boardVIew로 넘겨주기*/
	}
}
</script>
</body>
</html>