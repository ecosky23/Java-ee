package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//1.드라이버 로딩
//2.접속
//3.update
//수정 할 이름 입력 : 홍
//홍이 들어가는 이름은 나이도 1증가, 키도 1증가
public class UpdateTest {
	private Connection conn;
	private PreparedStatement pstmt;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	public UpdateTest() {
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("접속 성공");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void update() {
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 이름 입력");
		String name = scan.next();
		
		this.getConnection();
		
		String sql = " update dbtest set age = age +1, height = height+1 where name like ?";
		
		try {
			pstmt = conn.prepareStatement(sql);//생성
			
			pstmt.setString(1, "%"+name+"%");//데이터 주입
			int su = pstmt.executeUpdate();//실행
			System.out.println(su+"개의 행을 수정하였습니다.");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
				try {
					if(pstmt != null) pstmt.close();	//닫아주기 거꾸로
					if(conn != null) conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
		}
	}
	

	public static void main(String[] args) {
		UpdateTest up = new UpdateTest();
			up.update();
	}
	
	
}
