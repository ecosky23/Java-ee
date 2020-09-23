<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="fileUpload.jsp"><!-- 어떤형식의 파일도 업로드 하겠다 -->

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
	 <td colspan="2">
		<input type="file" name="upload1" size="50">	 
	 </td>	
	</tr>
	
	<tr>
	 <td colspan="2">
		<input type="file" name="upload2" size="50">	 
	 </td>	
	</tr>
	
	<tr>
	 <td colspan="2">
		<input type="submit" value="파일업로드">	 
	 </td>	
	</tr>
	
</table>
</form>
</body>
</html>