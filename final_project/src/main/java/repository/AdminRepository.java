package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.SellerApplication;

@Repository
public class AdminRepository extends AbstractRepository{
	SqlSession sqlSession;
	
	private final String namespace = "repository.mapper.adminMapper";

	public int updateSellerDivideS(String sellerEmail) {
		System.out.println("repo updateSellerDivideS sellerEmail" + sellerEmail);
		sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".updateSellerDivideS";
			Integer result = sqlSession.update(statement, sellerEmail);
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

	public SellerApplication selectAppliByAppliNo(int sellerAppliNo) {
		System.out.println("repo selectAppliByAppliNo sellerAppliNo " + sellerAppliNo);
		sqlSession = getSqlSessionFactory().openSession();
		try {
			SellerApplication sellerApplication = sqlSession.selectOne(namespace + ".selectAppliByAppliNo", sellerAppliNo);
			return sellerApplication;
		} finally {
			sqlSession.close();
		}
	}

	public void updateAppliStatusAprov(String sellerEmail) {
		System.out.println("repo updateAppliStatusAprov sellerApplication " + sellerEmail);
		sqlSession = getSqlSessionFactory().openSession();
		try {
			
			Integer result = sqlSession.update(namespace + ".updateAppliStatusAprov", sellerEmail);
			if(result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		}
	}

	public void updateApplicationStatusReturn(SellerApplication sellerApplication) {
		System.out.println("repo updateApplicationStatusReturn sellerApplication " + sellerApplication);
		sqlSession = getSqlSessionFactory().openSession();
		try {
			
			Integer result = sqlSession.update(namespace + ".updateApplicationStatusReturn", sellerApplication);
			if(result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} finally {
			sqlSession.close();
		}
	}

	public int updateSellerDivideW(String sellerEmail) {
		System.out.println("repo updateSellerDivideW sellerEmail" + sellerEmail);
		sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".updateSellerDivideW";
			Integer result = sqlSession.update(statement, sellerEmail);
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

	public int deleteSellerApplication(String sellerEmail) {
		System.out.println("repo deleteSellerApplication sellerEmail" + sellerEmail);
		sqlSession = getSqlSessionFactory().openSession();
		try {
			String statement = namespace + ".deleteSellerApplication";
			Integer result = sqlSession.delete(statement, sellerEmail);
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
}
