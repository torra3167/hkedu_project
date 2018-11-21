package repository;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.Food;
import model.FoodOrder;
import model.FoodOrderReceiver;
import model.FoodPay;

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



	public Integer insertOrderList(List<FoodOrder> foodOrderList, FoodOrderReceiver foodOrderReceiver) {
		sqlSession = getSqlSessionFactory().openSession();
		//식품주문번호를 위한 select
		Integer foodOrderReceiverNumber = (Integer)sqlSession.selectOne(namespace + ".selectSequenceNumber");
		
		System.out.println("식품주문번호 " + foodOrderReceiverNumber);

		//식품수취인정보 인서트
		
		foodOrderReceiver.setFoodOrderReceiverNo(foodOrderReceiverNumber);
		
		Integer FoodOrderReceiverResult = (Integer)sqlSession.insert(namespace + ".insertFoodOrderReceiver", foodOrderReceiver);
		System.out.println("FoodOrderReceiverResult" + FoodOrderReceiverResult);

		//식품주문정보 인서트
		Integer foodOrderResult = 0;
		for(Object temp : foodOrderList) {
			FoodOrder foodOrder = (FoodOrder)temp;
			foodOrder.setFoodOrderReceiverNo(foodOrderReceiverNumber);
			sqlSession.insert(namespace + ".insertFoodOrder", foodOrder);
			foodOrderResult++;
		}
		System.out.println("FOOD ORDER RESULT " + foodOrderResult);
		
		return foodOrderReceiverNumber;
		
	}



	public Integer payInsert(FoodPay foodPay) {
		
		sqlSession = getSqlSessionFactory().openSession();
		//번호를 위한 select
		Integer foodPayNumber = (Integer)sqlSession.selectOne(namespace + ".selectSequenceNumber");
		
		foodPay.setFoodPayNo(foodPayNumber);
		
		sqlSession.insert(namespace + ".payInsert", foodPay);
		
		return null;
	}
	
	
	
	

}
