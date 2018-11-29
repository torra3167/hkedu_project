package repository;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import model.Food;
import model.FoodOrder;
import model.FoodOrderReceiver;
import model.FoodPay;
import model.ProFoodOrder;
import model.ProFoodOrderReceiver;
import model.ProFoodPay;
import model.ProOrder;
import model.ProPay;

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
		Integer foodOrderReceiverResult = (Integer)sqlSession.insert(namespace + ".insertFoodOrderReceiver", foodOrderReceiver);
		System.out.println("FoodOrderReceiverResult" + foodOrderReceiverResult);
		
		
		//식품주문정보 인서트
		Integer foodOrderResult = 0;
		for(Object temp : foodOrderList) {
			FoodOrder foodOrder = (FoodOrder)temp;
			foodOrder.setFoodOrderReceiverNo(foodOrderReceiverNumber);
			sqlSession.insert(namespace + ".insertFoodOrder", foodOrder);
			foodOrderResult++;
		}
		
		if(foodOrderResult > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		System.out.println("FOOD ORDER RESULT " + foodOrderResult);
		
		return foodOrderReceiverNumber;
		
	}



	public Integer payInsert(FoodPay foodPay) {
		
		sqlSession = getSqlSessionFactory().openSession();
		//번호를 위한 select
		Integer foodPayNumber = (Integer)sqlSession.selectOne(namespace + ".selectSequenceNumber");
		System.out.println("FOODPAY SEQUENCE NUMBER" + foodPayNumber);
		foodPay.setFoodPayNo(foodPayNumber);
		
		Integer payInsertResult =  (Integer)sqlSession.insert(namespace + ".payInsert", foodPay);
		
		if(payInsertResult > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return payInsertResult;
	}



	public Integer insertProFoodOrderList(List<ProFoodOrder> proFoodOrderList,
			ProFoodOrderReceiver proFoodOrderReceiver) {
		sqlSession = getSqlSessionFactory().openSession();
		
		//주문번호를 위한 select
		Integer proFoodOrderReceiverNumber = (Integer)sqlSession.selectOne(namespace + ".selectSequenceNumber");
		
		System.out.println("식품주문번호 " + proFoodOrderReceiverNumber);

		//운동식품수취인정보 인서트
		
		proFoodOrderReceiver.setProFoodOrderReceiverNo(proFoodOrderReceiverNumber);
		
		Integer proFoodOrderReceiverResult = (Integer)sqlSession.insert(namespace + ".insertProFoodOrderReceiver", proFoodOrderReceiver);
		System.out.println("proFoodOrderReceiverResult " + proFoodOrderReceiverResult);
		

		//운동식품주문정보 인서트
		Integer proFoodOrderResult = 0;
		for(Object temp : proFoodOrderList) {
			
			ProFoodOrder proFoodOrder = (ProFoodOrder)temp;
			System.out.println(proFoodOrder.getCoachEmail() + " ~~~ COACHEMAIL");
			proFoodOrder.setProFoodOrderReceiverNo(proFoodOrderReceiverNumber);
			sqlSession.insert(namespace + ".insertProFoodOrder", proFoodOrder);
			proFoodOrderResult++;
		}
		
		if(proFoodOrderResult > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		System.out.println("PRO FOOD ORDER RESULT " + proFoodOrderResult);
		
		return proFoodOrderResult;
	}



	



	public Integer proFoodPayInsert(ProFoodPay proFoodPay) {
		sqlSession = getSqlSessionFactory().openSession();
		//번호를 위한 select
		Integer proFoodPayNumber = (Integer)sqlSession.selectOne(namespace + ".selectSequenceNumber");
		System.out.println("PRO FOODPAY SEQUENCE NUMBER" + proFoodPayNumber);
		proFoodPay.setProFoodPayNo(proFoodPayNumber);
		
		Integer proPayInsertResult =  (Integer)sqlSession.insert(namespace + ".proFoodPayInsert", proFoodPay);
		
		if(proPayInsertResult > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return proPayInsertResult;
	}



	public Integer insertProOrder(ProOrder proOrder) {
		sqlSession = getSqlSessionFactory().openSession();
		//번호를 위한 select
		Integer proOrderNumber = (Integer)sqlSession.selectOne(namespace + ".selectSequenceNumber");
		System.out.println("proOrderNumber SEQUENCE NUMBER" + proOrderNumber);
		proOrder.setProOrderNo(proOrderNumber);
		
		Integer proOrderInsertResult =  (Integer)sqlSession.insert(namespace + ".insertProOrder", proOrder);
		
		if(proOrderInsertResult > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return proOrderInsertResult;
	}



	public Integer programPayInsert(ProPay proPay) {
		sqlSession = getSqlSessionFactory().openSession();
		//번호를 위한 select
		Integer proPayNumber = (Integer)sqlSession.selectOne(namespace + ".selectSequenceNumber");
		System.out.println("proPayNumber SEQUENCE NUMBER" + proPayNumber);
		proPay.setProPayNo(proPayNumber);
		
		Integer programPayInsertResult =  (Integer)sqlSession.insert(namespace + ".programPayInsert", proPay);
		
		if(programPayInsertResult > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return programPayInsertResult;
	}
	
	
	
	

}
