package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import controller.EmailCommand;
import model.Email;
import model.Member;

@Repository
public class EmailRepository extends AbstractRepository {

	private final String namespace = "repository.mapper.emailMapper";

	public int updatePW(Member member) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".updatePw";
		System.out.println("repository "+member.getMemberEmail());
		try {
			Integer result = sqlSession.update(statement, member);
			if (result > 0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}

	public Email selectByEmailAndName(Email email) {
		System.out.println("repository selectByEmailAndName "+email.getForName());
		SqlSession sqlSession=getSqlSessionFactory().openSession();
		try {
			return (Email)sqlSession.selectOne(namespace+".selectByEmailAndName", email);
		} finally {
			sqlSession.close();
		}
	}
}
