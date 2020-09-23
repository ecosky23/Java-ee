<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>합구하기</title>
</head>
<body>
<form name="input" method="get" action="sum.jsp">
<table border="1" cellspacing="0">
	<tr>
	 <td align="center">X</td>
	 <td><input type="text" name="x" ></td>
	</tr>
	<tr>
	 <td align="center">Y</td>
	 <td><input type="text" name="y" ></td>
	</tr>
	<tr>
	 <td colspan="2" align="center">
	 <input type="submit" value="합구하기"">
	 <input type="reset" value="취소">
	</tr>
</table>
</form>
</body>
</html>