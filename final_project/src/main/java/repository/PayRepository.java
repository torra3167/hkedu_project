package repository;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.Food;
import model.FoodOrder;
import model.FoodOrderReceiver;

@Repository
public class PayRepository extends AbstractRepository {
	SqlSession sqlSession;
	private final String namespace = "repository.mapper.payMapper";
	
	

	public List<Food> selectFoodCategoryByFoodNo(String[] foodNo) {
		sqlSession = getSqlSessionFactory().openSession();
		
		List<Food> foodCategories = new ArrayList<Food>();
		
		for (int i = 0; i < foodNo.length; i++) {
			
			Food food = sqlSession.selectOne(namespace + ".selectFoodCategoryByFoodNo", Integer.parseInt(foodNo[i]));
			foodCategories.add(food);

		}
		return foodCategories;

	}



	public void insertOrderList(List<FoodOrder> foodOrderList, FoodOrderReceiver foodOrderReceiver) {
		sqlSession = getSqlSessionFactory().openSession();

		Integer foodOrderResult = 0;
		for(Object temp : foodOrderList) {
			FoodOrder foodOrder = (FoodOrder)temp;
			sqlSession.insert(namespace + ".insertFoodOrder", foodOrder);
			foodOrderResult++;
		}
		System.out.println("FOOD ORDER RESULT " + foodOrderResult);
		
		Integer FoodOrderReceiverResult = (Integer)sqlSession.insert(namespace + ".insertFoodOrderReceiver", foodOrderReceiver);
		
		System.out.println("FoodOrderReceiverResult" + FoodOrderReceiverResult);
	}
	
	
	
	

}
