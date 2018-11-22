package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import model.Cart;
import model.Food;
import model.FoodOrder;
import model.FoodOrderReceiver;
import model.FoodPay;
import repository.PayRepository;

@Service
public class PayService {
	Cart cart;
	Food food;
	List cartList;
	FoodOrder foodOrder;
	FoodOrderReceiver foodOrderReceiver;
	
	@Autowired
	private PayRepository payR;

	public void orderList(String[] foodNo, HttpSession session, Model model) {
		
		
		cartList = (List)session.getAttribute("cartList");
		
		
		List<Cart> selectedCartList = new ArrayList<Cart>();
		//식품주문리스트생성
		
		foodOrder = new FoodOrder();
		
		//장바구니에서 선택한 물품들을 새로운 카트리스트에 저장.
		for(int i = 0 ; i < cartList.size(); i++) {
			cart = (Cart)cartList.get(i);
			for(int j = 0; j < foodNo.length ;j++) {
				if(cart.getFoodNo()==Integer.parseInt(foodNo[j])) {
					
					//푸드넘버, 이름, 가격, 이미지, qty
					Cart selectedCart = new Cart(cart.getFoodNo(), cart.getSellerEmail(), cart.getFoodCatANo(), cart.getFoodCatBNo(), cart.getFoodCatCNo(),
							cart.getFoodName(), cart.getFoodPrice(), cart.getFoodImage(), cart.getDemandQty());
					
					//식품주문
					
					selectedCartList.add(selectedCart);
					
					/*cartList.remove(cartList.get(i));
					System.out.println("cartList REMOVE " + i);*/
					
					
					
				}
			}
			
		}
		//장바구니에서 선택한 물품들을 장바구니 항목에서 제거.
		
		for(int i = 0; i < foodNo.length; i++) {
			for(int j = 0; j < cartList.size(); j++) {
				cart = (Cart)cartList.get(j);
				if(Integer.parseInt(foodNo[i]) == cart.getFoodNo()) {
					cartList.remove(cartList.get(j));
				}
			}
		}
		//장바구니세션 다시저장
		session.setAttribute("cartList", cartList);
		
		
		//선택한카트리스트에서 총금액계산
		
		int money  = 0;
		int selectedTotalMoney = 0;
		for(Object temp : selectedCartList) {
			cart = (Cart)temp;
			money = cart.getFoodPrice() * cart.getDemandQty();
			selectedTotalMoney += money;
		}
		
		
		//-------------------------
		String memberEmail = (String)session.getAttribute("email");
		
		System.out.println("memberEmail" + memberEmail);
		List<FoodOrder> foodOrderList = new ArrayList<FoodOrder>();
		
		
		for(Object temp : selectedCartList) {
			Cart cart = (Cart)temp;
			//구매자이메일,식품번호,판매자이메일, 카테고리A,카테고리B,카테고리C, 가격, 갯수,식품이름, 이미지
			foodOrder = new FoodOrder(memberEmail, cart.getFoodNo(), cart.getSellerEmail(), cart.getFoodCatANo(),
					cart.getFoodCatBNo(), cart.getFoodCatCNo(), cart.getFoodPrice(), cart.getDemandQty(),
					cart.getFoodName(), cart.getFoodImage());
			
			foodOrderList.add(foodOrder);
			
			System.out.println("FOOD ORDER   " + foodOrder);
		}
//		System.out.println("FOODORDERLIST    " + foodOrderList);
		
		session.setAttribute("FoodOrderList", foodOrderList);
		
		
	}

	
	
	public void insertOrderList(FoodOrderReceiver foodOrderReceiver, HttpSession session, Model model) {
		// TODO Auto-generated method stub
		
		List<FoodOrder> foodOrderList = (List<FoodOrder>)session.getAttribute("FoodOrderList");
		foodOrderReceiver.setMemberEmail(foodOrderReceiver.getMemberEmail());
		
		
		String memberEmail = (String)session.getAttribute("email");
		//
		foodOrderReceiver.setMemberEmail(memberEmail);
		
		Integer foodOrderReceiverNumber = payR.insertOrderList(foodOrderList, foodOrderReceiver);
		
		if(foodOrderReceiverNumber > 0) {
			model.addAttribute("FoodOrderReceiverNumber", foodOrderReceiverNumber);
			model.addAttribute("FoodOrderReceiverTotal", foodOrderReceiver.getFoodOrderReceiverTotal());
			
		} else {
			System.out.println("식품주문 INSERT 실패");
		}
		
		
		
		
		
		
	}
	
	public void payInsert(FoodPay foodPay, Model model, HttpSession session) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        String regDate = sdf.format(Calendar.getInstance().getTime());
		foodPay.setFoodPayDate(regDate);
		
		foodPay.setFoodPayDivide((String)session.getAttribute("FoodPayDivide"));
		Integer payInsertResult = payR.payInsert(foodPay);
		
		if(payInsertResult > 0) {
			System.out.println("PAY INSERT 성공");
		} else {
			System.out.println("PAY INSERT 실패");
		}
	}
}
