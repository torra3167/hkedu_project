package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.AuthInfo;

@Repository
public class LoginRepository extends AbstractRepository{
	SqlSession sqlSession;
	private final String namespace = "repository.mapper.loginMapper";
	
	public AuthInfo selectByEmailAndDivide(String email) {
		// TODO Auto-generated method stub
/*		System.out.println("selectByEmailAndDivide Email " + email);
*/		sqlSession = getSqlSessionFactory().openSession();
		try {
			AuthInfo authInfo = (AuthInfo)sqlSession.selectOne(namespace + ".selectByEmailAndDivide",email);
/*			System.out.println("authInfo" + authInfo);
*/			return authInfo;

		} finally {
			sqlSession.close();
		}
	}
	
	
	
	

}
