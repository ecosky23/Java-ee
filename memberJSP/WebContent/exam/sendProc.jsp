<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
    
    
<%

request.setAttribute("apple", "사과");//sendProc에 변수명 apple이고 내용이 사과인 것을 담갰다.

//페이지 이동
response.sendRedirect("sendResult.jsp");//sendResult에 보내기 내용은 비어있다.

%>    

