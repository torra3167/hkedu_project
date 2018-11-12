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

	
	public List<FoodCatC> foodCatCSelect() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String statement = namespace + ".foodCatCSelect";
		try {
			return sqlSession.selectList(statement);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<FoodCatB> foodCatBSelect(FoodCatC foodCatC) {
		sqlSession = getSqlSessionFactory().openSession();
		try {
			System.out.println("CommentSessionRepository " + foodCatC.getFoodCatCNo());
			return sqlSession.selectList(namespace + ".foodCatBSelect", foodCatC);
			
		} finally {
			
			sqlSession.close();
		}
		
	}


	public List<FoodCatA> foodCatASelect(FoodCatB foodCatB) {
			 sqlSession = getSqlSessionFactory().openSession();
			 String statement = namespace + ".foodCatASelect";
			try {
				return sqlSession.selectList(statement, foodCatB);
			} finally {
				sqlSession.close();
			}
	}
	
}
