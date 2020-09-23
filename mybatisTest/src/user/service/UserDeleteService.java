package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("삭제할 아이디 입력: ");
		String id = scanner.next();
		
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = userDAO.getSearch(id);
		
		
		if(userDTO == null) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
			return;
		}

		userDAO.delete(id);

		System.out.println("삭제완료");

	}

}
