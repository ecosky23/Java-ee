<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
//쿠키
/*
Cookie[] ar = request.getCookies(); // 특정 쿠키를 얻지 못하고 모든 쿠키를 얻어와야한다. 그래서 배열로 생성된다.
if(ar != null){
	for(int i = 0; i<ar.length; i++){
		
		if(ar[i].getName().equals("memName")){
			ar[i].setMaxAge(0);//쿠키삭제
			response.addCookie(ar[i]);//클라이언트에게 보내기 무조건 클라이언트에 보내야 한다.
		}else if(ar[i].getName().equals("memId")){
			ar[i].setMaxAge(0);//쿠키삭제
			response.addCookie(ar[i]);//클라이언트에게 보내기  무조건 클라이언트에 보내야 한다.
		}
	}//for
}//if
*/

//세션
session.removeAttribute("memName");//세션 삭제
session.removeAttribute("memId");//세션 삭제
			
session.invalidate();//무효화 로그아웃 하고 세션값 없애기 모든 세션값 삭제하기

%>    
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
<script type="text/javascript">
window.onload=function(){
	alert("로그아웃");
	location.href = "../main/index.jsp";
	
}
</script>
</html>