<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
    
<%

String apple = (String)request.getAttribute("apple");//sendProc에서 보낸 apple의 값을 꺼내오기

%>   
결과 = <%=apple%><%-- 결과 값은 null값이 나온다.--%>