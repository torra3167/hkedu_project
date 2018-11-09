package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import command.SellerJoinCommand;
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
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/*public Integer updateSeller(SellerUpdateCommand sellerUpdateCommand) {
		System.out.println("Repo updateSeller email" + sellerUpdateCommand.getSellerEmail());
=======
	public Integer updateSeller(Seller seller) {
		System.out.println("Repo updateSeller email" + seller.getSellerEmail());
>>>>>>> 003aa954e51359d3383be1bb313e6f83cc468ac9
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
	}*/
}
