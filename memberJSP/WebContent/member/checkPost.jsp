<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>

<%@page import="member.bean.ZipcodeDTO"%>

<%@page import="member.dao.MemberDAO"%>

<%

//왭에서 데이터 받아오기 
request.setCharacterEncoding("UTF-8");//한글나오게 하기위해서
String sido = request.getParameter("sido");//왭페이지에서 "시도"를 가져오라고  요청하기
String sigungu = request.getParameter("sigungu");
String roadname = request.getParameter("roadname");



//DB
List<ZipcodeDTO> list=null;
if(sido!=null && roadname!=null){
	MemberDAO memberDAO = MemberDAO.getInstance();	
	list = memberDAO.getZipcodeList(sido,sigungu,roadname);
	
	
}


//응답

%>	
	
	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호</title>
<link rel="stylesheet" href="../css/member.css"><!-- 스타일 시트(css)를 링크걸어서 사용하기 -->
</head>
<body>
<form method="post" action="checkPost.jsp"><!-- 나 자신에게 데이터를 뿌리기 -->
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
		<%if(list != null){ %>
			<%for(ZipcodeDTO zipcodeDTO : list){
				
				
String address = zipcodeDTO.getSido()+" "
				+ zipcodeDTO.getSigungu()+" "
				+ zipcodeDTO.getYubmyundong()+" "
				+ zipcodeDTO.getRi()+" "
				+ zipcodeDTO.getRoadname()+" "
				+ zipcodeDTO.getBuildingname();
				%>
				<tr>
				<td align="Center"><%=zipcodeDTO.getZipcode()%></td>
				<td colspan="3">
				<a id="addressA" href="#" onclick="checkPostClose('<%=zipcodeDTO.getZipcode()%>','<%=address%>')"><%=address%></a><!-- #은 현재 주소는 업다는 것이다. -->
				</td>
				</tr>
				
			<%}//for %>
		<%}//if %>
	</table>
	
	</form>
</body>
<script type="text/javascript" src="../js/member.js">
</script>
</html>