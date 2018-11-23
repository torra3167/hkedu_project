package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.Notice;

@Repository
public class NoticeRepository extends AbstractRepository {
	private final String namespace = "repository.mapper.noticeMapper";

	public Integer insertNotice(Notice notice) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".insertNotice";
		try {
			System.out.println("NOTICEREPOSITORY InsertNotice " + notice.getNoticeTitle());
			Integer result = sqlSession.insert(statement, notice);
			System.out.println("NoticeRepository " + result);
			if (result > 0) {
				sqlSession.close();
			}
			return result;
		} finally {
			sqlSession.close();
		}

	}
}
