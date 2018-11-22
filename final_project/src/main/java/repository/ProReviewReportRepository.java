package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.FoodReviewReport;
import model.ProReviewReport;


@Repository
public class ProReviewReportRepository extends AbstractRepository {
	SqlSession sqlSession;
	private final String namespace = "repository.mapper.proReviewReportMapper";
	
	
	public void insertProReviewReport(ProReviewReport proReviewReport) {
		sqlSession = getSqlSessionFactory().openSession();
		
		Integer selectSequenceNumber = sqlSession.selectOne(namespace + ".selectSequenceNumber");
		
		System.out.println("SEQUENCE NUMBER" + selectSequenceNumber);
		
		try {
			proReviewReport.setProReviewNo(selectSequenceNumber);
			Integer result = sqlSession.insert(namespace + ".insertFoodReviewReport", proReviewReport);
			System.out.println("insertFoodReviewReport result : " + result);
		
			if(result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		
			if(result < 1) {
				System.out.println("PRO REVIEW REPORT INSERT 실패");
			}
		} finally {
			sqlSession.close();
		}
		
		
	}


	public List<ProReviewReport> selectProReviewReportList() {
		sqlSession = getSqlSessionFactory().openSession();
		try {
			List<ProReviewReport> list = sqlSession.selectList(namespace + ".selectProReviewReportList");
			
			/*for (Object temp : list) {
				ProReviewReport proReviewReport = (ProReviewReport) temp;
				System.out.println("proReviewReport : " + proReviewReport);
			}*/
			return list;
			
		} finally {
			sqlSession.close();
		}
	}
	
	
}
