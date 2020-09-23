<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
    double[] maxTeperature = {10.2, 11.8, 12.9, 9.0 };

	for(int i=0; i<maxTeperature.length; i++){
		out.print(maxTeperature[i]);
		
		if(i < maxTeperature.length-1){
			out.print(",");
		}
	}
    
    
%>