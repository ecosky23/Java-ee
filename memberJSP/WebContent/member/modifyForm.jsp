<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="member.bean.ZipcodeDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
	
	
<% 

//웹에서 데이터 받음

//String id = request.getParameter("id");
String id = (String)session.getAttribute("memId");//세션에 저장되어 있는 아이디 불러오기  오브젝트 타입이기 때문에 스트링 타입으로 형변환해야 한다.

//DB에서 정보 받아오기

MemberDAO memberDAO = MemberDAO.getInstance();
MemberDTO memberDTO = memberDAO.getMember(id);

%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
</head>
<body>
	<form name="modifyForm" method="post" action="modify.jsp">
	<h3>회원정보수정</h3>
	<table border="1" cellspacing="0">
		<tr>
			<td align="center">이름</td>
			<td><input type="text" name="name" id="name" value="<%=memberDTO.getName()%>" placeholder="이름 입력"></td>
		</tr>

		<tr>
			<td align="center">아이디</td>
			<td><input type="text" name="id" placeholder="아이디 입력" value="<%=id%>" size="30" readonly>

				<input type="hidden" name="idDuplicationCheck" value=""></td>

		</tr>

		<tr>
			<td align="center">비밀번호</td>
			<td><input type="password" name="pwd" size="30"></td>
		</tr>

		<tr>
			<td align="center">재확인</td>
			<td><input type="password" name="repwd" size="30"></td>
		</tr>

		<tr>
			<td align="center">성별</td>
			<td><input type="radio" name="gender" value="0">남
				<input type="radio" name="gender" value="1">여</td>
		</tr>

		<tr>
			<td align="center">이메일</td>
			<td><input type="text" name="email1" value="<%=memberDTO.getEmail1()%>" size="15"> @ <input
				type="text" list="email2" name="email2" id="email2" placeholder="직접 입력"> <datalist
					id="email2">
					<option value="naver.com"></option>
					<option value="gmail.com"></option>
					<option value="hanmail.net"></option>
				</datalist></td>
		</tr>

		<tr>
			<td align="center">핸드폰</td>
			<td><select name="tel1" style="width: 50px;"> -
					<option value="010">010</option>
					<option value="017">017</option>
					<option value="019">019</option>
					<input type="text" name="tel2" size="10" value="<%=memberDTO.getTel2()%>"> -
					<input type="text" name="tel3" size="10" value="<%=memberDTO.getTel3()%>"></td>
		</tr>

		<tr>
			<td align="center">주소</td>
			<td><input type="text" name="zipcode" value="<%=memberDTO.getZipcode()%>" id="zipcode" readonly>
				<!-- disabled 아에 글씨 못쓰게하기 readonly 글씨 못들어가게 막기 읽게만하기--> 
				<input type="button" value="우편번호검색" onclick="checkPost()"><br>
				<input type="text" name="addr1" id="addr1" value="<%=memberDTO.getAddr1()%>" placeholder="주소" size="50" readonly><br> 
				<input type="text" name="addr2" id="addr2" placeholder="상세 주소" size="50" value="<%=memberDTO.getAddr2()%>"></td>
		</tr>

		<tr>
			<td colspan="2" align="center">
			<input type="button" value="회원정보수정" onclick="checkModifyForm()">
			<input type="reset" value="다시작성"></td>

		</tr>
</table>
</form>
</body>

	<script type="text/javascript" src="../js/member.js"></script>
	<script type="text/javascript">
window.onload=function(){//윈도우가 열렸을때 항상 이함수를 실행해라
		document.modifyForm.gender['<%=memberDTO.getGender()%>'].checked = true; 
		document.modifyForm.email2.value = '<%=memberDTO.getEmail2()%>';
		//document.getElementById('email2').value = '<%=memberDTO.getEmail2()%>';
		document.modifyForm.tel1.value = '<%=memberDTO.getTel1()%>';}
</script>
	
</html>