<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form name="writeForm" method="post" action="write.do">
		<h3>회원가입</h3>

		<table border="1" cellspacing="0" cellpadding="3">
			<tr>
				<td align="center">이름</td>
				<td><input type="text" name="name" id="name" placeholder="이름 입력"></td>
			</tr>

			<tr>
				<td align="center">아이디</td>
				<td><input type="text" name="id" placeholder="아이디 입력" size="30">
					<input type="button" value="중복체크" onclick="checkId()"> 
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
				<td><input type="radio" name="gender" value="0" checked>남
					<input type="radio" name="gender" value="1">여</td>
			</tr>

			<tr>
				<td align="center">이메일</td>
				<td><input type="text" name="email1" size="15"> @ <input
					type="text" list="email2" placeholder="직접 입력"> <datalist
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
						<input type="text" name="tel2" size="10"> -
						<input type="text" name="tel3" size="10"></td>
			</tr>

			<tr>
				<td align="center">주소</td>
				<td><input type="text" name="zipcode" id="zipcode" readonly>
					<!-- disabled 아에 글씨 못쓰게하기 readonly 글씨 못들어가게 막기 읽게만하기--> <input
					type="button" value="우편번호검색" onclick="checkPost()"><br>
					<input type="text" name="addr1" id="addr1" placeholder="주소" size="50" readonly><br> 
					<input type="text" name="addr2" id="addr2" placeholder="상세 주소" size="50"></td>
			</tr>

			<tr>
				<td colspan="2" align="center"><input type="button" value="회원가입" onclick="checkWriteForm()">&emsp;<!-- 버튼을 누르면 밑의 스크립트로 가서 자바스크립트 함수를 찾는다 -->
					<input type="reset" value="다시작성"></td>

			</tr>

		</table>
	</form>


<script type="text/javascript" src="../js/member.js"></script>
<!-- 뒤로한칸 가서 js퐅더로 들어가서 member.js 파일로 가기-->
<!-- member.js 에 javascript의 함수가 있다고 알려주기  http://localhost:8080/memberServlet/js/member.js 위의것도 되고 이것도 된다.-->

</body>
</html>