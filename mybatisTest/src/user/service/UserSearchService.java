package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService {

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("1. 이름 검색");
		System.out.println("2. 아이디 검색");
		
		int choice = scanner.nextInt();
		String searchType = null;
		String searchValue = null;
		if(choice == 1) {
			System.out.println("찾고자 하는 이름 입력: ");
			searchValue = scanner.next();
			searchType="name";
			
		
		}else if(choice == 2) {
			System.out.println("찾고자 하는 아이디 입력: ");
			searchValue = scanner.next();
			searchType="id";
			
			
		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchType", searchType);
		map.put("searchValue", searchValue);
		
		UserDAO userDAO =UserDAO.getInstance();
		List<UserDTO> list = userDAO.search(map);
		
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName()+"\t"
												+userDTO.getId()+"\t"
												+userDTO.getPwd());
		}
		
		
	}

}
