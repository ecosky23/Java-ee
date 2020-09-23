package guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import guestbook.bean.GuestbookDTO;



public class GuestbookDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	private static GuestbookDAO instance;
	
	public static GuestbookDAO getInstance() {
		if(instance == null) {
			synchronized(GuestbookDAO.class) {
				instance = new GuestbookDAO();
			}
		}
		return instance;
	}
	
	public GuestbookDAO() {
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

	public int writeGuestBook(GuestbookDTO guestbookDTO) {
		int su = 0;
		getConnection();
		
		String sql = "insert into guestbook values(seq_guestbook.nextval,?,?,?,?,?,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, guestbookDTO.getName());
			pstmt.setString(2, guestbookDTO.getEmail());
			pstmt.setString(3, guestbookDTO.getHomepage());
			pstmt.setString(4, guestbookDTO.getTitle());
			pstmt.setString(5, guestbookDTO.getContent());
			
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

	public List<GuestbookDTO> getGuestbookList(int startNum, int endNum) {
		List<GuestbookDTO> list = new ArrayList<GuestbookDTO>();
		
		getConnection();
		
		String sql = "select * from" + 
				"(select rownum rn, tt.* from" + 
				"(select seq, name, email, homepage, subject, content, to_char(logtime,'YYYY.MM.DD') as logtime" + 
				" from guestbook order by seq desc)tt" + 
				")where rn>=? and rn<=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			
			rs = pstmt.executeQuery();//실행
			
			
			while(rs.next()) {
				GuestbookDTO guestbookDTO = new GuestbookDTO();
				
				guestbookDTO.setSeq(rs.getInt("seq"));
				guestbookDTO.setName(rs.getString("name"));
				guestbookDTO.setEmail(rs.getString("email"));
				guestbookDTO.setHomepage(rs.getString("homepage"));
				guestbookDTO.setTitle(rs.getString("subject"));
				guestbookDTO.setContent(rs.getString("content"));
				guestbookDTO.setLogtime(rs.getString("logtime"));
				
				list.add(guestbookDTO);//리스트에 DTO담기
			}//While
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			list = null;//에러가 발생하면 리스트를 버리고 리스트에 null이 닮기게해 에러를 파악한다.
		}finally {
			
			try {
				if(rs != null)rs.close();			//rs도 닫아줘야함
				if(pstmt != null) pstmt.close();	//닫아주기 거꾸로
				if(conn != null) conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
		
		return list;
	}

	public int getTotalA() {
		int totalA = 0;
		getConnection();
		
		String sql = "select count(*) from guestbook";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			rs.next();
			totalA = rs.getInt(1);
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
		
		
		return totalA;
	}

}
