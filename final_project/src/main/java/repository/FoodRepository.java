package repository;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import category.FoodCatA;
import category.FoodCatB;
import category.FoodCatC;
import model.DietRecord;
import model.Food;
import model.FoodAndApplication;
import model.FoodReview;
import model.FoodReviewAndAnswer;
import model.FoodReviewAnswer;
import model.FoodReviewReport;

@Repository
public class FoodRepository extends AbstractRepository{
	
	SqlSession sqlSession;
	
	private final String namespace = "repository.mapper.foodMapper";
	
	public List<Food> sellerFoodList(String sellerEmail) {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
		List<Food> list =  sqlSession.selectList(namespace + ".sellerFoodList", sellerEmail);
//		for(Object temp : list) {
//			 Food food = (Food)temp;
//			 System.out.println("repo foodNo : "+food.getFoodNo());
//		}
		return list;
		} finally {
			sqlSession.close();
		}
	}
	
	public Integer selectFoodNumber() {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
		return (Integer)sqlSession.selectOne(namespace + ".selectFoodNumber");
		
		} finally {
			sqlSession.close();
		}
	}
	
	public Integer insertFood(Food food) {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			Integer result = sqlSession.insert(namespace + ".insertFood", food);
			System.out.println("food REPO " + result);
		
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
	

	public List<FoodCatC> ccaSelect() {
		sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".ccaSelect";
		try {
			return sqlSession.selectList(statement);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<FoodCatA> acaSelect(FoodCatA foodCatA) {
		sqlSession = getSqlSessionFactory().openSession();
		try {
			System.out.println("A repository No : " + foodCatA.getFoodCatBNo());
		return sqlSession.selectList(namespace + ".acaSelect", foodCatA);
		} finally {
			sqlSession.close();
		}
	}

	public List<FoodCatB> bcaSelect(FoodCatB foodCatB) {
		sqlSession = getSqlSessionFactory().openSession();
		try {
			System.out.println("B repository No : " + foodCatB.getFoodCatCNo());
			return sqlSession.selectList(namespace + ".bcaSelect", foodCatB);
		} finally {
			sqlSession.close();
		}
	}

	public Food selectSellerFood(int foodNo) {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
		return (Food)sqlSession.selectOne(namespace + ".selectSellerFood", foodNo);
		
		} finally {
			sqlSession.close();
		}
	}

	public Integer updateFood(Food food) {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();
		Integer result = 0;
		try {
			result = sqlSession.update(namespace + ".updateFood", food);
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

	public Integer deleteFood(int foodNo) {
		sqlSession = getSqlSessionFactory().openSession();
		Integer result = 0;
		try {
			result = sqlSession.update(namespace + ".deleteFood", foodNo);
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


	public List<FoodAndApplication> selectFoodList() {
		sqlSession = getSqlSessionFactory().openSession();
		try {
		List<FoodAndApplication> list =  sqlSession.selectList(namespace + ".selectFoodList");
		
		for(Object temp : list) {
			FoodAndApplication foodAppli = (FoodAndApplication)temp;
			 System.out.println("repo selectFoodList storeName : "+foodAppli.getStoreName());
		}
		return list;
		} finally {
			sqlSession.close();
		}

	}


	public Integer selectFoodReviewNo() {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
		return (Integer)sqlSession.selectOne(namespace + ".selectFoodReviewNo");
		
		} finally {
			sqlSession.close();
		}
	}

	public int insertFoodReview(FoodReview foodReview) {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			Integer result = sqlSession.insert(namespace + ".insertFoodReview", foodReview);
			System.out.println("repo insertFoodReview result : " + result);
		
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

	public FoodAndApplication selectFood(int foodNo) {
		sqlSession = getSqlSessionFactory().openSession();
		try {
			
			FoodAndApplication result =  sqlSession.selectOne(namespace + ".selectFood", foodNo);
			System.out.println("repo selectFood storeName : " + result.getStoreName());
		return result;
		} finally {
			sqlSession.close();
		}
	}

	public List<FoodReviewAndAnswer> selectReviewAndAnswer(int foodNo) {
		sqlSession = getSqlSessionFactory().openSession();
		try {
			
			List<FoodReviewAndAnswer> result =  sqlSession.selectList(namespace + ".selectReviewAndAnswer", foodNo);
			for(Object temp : result) {
				FoodReviewAndAnswer fraa = (FoodReviewAndAnswer)temp;
				System.out.println("repo selectReviewAndAnswer selectReviewAndAnswer : " + fraa.getFoodReviewRegdate());
				List<FoodReviewAnswer> fra = fraa.getFoodReviewAnswers();
				System.out.println("repo selectReviewAndAnswer List<FoodReviewAnswer>fra.size() : " + fra.size());
//				for(Object temp2 : fra) {
//					FoodReviewAnswer foodReviewAnswer = (FoodReviewAnswer)temp2;
//					System.out.println("repo selectReviewAndAnswer getFoodReviewAnswerRegdate : " + foodReviewAnswer.getFoodReviewAnswerRegdate());
//				}
			}
//			System.out.println("repo selectReviewAndAnswer result : " + result);
		return result;
		} finally {
			sqlSession.close();
		}
	}

	public int updateFoodReview(FoodReview foodReview) {
		sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.update(namespace + ".updateFoodReview", foodReview);
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

	public int deleteFoodReview(int foodReviewNo) {
		sqlSession = getSqlSessionFactory().openSession();
		Integer result = 0;
		try {
			result = sqlSession.update(namespace + ".deleteFoodReview", foodReviewNo);
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

	public Integer selectfoodReviewAnswerNo() {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
		return (Integer)sqlSession.selectOne(namespace + ".selectfoodReviewAnswerNo");
		
		} finally {
			sqlSession.close();
		}
	}

	public int insertFoodReviewAnswer(FoodReviewAnswer foodReviewAnswer) {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			Integer result = sqlSession.insert(namespace + ".insertFoodReviewAnswer", foodReviewAnswer);
			System.out.println("repo insertFoodReviewAnswer result : " + result);
		
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

	public int updateFoodReviewAnswer(FoodReviewAnswer foodReviewAnswer) {
		sqlSession = getSqlSessionFactory().openSession();
		int result = 0;
		try {
			result = sqlSession.update(namespace + ".updateFoodReviewAnswer", foodReviewAnswer);
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

	public int deleteFoodReviewAnswer(int foodReviewAnswerNo) {
		sqlSession = getSqlSessionFactory().openSession();
		Integer result = 0;
		try {
			result = sqlSession.update(namespace + ".deleteFoodReviewAnswer", foodReviewAnswerNo);
			System.out.println("repo deleteFoodReviewAnswer result : " + result);
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

	public int insertFoodReviewReport(FoodReviewReport foodReviewReport) {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			Integer result = sqlSession.insert(namespace + ".insertFoodReviewReport", foodReviewReport);
			System.out.println("repo insertFoodReviewReport result : " + result);
		
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

	public List<FoodReviewReport> selectFoodReviewReportList() {
		sqlSession = getSqlSessionFactory().openSession();
		try {
		List<FoodReviewReport> list =  sqlSession.selectList(namespace + ".selectFoodReviewReportList");
		
		for(Object temp : list) {
			FoodReviewReport foodReviewReport = (FoodReviewReport)temp;
			 System.out.println("repo selectFoodReviewReportList foodReviewReport : "+ foodReviewReport);
		}
		return list;
		} finally {
			sqlSession.close();
		}
	}

	public FoodReviewReport selectFoodReviewReport(String foodReportRegdate) {
		sqlSession = getSqlSessionFactory().openSession();
		try {
			FoodReviewReport result = (FoodReviewReport)sqlSession.selectOne(namespace + ".selectFoodReviewReport", foodReportRegdate);
			System.out.println("repo selectFoodReviewReport getFoodReportRegdate : " + result.getFoodReportRegdate());
		return result;
		} finally {
			sqlSession.close();
		}
	}

	public int deleteFoodReviewReport(String foodReportRegdate) {
		sqlSession = getSqlSessionFactory().openSession();
		Integer result = 0;
		try {
			result = sqlSession.update(namespace + ".deleteFoodReviewReport", foodReportRegdate);
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

	public List<Food> selectFoodListByCategoryA(int foodCatANo) {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
		List<Food> list =  sqlSession.selectList(namespace + ".selectFoodListByCategoryA", foodCatANo);
		
		
		
		return list;
		
		
		} finally {
			sqlSession.close();
		}
	}
			
	public List<Food> selectOrderedFoodList(String memberEmail) {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			List<Food> list1 =  sqlSession.selectList(namespace + ".selectOrderedFoodList1", memberEmail);
			for(Object temp : list1) {
				 Food food = (Food)temp;
				 System.out.println("repo selectOrderedFoodList1 getFoodName : " + food.getFoodName());
			}
			
			List<Food> list2 = sqlSession.selectList(namespace + ".selectOrderedFoodList2", memberEmail);
			for(Object temp : list2) {
				 Food food = (Food)temp;
				 System.out.println("repo selectOrderedFoodList2 getFoodName : " + food.getFoodName());
			}
			
			List<Food> foodOrderList = new ArrayList<Food>(list1);
			foodOrderList.addAll(list2);
			System.out.println("repo selectOrderedFoodList foodOrderList.size : " + foodOrderList.size());
			
			return foodOrderList;
		} finally {
			sqlSession.close();
		}
	}

	public Integer insertDietRecord(DietRecord dietRecord) {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			Integer result = sqlSession.insert(namespace + ".insertDietRecord", dietRecord);
			System.out.println("repo insertDietRecord result : " + result);
		
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

	public Integer deleteDietRecord(DietRecord dietRecord) {
		sqlSession = getSqlSessionFactory().openSession();
		Integer result = 0;
		try {
			result = sqlSession.update(namespace + ".deleteDietRecord", dietRecord);
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

	public List<DietRecord> selectDietRecordList(String memberEmail) {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			List<DietRecord> list =  sqlSession.selectList(namespace + ".selectDietRecordList", memberEmail);
			System.out.println("repo selectDietRecordList list.size : " + list.size());
		return list;
		
		} finally {
			sqlSession.close();
		}
	}




	
	
}
