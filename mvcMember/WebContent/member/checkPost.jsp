<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호</title>
<link rel="stylesheet" href="../css/member.css"><!-- 스타일 시트(css)를 링크걸어서 사용하기 -->
</head>
<body>
<form method="post" action="checkPost.do"><!-- 나 자신에게 데이터를 뿌리기 -->
	<table border="1" width="100%" cellspacing="0">
		<tr>
			<th>시도</th>
			<td align="center"><select name="sido" style="width: 100px;">
					<option value="시도선택">시도선택</option>
					<option value="서울">서울</option>
					<option value="인천">인천</option>
					<option value="대전">대전</option>
					<option value="대구">대구</option>
					<option value="울산">울산</option>
					<option value="세종">세종</option>
					<option value="광주">광주</option>
					<option value="경기">경기</option>
					<option value="강원">강원</option>
					<option value="전남">전남</option>
					<option value="전북">전북</option>
					<option value="경남">경남</option>
					<option value="경북">경북</option>
					<option value="충남">충남</option>
					<option value="충북">충북</option>
					<option value="부산">부산</option>
					<option value="제주">제주</option>
			</select></td>
			<th>시,군,구</th>
			<td><input type="text" name="sigungu" size="30"></td>
		</tr>
		<tr>
			<th>도로명</th>
			<td colspan="3"><input type="text" name="roadname" size="35">
				<input type="submit" value="검색"></td>
		</tr>
		<tr>
			<th>우편번호</th>
			<th colspan="3">주소</th>
		</tr>
		<c:if test="${requestScope.list !=null }">
			<c:forEach var="zipcodeDTO" items="${list}">
			 <c:set var="address" >
			 ${zipcodeDTO.sido 
			 } ${zipcodeDTO.sigungu
			 } ${zipcodeDTO.yubmyundong 
			 } ${zipcodeDTO.ri 
			 } ${zipcodeDTO.roadname 
			 } ${zipcodeDTO.buildingname 
			 }
			 </c:set>
			 <tr>
				<td align="Center">${zipcodeDTO.zipcode }</td>
				<td colspan="3">
				<a id="addressA" href="#" onclick="checkPostClose('${zipcodeDTO.zipcode }','${address }')">${address}</a><!-- #은 현재 주소는 업다는 것이다. -->
				</td>
				</tr>	
				
	</c:forEach>
	</c:if>		
	</table>
	
	</form>
</body>
<script type="text/javascript" src="../js/member.js">
</script>
</html>