package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest {
	private Connection conn;
	private PreparedStatement pstmt;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";//url = jdbc:oracle:드라이버이름:자신의주소 :포트번호:데이터베이스 이름
	private String username = "c##java";
	private String password = "bit";
	public InsertTest() {//생성자에서 드라이버 로딩 실행
											
		try {												//"OracleDriver.class" 생성
			Class.forName(driver);//파일을 클레스 타입으로 생성 모든 파일 경로를 표시해야함
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);//url 주소 ,오라클 아이디 , 오라클 비번
			System.out.println("접속 성공");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void insertArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.println("이름 입력");
		String name = scan.next();
		System.out.println("나이 입력");
		int age = scan.nextInt();
		System.out.println("키 입력");
		double height = scan.nextDouble();	//DB에 넣기
		
		this.getConnection();//겟 커넥션을 불러와서 오라클과 연결 실행
		String sql = "insert into dbtest values(?,?,?,sysdate)";//데이터 보안을 위해 입력값을 ?로 써준다.
	try {
		 pstmt = conn.prepareStatement(sql);//생성
		 									//데이터를 ?에 주입
		 pstmt.setString(1, name);//1번 ?에 이름이 들어간가
		 pstmt.setInt(2, age);//2번 ?에 나이가 들어간다
		 pstmt.setDouble(3, height);//3번 ?에 키가 들어간가.
		 
		int su = pstmt.executeUpdate();//실행
		System.out.println(su+"개의 행이 만들어 졌습니다.");
		 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {//에러가 걸려도 무조건 실행하기
			try {
				if(pstmt !=null) pstmt.close();// 접속 끊기 처음과 반대로  빈값이 아닐때 끊기 만약에 빈값이면 에러가 걸린
				if(conn !=null) conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		InsertTest insertTest = new InsertTest();
			insertTest.insertArticle();// 인서트 아티클 실행
	}
}
