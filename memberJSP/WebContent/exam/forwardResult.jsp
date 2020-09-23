<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<%

String apple = (String)request.getAttribute("apple");//sendProc에서 보낸 apple의 값을 꺼내오기

%>   
결과 = <%=apple%><%-- 결과 값은 사과가 나온다 forward를 사용하여 안의 내용도 같이 보내줘서 null값이 나오지 않는다.--%>   