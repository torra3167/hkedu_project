package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import command.SellerJoinCommand;
import model.Seller;

@Repository
public class SellerRepository extends AbstractRepository{
	
	private final String namespace = "repository.mapper.sellerMapper";
	
	public Integer insertSeller(SellerJoinCommand sellerJoinCommand) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".insertSeller";
		try {
			System.out.println("repository " + sellerJoinCommand.getSellerEmail());
			System.out.println("repository " + sellerJoinCommand.getSellerPw());
			Integer result = sqlSession.insert(statement, sellerJoinCommand);
			if(result>0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
}
