package repository;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.Coach;

@Repository
public class CoachRepository extends AbstractRepository {
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
	
	/*public List<Comment> selectCommentByCondtion(Comment comment) {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();
		try {
			Long commentNo = comment.getCommentNo();
			return sqlSession.selectList(namespace + ".selectCommentByCondtion", comment);

		} finally {
			sqlSession.close();
		}
		
	}*/

}
