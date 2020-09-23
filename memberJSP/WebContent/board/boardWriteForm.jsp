<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<form name="boardWriteForm" method="post" action="/memberJSP/board/boardWrite.jsp">
<h3>글쓰기</h3>
<table border="1" cellspacing="0" cellpadding="3">
	<tr>
	 <td align="center" width="70">제목</td>
	 <td><input type="text" name="subject" id="subject" size="55"></td>
	</tr>
	<tr>
	 <td align="center">내용</td>
	 <td><textarea rows="15" cols="60" name="content" style="resize:none;"></textarea></td>
	</tr>
	<tr>
	 <td colspan="2" align="center">
	 <input type="button" value="글쓰기" onclick="checkBoardWriteForm()">
 	  <input type="reset" value="다시작성">
	 </td>
	 </tr>

</table>
</form>
<script type="text/javascript">
function checkBoardWriteForm(){
	if(document.getElementById("subject").value == ""){
		alert("제목을 입력하세요");
		document.boardWriteForm.subject.focus();
	}else if(document.boardWriteForm.content.value == ""){
		alert("내용을 입력하세요");
		document.boardWriteForm.subject.focus();
	}else{
		document.boardWriteForm.submit();
	}
}
</script>
</body>
</html>