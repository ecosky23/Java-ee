package user.main;

import java.util.Scanner;

import user.service.UserDeleteService;
import user.service.UserInsertService;
import user.service.UserSearchService;
import user.service.UserSelectService;
import user.service.UserService;
import user.service.UserUpdateService;

public class UserMain {
	int choice;
	
	public void menu() {
		Scanner scanner = new Scanner(System.in);
		
		UserService userService = null;
	 
		while(true) {
			System.out.println("----------------");
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.검색");
			System.out.println("6.끝");
			System.out.println("번호를 입력하세요");
			System.out.println("----------------");
			
			choice = scanner.nextInt();
				
			if(choice==6) break;
			if(choice==1) userService = new UserInsertService();//UserService를 상속 받은 것들
			else if(choice==2) userService = new UserSelectService();
			else if(choice==3) userService = new UserUpdateService();
			else if(choice==4) userService = new UserDeleteService();
			else if(choice==5) userService = new UserSearchService();
			
			userService.execute();
		}
	}
	

	public static void main(String[] args) {
		UserMain userMain = new UserMain();
		userMain.menu();
		System.out.println("프로그램을 종료합니다.");
	}
}
