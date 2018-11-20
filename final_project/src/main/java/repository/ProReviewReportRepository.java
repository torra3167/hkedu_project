package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


@Repository
public class ProReviewReportRepository extends AbstractRepository {
	SqlSession sqlSession;
	private final String namespace = "repository.mapper.proReviewMapper";
	
	
}
