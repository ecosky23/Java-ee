package member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.ZipcodeDTO;
import member.dao.MemberDAO;

public class CheckPostService implements CommandProcess {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//왭에서 데이터 받아오기 
		request.setCharacterEncoding("UTF-8");//한글나오게 하기위해서
		String sido = request.getParameter("sido");//왭페이지에서 "시도"를 가져오라고  요청하기
		String sigungu = request.getParameter("sigungu");
		String roadname = request.getParameter("roadname");
		
		//DB
		List<ZipcodeDTO> list=null;
		if(sido!=null && roadname!=null){
			MemberDAO memberDAO = MemberDAO.getInstance();	
			list = memberDAO.getZipcodeList(sido,sigungu,roadname);
			
			
		}
		//응답
		request.setAttribute("list", list);
	/*	if(list != null){ 
				for(ZipcodeDTO zipcodeDTO : list){	
					HttpSession session = request.getSession();
					String address = zipcodeDTO.getSido()+" "+ zipcodeDTO.getSigungu()+" "+ zipcodeDTO.getYubmyundong()+" "+ zipcodeDTO.getRi()+" "+ zipcodeDTO.getRoadname()+" "+ zipcodeDTO.getBuildingname();
					
					session.setAttribute("address", address);
					session.setAttribute("zipcodeDTO", zipcodeDTO);
					
					return "/member/checkPost.jsp";
				}
				}*/
		
		return "/member/checkPost.jsp";
		
		
		
		
	}

}
