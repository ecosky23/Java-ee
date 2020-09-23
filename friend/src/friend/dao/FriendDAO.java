package friend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import friend.bean.FriendDTO;

public class FriendDAO {//bean   데이터 모아놓는 객체
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	
	public FriendDAO() {
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
	
	public int getSeq() {
		int seq = 0;
		getConnection(); //오라클에 접속
		
		String sql ="select seq_friend.nextval from dual"; //시퀀스가 가상 테이블에서 1씩 증가한다
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next(); //행이 하나밖에 없어서 while 안써도 된다. 행이 여러개면 while 써야된다
			seq = rs.getInt(1); // db의 1번 열에서 가져와라 
			
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
		return seq;
	}

	public int friendWrite(FriendDTO friendDTO) {//FriendManager로 리턴값 su를 보낸다.
		int su = 0;
		getConnection();
		String sql="insert into friend values(?,?,?,?,?,?,?,?,?,?,?)"; //모두 다집어 넣을 것이면 이렇게 만든다
		
		try {//데이터 베이스로 정보들 보내주기
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, friendDTO.getSeq());
			pstmt.setString(2, friendDTO.getName());
			pstmt.setString(3, friendDTO.getTel1());
			pstmt.setString(4, friendDTO.getTel2());
			pstmt.setString(5, friendDTO.getTel3());
			pstmt.setInt(6, friendDTO.getGender());
			pstmt.setInt(7, friendDTO.getRead());
			pstmt.setInt(8, friendDTO.getMovie());
			pstmt.setInt(9, friendDTO.getMusic());
			pstmt.setInt(10, friendDTO.getGame());
			pstmt.setInt(11, friendDTO.getShopping());
			
			su = pstmt.executeUpdate();
			
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
		
		return su;
	}

	public List<FriendDTO> getFriendList() {
		List<FriendDTO> list = new ArrayList<FriendDTO>();
		getConnection();
		String sql = "select * from friend";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();//실행
			
			while(rs.next()) {
				FriendDTO friendDTO = new FriendDTO();
				friendDTO.setSeq(rs.getInt("seq"));
				friendDTO.setName(rs.getString("name"));
				friendDTO.setTel1(rs.getString("tel1"));
				friendDTO.setTel2(rs.getString("tel2"));
				friendDTO.setTel3(rs.getString("tel3"));
				friendDTO.setGender(rs.getInt("gender"));
				friendDTO.setRead(rs.getInt("read"));
				friendDTO.setMovie(rs.getInt("movie"));
				friendDTO.setMusic(rs.getInt("music"));
				friendDTO.setGame(rs.getInt("game"));
				friendDTO.setShopping(rs.getInt("shopping"));
				
				
				list.add(friendDTO);//리스트에 FriendDTO를 모두 넣어줘서 리스트를 한번에 보내주기 
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			list = null;//만약 오류가 나면 null값으로 초기화 해주기 위해 넣기
		}finally {//오류 안나면 그냥 리스트 값이 리턴된다.
			
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
	
	public int deleteList(FriendDTO friendDTO) {
		int su = 0;
		
		getConnection();
		
		
		String sql = "delete friend where seq =?";
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, friendDTO.getSeq());
		//	pstmt.setString(2, friendDTO.getName());
			su = pstmt.executeUpdate();
			System.out.println(su+"개의 행이 삭제하였습니다.");
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {//오류 안나면 그냥 리스트 값이 리턴된다.
			
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

	public int friendModify(FriendDTO friendDTO) {
		int su = 0;
		
		getConnection();
		
		int seq = friendDTO.getSeq();
		
		String sql = "update friend set name=?"
										+", tel1=?"
										+", tel2=?"
										+", tel3=?"
										+", gender=?"
										+", read=?"
										+", movie=?"
										+", music=?"
										+", game=?"
										+", shopping=? where seq=?";
		
		
		try {//데이터 베이스로 정보들 보내주기
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, friendDTO.getName());
			pstmt.setString(2, friendDTO.getTel1());
			pstmt.setString(3, friendDTO.getTel2());
			pstmt.setString(4, friendDTO.getTel3());
			pstmt.setInt(5, friendDTO.getGender());
			pstmt.setInt(6, friendDTO.getRead());
			pstmt.setInt(7, friendDTO.getMovie());
			pstmt.setInt(8, friendDTO.getMusic());
			pstmt.setInt(9, friendDTO.getGame());
			pstmt.setInt(10, friendDTO.getShopping());
			pstmt.setInt(11, friendDTO.getSeq());
			
			
			su = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			
			try {
			//	if(rs != null)rs.close();			//rs도 닫아줘야함
				if(pstmt != null) pstmt.close();	//닫아주기 거꾸로
				if(conn != null) conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
	}
		
		
		return su;
	}
	
	
}




