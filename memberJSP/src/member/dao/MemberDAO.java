package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;

//	private String driver = "oracle.jdbc.driver.OracleDriver";
//	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	private String username = "c##java";
//	private String password = "bit";

	private static MemberDAO instance;

	public MemberDAO() {
				
		try {
			
			Context	ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");// lookup이 안에 있는 메소드를 실행
										//tomcat의 경우 이렇게 써야한다
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
		
	//	try {
	//		Class.forName(driver);

	//	} catch (ClassNotFoundException e) {

	//		e.printStackTrace();
			
	//	}
	}

	public static MemberDAO getInstance() {
		if (instance == null) {
			synchronized (MemberDAO.class) {
				instance = new MemberDAO();
			}
		}
		return instance;
	}

//	public void getConnection() {
	//	try {
	//		conn = DriverManager.getConnection(url, username, password);

	//	} catch (SQLException e) {

	//		e.printStackTrace();
	//	}
//	}

	public boolean isExistId(String id) {

		

		boolean exist = false;

		String sql = "select * from member where id=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (id.equals(rs.getString("id"))) {
					exist = true;
				} else
					exist = false;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close(); // rs도 닫아줘야함
				if (pstmt != null)
					pstmt.close(); // 닫아주기 거꾸로
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return exist;
	}

	public List<ZipcodeDTO> getZipcodeList(String sido, String sigungu, String roadname) {
		

		List<ZipcodeDTO> list = new ArrayList<ZipcodeDTO>();

		String sql = "select * from newzipcode where sido like ? and nvl(sigungu, '0') like ? and roadname like ?";
		// 세종시 때문에 시군구를 nvl로 준다.

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + sido + "%");// 앞뒤로 %% 쓰는 이유는 강남만 치면 강남에 관련된 모든 글이 나오게 하기 위해
			pstmt.setString(2, "%" + sigungu + "%");
			pstmt.setString(3, "%" + roadname + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				ZipcodeDTO zipcodeDTO = new ZipcodeDTO();
				zipcodeDTO.setZipcode(rs.getString("zipcode"));
				zipcodeDTO.setSido(rs.getString("sido"));
				zipcodeDTO.setSigungu(rs.getString("sigungu") == null ? "" : rs.getString("sigungu"));// 조건 연산자 조건 ? 참 :
																										// 거짓
				zipcodeDTO.setYubmyundong(rs.getString("yubmyundong"));

				zipcodeDTO.setRi(rs.getString("ri") == null ? "" : rs.getString("ri"));

				zipcodeDTO.setRoadname(rs.getString("roadname"));
				zipcodeDTO.setBuildingname(rs.getString("buildingname") == null ? "" : rs.getString("buildingname"));

				list.add(zipcodeDTO);
			}

		} catch (SQLException e) {

			e.printStackTrace();
			list = null;
		} finally {

			try {
				if (rs != null)
					rs.close(); // rs도 닫아줘야함
				if (pstmt != null)
					pstmt.close(); // 닫아주기 거꾸로
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return list;
	}

	public MemberDTO loginMember(String id, String pwd) {
		
		MemberDTO memberDTO = null;
		
		

		String sql = "select * from member where id=? and pwd=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setName(rs.getString("name"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));
				memberDTO.setTel1(rs.getString("tel1"));
				memberDTO.setTel2(rs.getString("tel2"));
				memberDTO.setTel3(rs.getString("tel3"));
				memberDTO.setZipcode(rs.getString("zipcode"));
				memberDTO.setAddr1(rs.getString("addr1"));
				memberDTO.setAddr2(rs.getString("addr2"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close(); // rs도 닫아줘야함
				if (pstmt != null)
					pstmt.close(); // 닫아주기 거꾸로
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {

				e2.printStackTrace();
			}
			
		}
		return memberDTO;
	}

	public MemberDTO getMember(String id) {

		

		MemberDTO memberDTO = null;

		String sql = "select * from member where id=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				memberDTO = new MemberDTO();

				memberDTO.setName(rs.getString("name"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));
				memberDTO.setTel1(rs.getString("tel1"));
				memberDTO.setTel2(rs.getString("tel2"));
				memberDTO.setTel3(rs.getString("tel3"));
				memberDTO.setZipcode(rs.getString("zipcode"));
				memberDTO.setAddr1(rs.getString("addr1"));
				memberDTO.setAddr2(rs.getString("addr2"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {// 오류 안나면 그냥 리스트 값이 리턴된다.

			try {
				if (rs != null)
					rs.close(); // rs도 닫아줘야함
				if (pstmt != null)
					pstmt.close(); // 닫아주기 거꾸로
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return memberDTO;
	}
	
	public void modifyMember(MemberDTO memberDTO) {
		
		String sql ="update member set name=?,"
										+"pwd=?,"
										+"gender=?,"
										+"email1=?,"
										+"email2=?,"
										+"tel1=?,"
										+"tel2=?,"
										+"tel3=?,"
										+"zipcode=?,"
										+"addr1=?,"
										+"addr2=?,"
										+"logtime=sysdate where id=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getGender());
			pstmt.setString(4, memberDTO.getEmail1());
			pstmt.setString(5, memberDTO.getEmail2());
			pstmt.setString(6, memberDTO.getTel1());
			pstmt.setString(7, memberDTO.getTel2());
			pstmt.setString(8, memberDTO.getTel3());
			pstmt.setString(9, memberDTO.getZipcode());
			pstmt.setString(10, memberDTO.getAddr1());
			pstmt.setString(11, memberDTO.getAddr2());
			pstmt.setString(12, memberDTO.getId());
			
			pstmt.executeUpdate();//업테이트 실행
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {// 오류 안나면 그냥 리스트 값이 리턴된다.

			try {
				
				if (pstmt != null)
					pstmt.close(); // 닫아주기 거꾸로
				if (conn != null)
					conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
	}
	
	public int writeMember(MemberDTO memberDTO) {
		int su=0;
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";
		
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
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
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return su;
	}
	
	


}
