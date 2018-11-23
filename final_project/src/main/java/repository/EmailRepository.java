package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import command.ChangePWCommand;
import command.FindIDCommand;
import model.Email;

@Repository
public class EmailRepository extends AbstractRepository {
	
	private final String namespace="repository.mapper.emailMapper";

	public Integer countSellerID(String email) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		String statement=namespace+".countSellerID";
		try {
			System.out.println("EMAILREPOSITORY CountSellerID "+email);
			Integer result=sqlSession.selectOne(statement, email);
			System.out.println("repository email "+email);
			if(result>0) {
				sqlSession.commit();
			}
			System.out.println("repository result "+result);
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	public FindIDCommand selectByEmail(FindIDCommand findIDCommand) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement=namespace+".selectByEmail";
		try {
			FindIDCommand selectEmail = (FindIDCommand)sqlSession.selectOne(statement, findIDCommand);
			return selectEmail;
		} finally {
			sqlSession.close();
		}
	}

	public Integer changePW(ChangePWCommand changePWCommand) {
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		String statement=namespace+".updatePW";
		try {
			String newPW=changePWCommand.getNewPW();
			String newPWChk=changePWCommand.getNewPWchk();
			if(newPW.equals(newPWChk)) {
				Integer i = sqlSession.selectOne(statement, changePWCommand);
				return i;
			}else {
				return -1;
			}
			
		} finally {
			sqlSession.close();
		}
	}
}
