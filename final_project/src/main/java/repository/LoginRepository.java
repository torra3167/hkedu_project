package repository;

import org.apache.ibatis.session.SqlSession;

import model.AuthInfo;

public class LoginRepository extends AbstractRepository{
	SqlSession sqlSession;
	private final String namespace = "repository.mapper.loginMapper";
	
	public AuthInfo selectByEmailAndDivide(String email) {
		// TODO Auto-generated method stub
		System.out.println("selectByEmailAndDivide Email " + email);
		sqlSession = getSqlSessionFactory().openSession();
		try {
			return (AuthInfo)sqlSession.selectOne(namespace + ".selectByEmailAndDivide",email);

		} finally {
			sqlSession.close();
		}
	}
	
	
	
	

}
