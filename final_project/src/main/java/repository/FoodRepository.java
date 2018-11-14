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

	
	
}
