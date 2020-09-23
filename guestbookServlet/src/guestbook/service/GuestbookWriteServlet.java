package guestbook.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

@WebServlet("/GuestbookWriteServlet")
public class GuestbookWriteServlet extends HttpServlet{
	private static final long servialVersionUID =1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//웹에서 데이터 얻어오기
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String homepage = request.getParameter("homepage");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		GuestbookDTO guestbookDTO = new GuestbookDTO();
		
		
		guestbookDTO.setName(name);
		guestbookDTO.setEmail(email);
		guestbookDTO.setHomepage(homepage);
		guestbookDTO.setTitle(title);
		guestbookDTO.setContent(content);
		
		//DB에 보관하기 
		
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		int su = guestbookDAO.writeGuestBook(guestbookDTO);
		
		//왭에 응답하기
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");//html 형식 이러면 밑에것이 왭에서 나온다
		out.println("<head>");
		out.println("<title>글작성</title>");//제목
		out.println("</head>");
		out.println("<body>");
		out.println("<form name ='GuestbookWriteServlet' method='post' action='/guestbookListServlet'>");
		if(su==1) { 
			out.println("작성하신 글이 등록되었습니다.");
			out.println("<input type='button' value='글목록' onclick=location.href='/guestbookServlet/GuestbookListServlet?pg=1'>");
		}else {
			out.println("작성하신 글이 등록 되지 않았습니다.");
		}
		out.println("</form>");
		out.println("</body>");
		
		//out.println("<script type='text/javascript' src=http://localhost:8080/guestbookServlet/WebContent/js/guestbook.js>");
		out.println("</script>");
		out.println("</html>");
		
		
	}
}
