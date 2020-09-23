package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertService implements UserService {

	@Override
	public void execute() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요");
		String name = scanner.next();
		System.out.println("아이디를 입력하세요");
		String id = scanner.next();
		System.out.println("비밀번호를 입력하세요");
		String pwd = scanner.next();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		UserDAO userDAO = UserDAO.getInstance();
		int su = userDAO.write(userDTO);
		System.out.println(su+"개 저장 완료!!");
	}

}
