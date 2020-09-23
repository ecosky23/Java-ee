package member.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

//@WebServlet("/LoginServlet") 서블릿에 연결하기 위해서는 왼쪽의 어노테이션이나 web.xml에 등록하는 방법이 있다 둘중하나를 선택해야 한다.
public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//데이터 얻어오기
		String id = request.getParameter("id");//아이디와 패스워드 받아오기 
		String pwd = request.getParameter("pwd");
		
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		
		//DB
		MemberDAO memberDAO = MemberDAO.getInstance();
		int su = memberDAO.loginsuccess(memberDTO);
		//응답
		response.setContentType("text/html;charset=UTF-8"); //한글로 나오게 하기
		PrintWriter out = response.getWriter();
		
		if(su==1) {
			out.println("<html>");//html 형식 이러면 밑에것이 왭에서 나온다
			out.println("<head>");
			out.println("<title>로그인</title>");//제목
			out.println("<body>");
			
			out.println("로그인 성공");
			
			
			out.println("</body>");
			out.println("</head>");
			out.println("</html>");
		}else if(su==2) {
			out.println("<html>");//html 형식 이러면 밑에것이 왭에서 나온다
			out.println("<head>");
			out.println("<title>로그인</title>");//제목
			out.println("<body>");
			
			out.println("로그인 실패");
			
			
			out.println("</body>");
			out.println("</head>");
			out.println("</html>");
		}
		
		
	}

}
