package guestbook.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

@WebServlet("/GuestbookListServlet")
public class GuestbookListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//DB
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		
		//페이징처리 - 1페이지당 2개씩
		int endNum = pg*2;
		int startNum = endNum-1;
		List<GuestbookDTO> list = guestbookDAO.getGuestbookList(startNum, endNum);
		
		//총글의 수
		int totalA = guestbookDAO.getTotalA();
		
		//총페이지 수
		int totalP = (totalA+1)/2;
		
		
		
		//응답
		response.setContentType("text/html;charset=UTF-8"); //한글로 나오게 하기
		PrintWriter out = response.getWriter();
		
		out.println("<html>");//html 형식 이러면 밑에것이 왭에서 나온다
		out.println("<head>");
		
		out.println("<title>글 목록</title>");//제목
		out.println("<style>");
		out.println("#currentPaging{color: red; text=decoration: underline;}");
		out.println("#paging{color: black; text-decoration: none;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		
		if(list != null) {
			
			for(int i=1; i<=totalP; i++) {
				if(i == pg) {
					out.println("[<a id=currentPaging href='/guestbookServlet/GuestbookListServlet?pg="+i+"'>"+i+"</a>]");
				}else {
					out.println("[<a id=paging href='/guestbookServlet/GuestbookListServlet?pg="+i+"'>"+i+"</a>]");
				}
				
			}
			out.println("<br>");
			out.println("<br>");
			
			
			
			
			for(GuestbookDTO guestbookDTO : list) {
				out.println("<table border=1 width=500>");
				
				out.println("<tr>");
				out.println("<td align=center width=100>작성자</td>");
				out.println("<td align=center width=150>"+guestbookDTO.getName()+"</td>");
				out.println("<td align=center width=100>작성일</td>");
				out.println("<td align=center width=150>"+guestbookDTO.getLogtime()+"</td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<td align=center width=100>이메일</td>");
				out.println("<td align=center width=150 colspan=3>"+guestbookDTO.getEmail()+"</td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<td align=center width=100>홈페이지</td>");
				out.println("<td align=center width=150 colspan=3>"+guestbookDTO.getHomepage()+"</td>");
				out.println("</tr>");
				
				out.println("<tr>");
				out.println("<td align=center width=100>제목</td>");
				out.println("<td align=center width=150 colspan=3>"+guestbookDTO.getTitle()+"</td>");
				out.println("</tr>");
				
				out.println("<tr>");
				
				out.println("<td width=150 colspan=4 style='white-space: pre-wrap; word-break: break-all;'>"+guestbookDTO.getContent()+"</td>");
				
				// pre style='white-space: pre-wrap; word-break: break-all;' 게시판의 글이 다음칸으로 넘어가게 하는 것 꼭 테이블의 길이를 지정하고 해야한다.
				
				out.println("</table>");
				out.println("<hr width=500 color=red align=left>");
				
			}//for
		}
		
		out.println();
		out.println();
		out.println();
		
		
		out.println("</body>");
		
		out.println("</html>");
	}
	
}
