package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import command.FindIDCommand;
import model.AuthInfo;
import model.FoodAndApplication;
import model.Member;
import model.Program;

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

	public List<Program> programList() {
		sqlSession = getSqlSessionFactory().openSession();

		try {

			List<Program> list = sqlSession.selectList("repository.mapper.programMapper.programList");
			return list;
		} finally {
			sqlSession.close();
		}
	}

	public List<FoodAndApplication> selectFoodList() {
		sqlSession = getSqlSessionFactory().openSession();
		try {
		List<FoodAndApplication> list =  sqlSession.selectList("repository.mapper.foodMapper.selectFoodList");
		
			return list;
			
		} finally {
			sqlSession.close();
		}
	}

	
	
	
	
	

}
