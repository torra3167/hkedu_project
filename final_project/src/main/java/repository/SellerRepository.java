package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import command.SellerJoinCommand;
import model.Seller;
import model.SellerApplication;

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


	public Integer selectsellerAppliNo() {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
		return (Integer)sqlSession.selectOne(namespace + ".selectsellerAppliNo");
		
		} finally {
			sqlSession.close();
		}
	}


	public Integer insertSellerApplication(SellerApplication sellerApplication) {
		sqlSession = getSqlSessionFactory().openSession();
		try {
			Integer result = sqlSession.insert(namespace + ".insertSellerApplication", sellerApplication);
			System.out.println("repo insertSellerApplication result : " + result);
			if(result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			return result;
		} finally {
			sqlSession.close();
		}
	}


	public List<SellerApplication> selectSellerApplicationList() {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
		List<SellerApplication> list =  sqlSession.selectList(namespace + ".selectSellerApplicationList");
		for(Object temp : list) {
			SellerApplication sa = (SellerApplication)temp;
			System.out.println("repo selectSellerApplicationList getSellerAppliNo : "+ sa.getSellerAppliNo());
		}
		return list;
		} finally {
			sqlSession.close();
		}
	}


//	public SellerApplication selectSellerApplicationByEmail(String sellerEmail) {
//		System.out.println("repo selectSellerApplicationStatus sellerEmail " + sellerEmail);
//		sqlSession = getSqlSessionFactory().openSession();
//		try {
//			SellerApplication sellerApplication = sqlSession.selectOne(namespace + ".selectSellerApplicationByEmail", sellerEmail);
//			return sellerApplication;
//		} finally {
//			sqlSession.close();
//		}
//	}
//
//
//	public int deleteSellerApplication(int sellerAppliNo) {
//		sqlSession = getSqlSessionFactory().openSession();
//		Integer result = 0;
//		try {
//			result = sqlSession.update(namespace + ".deleteSellerApplication", sellerAppliNo);
//			if(result > 0) {
//				sqlSession.commit();
//			} else {
//				sqlSession.rollback();
//			}
//			return result;
//		} finally {
//			sqlSession.close();
//		}
//	}

	
	
}
