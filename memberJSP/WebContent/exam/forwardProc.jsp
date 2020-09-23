<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
    
    request.setAttribute("apple", "사과");//sendProc에 변수명 apple이고 내용이 사과인 것을 담갰다.

    //페이지 이동
    RequestDispatcher dispatcher = request.getRequestDispatcher("forwardResult.jsp");//주소를 쓸때는 상대번지 쓰기
    dispatcher.forward(request, response);//자신의 제어권 넘기기 아래의 forward와 같은 식이다. 이것을 더 많이 씀 자신의 내부의 내용까지 같이 넘기는 것
    
    
%>

<%-- <jsp:forward page="forwardResult.jsp"/> 내용물을 담아서 보내기--%>

