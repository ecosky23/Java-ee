package member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import member.dao.MemberDAO;

public class CheckIdService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//데이터 받아오기
		String id = request.getParameter("id");
		
		//DB연결하기
		MemberDAO memberDAO = MemberDAO.getInstance();
		boolean exist = memberDAO.isExistId(id);
		//응답
		request.setAttribute("id", id);//request에 아이디를 실어 보내면 request자체가 servlet거이기 때문에
										// servlet에 연결된 모든 것들에 id가 보내진다.
		if(exist==true) { //아이디 중복 사용불가능
		
			return "/member/checkIdFail.jsp";
		}else {
			return "/member/checkIdOk.jsp";
		}
	}

}
