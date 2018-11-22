package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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
	
	public Email selectByEmail(String email) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement=namespace+".selectByEmail";
		try {
			Email selectEmail = (Email)sqlSession.selectOne(statement, email);
			return selectEmail;
		} finally {
			sqlSession.close();
		}
	}

	public Email selectByPhone(String phone) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement=namespace+".selectByPnone";
		try {
			Email selectPhone = (Email)sqlSession.selectOne(statement, phone);
			return selectPhone;
		} finally {
			sqlSession.close();
		}
	}
}
