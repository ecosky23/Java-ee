package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import member.bean.MemberDTO;

public class MemberDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	
	private static MemberDAO instance;
	
	public static MemberDAO getInstance() {
		if(instance == null) {
			synchronized(MemberDAO.class) {//스레드 동기화 한번에 하나씩 실행되게 하기
				instance = new MemberDAO(); //null인 경우가 딱 한번이기 때문에 한번받게 실행되지 않는다
			}                               //메모리에 1번만 생성된다.
			
		}
		return instance;
		
	}
	
	public MemberDAO() {
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
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

	public int writeMember(MemberDTO memberDTO) {
		int su = 0;
		
		getConnection();
		
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getemail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getZipcode());
			pstmt.setString(11, memberDTO.getAddr1());
			pstmt.setString(12, memberDTO.getAddr2());
			
			su = pstmt.executeUpdate();//실행
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {
				//if(rs != null)rs.close();			//rs도 닫아줘야함
				if(pstmt != null) pstmt.close();	//닫아주기 거꾸로
				if(conn != null) conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
		
		return su;
	}
	
	public int loginsuccess(MemberDTO memberDTO) {
		int su = 0;
		
		getConnection();
		
		String sql = "select id, pwd from member where id=? and pwd=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getId());//1번에 id 넣어주기
			pstmt.setString(2, memberDTO.getPwd());//2번에 password넣어주기
			rs = pstmt.executeQuery();//실행하고 결과값 받아오기
			
			if(rs.next()) {
				if(memberDTO.getId().equals(rs.getString("id")) && 
					memberDTO.getPwd().equals(rs.getString("pwd"))){
					su = 1;
				}
			}else {
				su=2;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
            
            try {
                if(rs != null)rs.close();           //rs도 닫아줘야함
                if(pstmt != null) pstmt.close();    //닫아주기 거꾸로
                if(conn != null) conn.close();
            } catch (SQLException e2) {
                
                e2.printStackTrace();
            }
            return su;
        }
		

	}
	
	
	
	
	
}
