package user.dao;


import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	
	private static UserDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	public static UserDAO getInstance() {
		if (instance == null) {
			synchronized (UserDAO.class) {
				instance = new UserDAO();
			}
		}
		return instance;
	}
	
	public UserDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");//xml파일을 ibatis를 임포트하고 리더로 읽는다.
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);//모든 환경설정한 값이 sqlSessionFactory로 간다. 오라클과의 접속도 mybatis-config에서 한다.
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public int write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.insert("userSQL.write", userDTO);//sqlSession.insert를 하면 userMapper에 있는 insert의 write를 불러온다.
												//값이 이동할때는 하나의 값은 가지못하고 꼭 DTO처럼 묶은 값만 이동할 수 있다.
												//userDTO값을 userMapper.xml로 보내준다.
		sqlSession.commit();//sql의 insert delete update의 경우 항상 commit를 해줘야 한다.
		sqlSession.close();
		return su;
	}

	public List<UserDTO> getUserList() {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");//getUserList가 userMapper에 있는 id이다.
		
		sqlSession.close();
		
		return list;
	}

	public UserDTO getSearch(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO userDTO = sqlSession.selectOne("userSQL.getSearch", id);
		
		sqlSession.close();
		
		return userDTO;	
	}
	
	public void modify(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("userSQL.modify", map);
		
		sqlSession.commit();//sql의 insert delete update의 경우 항상 commit를 해줘야 한다.
		sqlSession.close();
		
		
	}

	public void delete(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("userSQL.delete", id);
		
		sqlSession.commit();//sql의 insert delete update의 경우 항상 commit를 해줘야 한다.
		sqlSession.close();
		
	}

	public List<UserDTO> nameSearch(String name) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.nameSearch", name);
		sqlSession.close();
				
		return list;
		
	}

	public List<UserDTO> idSearch(String id) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.idSearch", id);
		sqlSession.commit();
		sqlSession.close();
				
		return list;
		
		
	}

	public List<UserDTO> search(Map map) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.search", map);
		sqlSession.close();
		
		return list;
	}

	
}
