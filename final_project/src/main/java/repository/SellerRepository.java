package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import command.SellerJoinCommand;
import command.SellerUpdateCommand;
import model.Coach;
import model.Seller;

@Repository
public class SellerRepository extends AbstractRepository{
	
	SqlSession sqlSession;
	
	private final String namespace = "repository.mapper.sellerMapper";
	
	public Integer insertSeller(SellerJoinCommand sellerJoinCommand) {
		sqlSession = getSqlSessionFactory().openSession();
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
	
	
	public Seller selectByEmail(String email) {
		System.out.println("Repository selectByEmail Email " + email);
		sqlSession = getSqlSessionFactory().openSession();
		try {
			return (Seller)sqlSession.selectOne(namespace + ".selectByEmail", email);

		} finally {
			sqlSession.close();
		}
	}

	
	public Integer updateSeller(Seller seller) {
		System.out.println("Repo updateSeller email" + seller.getSellerEmail());
		sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".updateSeller";
			Integer result = sqlSession.update(statement, seller);
			if(result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
	
	public Integer deleteSeller(Seller seller) {
		System.out.println("Repo deleteSeller email" + seller.getSellerEmail());
		sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".deleteSeller";
			Integer result = sqlSession.update(statement, seller);
			
			sqlSession.delete(namespace + ".deleteFood", seller.getSellerEmail());
			if(result > 0) {
				sqlSession.commit();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}
}
