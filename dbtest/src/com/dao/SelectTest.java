package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;//select결과 담아오는 것
	
	public SelectTest() {
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
	
	public void selectArticle() {
		getConnection();
		
		String sql = "select name,age,height, to_char(logtime, 'yyyy.mm.dd') as logtime" //원하는 형식으로 logtime를 변경하는 방법
				+ " from dbtest";
		//String sql = "select * from dbtest"; 테이블 불러오는 것
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();//db에서 결과값을 받아오는 것
			
			while(rs.next()) { //re.next() 현재 위치에 레크드(행)가 있으면 true 다음행으로 넘어가고 없으면 false가 나와 끝남
						System.out.println(rs.getString("name")+"\t"
											+ rs.getInt("age")+"\t"
											+ rs.getDouble("height")+"\t"
											+ rs.getString("logtime"));
				
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
			
		}//finally
	}
	
	
	public static void main(String[] args) {
		SelectTest selectTest = new SelectTest();
		selectTest.selectArticle();
	}
}
