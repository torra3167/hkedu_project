package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.ProReview;

@Repository
public class ProReviewRepository extends AbstractRepository {
	SqlSession sqlSession;
	private final String namespace = "repository.mapper.proReviewMapper";
	
	public Integer insertProReview(ProReview proReview) {
		System.out.println("PROGRAM REVIEW");
		int result = 0;
		sqlSession = getSqlSessionFactory().openSession();
		try {
			result = sqlSession.insert(namespace + ".insertProReview", proReview);

			System.out.println("PROGRAM REVIEW RESULT" + result);

			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

			return result;

		} finally {
			sqlSession.close();
		}
	}

	public List<ProReview> selectProReviewListByProNo(int proNo) {
		sqlSession = getSqlSessionFactory().openSession();

		try {

			return sqlSession.selectList(namespace + ".selectProReviewListByProNo", proNo);

		} finally {
			sqlSession.close();
		}
	}

	public List<ProReview> selectProReviewAllList() {
		sqlSession = getSqlSessionFactory().openSession();

		try {

			return sqlSession.selectList(namespace + ".selectProReviewAllList");

		} finally {
			sqlSession.close();
		}
	}

	public Integer updateProReview(ProReview proReview) {
		sqlSession = getSqlSessionFactory().openSession();

		try {
			Integer result = sqlSession.insert(namespace + ".updateProReview", proReview);
			System.out.println("UPDATE ProReview " + result);

			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}

			return result;

		} finally {
			sqlSession.close();
		}
	}
}
