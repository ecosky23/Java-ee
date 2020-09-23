package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	Scanner scan = new Scanner(System.in);
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	private String name;
	private String value;
	private int code;
	
	public Student() {
			
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
	
	public void menu() {
			
			while(true) {
			System.out.println("**********");
			System.out.println("    관리	 ");
			System.out.println("**********");
			System.out.println("1.입력");
			System.out.println("2.검색");
			System.out.println("3.삭제");
			System.out.println("4.종료");
			System.out.println("**********");
			System.out.print("번호선택:");
			int num = scan.nextInt();
			if(num == 4) break;
			
			if(num == 1) insertArticle();
			else if(num == 2) searchArticle();
			else if(num == 3) deleteArticle();
			 
			}
	}
	
	public void insertArticle() {
		
		while(true) { 
		System.out.println("**********");
		System.out.println("1.학생");
		System.out.println("2.교수");
		System.out.println("3.관리자");
		System.out.println("4.이전메뉴");
		System.out.println("**********");
		System.out.print("번호선택: ");
		int num = scan.nextInt();
			if(num == 1) {
				System.out.println("이름입력:");
				 name = scan.next();
				System.out.println("학번입력:");
				 value = scan.next();
				 code = num;
				 getConnection();//입력할때마다 연결해주어야한다.
			}else if(num == 2) {
				System.out.println("이름입력:");
				 name = scan.next();
				System.out.println("과목입력:");
				value = scan.next();
				 code = num;
				 getConnection();
			}else if(num == 3) {
				System.out.println("이름입력:");
				 name = scan.next();
				System.out.println("부서입력:");
				value = scan.next();
				 code = num;
				 getConnection();
			}else if(num == 4) {
				break;
			}
			String sql = "insert into student values(?,?,?)";
	
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, name);
				pstmt.setString(2, value);
				pstmt.setInt(3, code);
				
				int su = pstmt.executeUpdate();//실행
				System.out.println(su+"개의 행이 만들어 졌습니다.");
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}finally {
					try {
						if(pstmt !=null) pstmt.close();
						if(conn !=null) conn.close();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
			}
		}
		
	}
	
	public void searchArticle() {
		int num;
		String name = null;
		
		while(true) {
		System.out.println("**********");
		System.out.println("1. 이름 검색: ");
		System.out.println("2. 전체 검색: ");
		System.out.println("3. 이전 메뉴");
		System.out.println("**********");
		System.out.print("번호 검색: ");
		num = scan.nextInt();
		if(num ==3) break;
		
		if(num == 1) {
			
			System.out.println("검색할 이름 입력: ");
			name = scan.next();
			
		}
		String sql = null;
		getConnection();
		if(num ==1)
			sql = "select * from student where name like ?";
		else if(num == 2)
			sql = "select * from student";
		
		try {
			pstmt = conn.prepareStatement(sql);
			if(num == 1) pstmt.setString(1, "%"+name+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			System.out.print("이름 = "+rs.getString("name")+"\t");
			if(rs.getInt("code")==1)
				System.out.println("학번 = "+rs.getString("value"));
			else if(rs.getInt("code")==2)
				System.out.println("과목 = "+rs.getString("value"));
			else if(rs.getInt("code")==3)
				System.out.println("부서 = "+rs.getString("value"));
			
			}//while
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null)rs.close();			//rs도 닫아줘야함
				if(pstmt != null) pstmt.close();	//닫아주기 거꾸로
				if(conn != null) conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		}
		
		}//while
	}
	
	public void deleteArticle() {
		System.out.println("삭제할 이름 입력: ");
		String name = scan.next();
		
		// DB접속
		getConnection();
		String sql = "delete student where name =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int su = pstmt.executeUpdate();
			System.out.println(su+"개의 행이 삭제하였습니다.");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null) rs.close();			//rs도 닫아줘야함
				if(pstmt != null) pstmt.close();	//닫아주기 거꾸로
				if(conn != null) conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
		}
	}
	
	
	public static void main(String[] args) {
		Student st = new Student();
		st.menu();
		System.out.println("프로그램이 종료되었습니다.");
	}
}
