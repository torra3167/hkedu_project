package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import category.FoodCatA;
import category.FoodCatB;
import category.FoodCatC;
import model.Food;

@Repository
public class FoodRepository extends AbstractRepository{
	
	SqlSession sqlSession;
	
	private final String namespace = "repository.mapper.foodMapper";
	
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
			
		return (Integer)sqlSession.selectOne(namespace + ".insertFood", food);
		
		} finally {
			sqlSession.close();
		}
	}
	
	
	/*public List<FoodCatA> foodCatASelect(FoodCatB bca) {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
		return sqlSession.selectList(namespace + ".foodCatASelect", bca);
		
		} finally {
			sqlSession.close();
		}
	}
	
	public List<ExerciseCatB> foodCatBSelect() {
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
		return sqlSession.selectList(namespace + ".foodCatBSelect");
		
		} finally {
			sqlSession.close();
		}
	}*/

	
	public List<FoodCatA> acaSelect(FoodCatA foodCatA) {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();
		
		try {
			System.out.println("C repository getFoodCatCNo : " + foodCatA.getFoodCatBNo());

		return sqlSession.selectList(namespace + ".acaSelect", foodCatA);
		
		} finally {
			sqlSession.close();
		}
		
	}



	public List<FoodCatB> bcaSelect(FoodCatB foodCatB) {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();
		try {
			System.out.println("B repository getFoodCatCNo : " + foodCatB.getFoodCatCNo());
			return sqlSession.selectList(namespace + ".bcaSelect", foodCatB);
			
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
	
	
}
