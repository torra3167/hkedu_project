package repository;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.Coach;
import model.Food;
import model.FoodProFood;
import model.Program;

@Repository
public class CartRepository extends AbstractRepository {
	SqlSession sqlSession;
	private final String namespace = "repository.mapper.cartMapper";
	
	


	public Food selectSellerFood(int foodNo) {
		
		sqlSession = getSqlSessionFactory().openSession();

		try {

			return (Food)sqlSession.selectOne("repository.mapper.foodMapper.selectSellerFood", foodNo);

		} finally {
			sqlSession.close();
		}
	}




	public FoodProFood selectFoodProFoodByProFoodNo(int proFoodNo) {
		sqlSession = getSqlSessionFactory().openSession();

		try {
			FoodProFood foodProFoodList = sqlSession.selectOne("repository.mapper.programMapper.selectFoodProFoodOneByProFoodNo", proFoodNo);

			return foodProFoodList;
		} finally {
			
			sqlSession.close();
		}
	}




	public Program selectProgramByProNo(int proNo) {
		// TODO Auto-generated method stub
		sqlSession = getSqlSessionFactory().openSession();

		try {
			Program program = sqlSession.selectOne("repository.mapper.programMapper.selectProgramByProNo", proNo);

			return program;
		} finally {
			
			sqlSession.close();
		}
		
	}
	
	

}
