package repository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.Coach;

@Repository
public class PayRepository extends AbstractRepository {
	SqlSession sqlSession;
	private final String namespace = "repository.mapper.payMapper";
	
	
	
	

}
