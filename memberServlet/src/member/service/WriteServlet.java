package member.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.Desktop;

import member.bean.MemberDTO;
import member.dao.MemberDAO;




//@WebServlet("/WriteServlet") //이것과 web.xml 둘중하나만 사용해야 한다. 
public class WriteServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;
	
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");//post방식
		//왭에서 데이터 얻어오기

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String gender = request.getParameter("gender");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("defaultEmails");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String zipcode = request.getParameter("zipcode");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setName(name); 
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		memberDTO.setGender(gender);
		memberDTO.setEmail1(email1);
		memberDTO.setemail2(email2);
		memberDTO.setTel1(tel1);
		memberDTO.setTel2(tel2);
		memberDTO.setTel3(tel3);
		memberDTO.setZipcode(zipcode);
		memberDTO.setAddr1(addr1);
		memberDTO.setAddr2(addr2);
		

		//DB에 보관하기
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		int su = memberDAO.writeMember(memberDTO);
		
		//왭에 응답하기
		response.setContentType("text/html;charset=UTF-8"); //한글로 나오게 하기
		PrintWriter out = response.getWriter();
		
		out.println("<html>");//html 형식 이러면 밑에것이 왭에서 나온다
		out.println("<head>");
		out.println("<title>회원가입</title>");//제목
		out.println("<body>");
		
		if(su==1) { out.println("회원가입 성공");
		//out.println("<input type='button' value='로그인' onclick="'loginForm.html'  ">");
		try {
			Desktop.getDesktop().browse(new URI("http://localhost:8080/memberServlet/member/loginForm.html"));
		} catch (IOException | URISyntaxException e) {
			
			e.printStackTrace();
		}
	
		}else out.println("회원가입 실패");
		
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
	}

}
