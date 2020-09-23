package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardDTO;




public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;

	//private String driver = "oracle.jdbc.driver.OracleDriver";
	//private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	//private String username = "c##java";
	//private String password = "bit";
	
	private static BoardDAO instance;
	
	public BoardDAO() {
		
		try {
		
		Context	ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");// lookup이 안에 있는 메소드를 실행
									//tomcat의 경우 이렇게 써야한다
		} catch (NamingException e) {
		
		e.printStackTrace();
		}
		
		//try {
		//	Class.forName(driver);

		//} catch (ClassNotFoundException e) {

		//	e.printStackTrace();
			
		//}
	}
	
	public static BoardDAO getInstance() {
		if (instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}
	
	//public void getConnection() {
	//	try {
	//		conn = DriverManager.getConnection(url, username, password);

	//	} catch (SQLException e) {

	//		e.printStackTrace();
	//	}
	//}
	
	public void writeBoard(Map<String, String> map) {
			
		
		
		String sql ="insert into board(seq,id,name,email,subject,content,ref) values(seq_board.nextval,?,?,?,?,?,seq_board.currval)"; //ref - 그룹번호 = seq_board.currval 현재값가져오기
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, map.get("id"));
			pstmt.setString(2, map.get("name"));
			pstmt.setString(3, map.get("email"));
			pstmt.setString(4, map.get("subject"));
			pstmt.setString(5, map.get("content"));
			
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public List<BoardDTO> getBoardList(int startNum, int endNum){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		
		
		String sql = "select * from(select rownum rn, tt.*from(select * from board order by ref desc, step asc)tt) where rn>=? and rn<=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			
			rs=pstmt.executeQuery();//실행
			
			while(rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
				
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setEmail(rs.getString("email"));
				boardDTO.setRef(rs.getInt("ref"));
				boardDTO.setLev(rs.getInt("lev"));
				boardDTO.setStep(rs.getInt("step"));
				boardDTO.setPseq(rs.getInt("pseq"));				
				boardDTO.setReply(rs.getInt("reply"));		
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setHit(rs.getInt("hit"));
				
				boardDTO.setLogtime(rs.getDate("logtime"));
				
				list.add(boardDTO);
							
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			list = null;
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
		
		String sql="select count(*) from board";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			rs.next();
			totalA= rs.getInt(1);
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
	
	public BoardDTO boardView(int seq) {
		BoardDTO boardDTO = null;
		

		String sql = "select * from board where seq=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, seq);//하나만 해도 내용이 다나옴
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				boardDTO = new BoardDTO();
				
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setEmail(rs.getString("email"));
				boardDTO.setRef(rs.getInt("ref"));
				boardDTO.setLev(rs.getInt("lev"));
				boardDTO.setStep(rs.getInt("step"));
				boardDTO.setPseq(rs.getInt("pseq"));				
				boardDTO.setReply(rs.getInt("reply"));		
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(rs.getDate("logtime"));

			}
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
		
		return boardDTO;
	}
	
	public void boardViewModify(int seq, String subject, String content) {
	
		
		
		String sql = "update board set subject=?, content=?, logtime=sysdate where seq=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, subject);//sql순서대로 1 2 3번 해야한다.
			pstmt.setString(2, content);
			pstmt.setInt(3, seq);
			
			pstmt.executeUpdate();
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
		
	}
	
	
	
}
