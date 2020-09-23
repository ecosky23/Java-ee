package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

public class LogoutService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//세션
		HttpSession session = request.getSession();
		
					
		session.invalidate();//무효화 로그아웃 하고 세션값 없애기 모든 세션값 삭제하기
		
		
		return "/member/logout.jsp";//logout.jsp파일로 forward하기
	}

}
