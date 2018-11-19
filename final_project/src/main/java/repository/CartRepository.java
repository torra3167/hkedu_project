package repository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.Coach;

@Repository
public class CartRepository extends AbstractRepository {
	SqlSession sqlSession;
	private final String namespace = "repository.mapper.coachMapper";
	
	public Coach selectByEmail(String email) {
		System.out.println("selectByEmail Email " + email);
		sqlSession = getSqlSessionFactory().openSession();
		try {
			return (Coach)sqlSession.selectOne(namespace + ".selectByEmail", email);

		} finally {
			sqlSession.close();
		}
	}
	
	

}
