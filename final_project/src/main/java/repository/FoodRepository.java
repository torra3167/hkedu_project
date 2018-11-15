package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import category.FoodCatA;
import category.FoodCatB;
import category.FoodCatC;
import model.Food;
import model.Upload;

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

	
	
}
