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
import model.ProFoodCart;
import model.ProFoodOrder;
import model.ProFoodOrderReceiver;
import model.ProFoodPay;
import model.ProOrder;
import model.ProPay;
import repository.PayRepository;

@Service
public class PayService {
	Cart cart;
	ProFoodCart proFoodCart;
	Food food;
	List cartList;
	FoodOrder foodOrder;
	ProFoodOrder proFoodOrder;
	FoodOrderReceiver foodOrderReceiver;
	
	@Autowired
	private PayRepository payR;

	public void orderList(String[] foodNo, HttpSession session) {
		
		
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
		
		if(foodOrderList != null) { 
//		foodOrderReceiver.setMemberEmail(foodOrderReceiver.getMemberEmail());
		
		
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
		
		List<ProFoodOrder> proFoodOrderList = (List<ProFoodOrder>)session.getAttribute("proFoodOrderList");
		
		if(proFoodOrderList != null) {	
				
				String memberEmail = (String)session.getAttribute("email");
				//
				ProFoodOrderReceiver proFoodOrderReceiver = new ProFoodOrderReceiver(
						memberEmail, foodOrderReceiver.getFoodOrderReceiverName(), foodOrderReceiver.getFoodOrderReceiverPhone(), 
						foodOrderReceiver.getFoodOrderReceiverAddr1(), foodOrderReceiver.getFoodOrderReceiverAddr2(),
						foodOrderReceiver.getFoodOrderReceiverAddrno(), foodOrderReceiver.getFoodOrderReceiverTotal());
				
				Integer proFoodOrderReceiverNumber = payR.insertProFoodOrderList(proFoodOrderList, proFoodOrderReceiver);
				
				if(proFoodOrderReceiverNumber > 0) {
					model.addAttribute("ProFoodOrderReceiverNumber", proFoodOrderReceiverNumber);
					model.addAttribute("ProFoodOrderReceiverTotal", proFoodOrderReceiver.getProFoodOrderReceiverTotal());
					
				} else {
					System.out.println("운동식품주문 INSERT 실패");
				}
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



	public void proFoodOrderList(String[] proFoodNo, HttpSession session) {
		List proFoodCartList = (List)session.getAttribute("proFoodCartList");
		
		
		List<ProFoodCart> selectedProCartList = new ArrayList<ProFoodCart>();
		//식품주문리스트생성
		
		proFoodOrder = new ProFoodOrder();
		
		//장바구니에서 선택한 물품들을 새로운 카트리스트에 저장.
		for(int i = 0 ; i < proFoodCartList.size(); i++) {
			proFoodCart = (ProFoodCart)proFoodCartList.get(i);
			for(int j = 0; j < proFoodNo.length ;j++) {
				if(proFoodCart.getProFoodNo()==Integer.parseInt(proFoodNo[j])) {
					
					//푸드넘버, 이름, 가격, 이미지, qty
					ProFoodCart selectedCart = new ProFoodCart(proFoodCart.getProFoodNo(), proFoodCart.getFoodNo(), proFoodCart.getSellerEmail(),
							proFoodCart.getFoodCatANo(), proFoodCart.getFoodCatBNo(), proFoodCart.getFoodCatCNo(), proFoodCart.getProNo(),
							proFoodCart.getCoachEmail(), proFoodCart.getFoodName(), proFoodCart.getFoodPrice(), proFoodCart.getFoodImage(), proFoodCart.getDemandQty());
					
					//식품주문
					
					selectedProCartList.add(selectedCart);
					
			
					
					
				}
			}
			
		}
		//장바구니에서 선택한 물품들을 장바구니 항목에서 제거.
		
		for(int i = 0; i < proFoodNo.length; i++) {
			for(int j = 0; j < proFoodCartList.size(); j++) {
				proFoodCart = (ProFoodCart)proFoodCartList.get(j);
				if(Integer.parseInt(proFoodNo[i]) == proFoodCart.getProFoodNo()) {
					proFoodCartList.remove(proFoodCartList.get(j));
				}
			}
		}
		//장바구니세션 다시저장
		session.setAttribute("proFoodCartList", proFoodCartList);
		
		
		//선택한카트리스트에서 총금액계산
		
		int money  = 0;
		int selectedTotalMoney = 0;
		for(Object temp : selectedProCartList) {
			proFoodCart = (ProFoodCart)temp;
			money = proFoodCart.getFoodPrice() * proFoodCart.getDemandQty();
			selectedTotalMoney += money;
		}
		
		
		//-------------------------
		String memberEmail = (String)session.getAttribute("email");
		
		System.out.println("memberEmail" + memberEmail);
		List<ProFoodOrder> proFoodOrderList = new ArrayList<ProFoodOrder>();
		
		
		for(Object temp : selectedProCartList) {
			ProFoodCart proFoodCart = (ProFoodCart)temp;
			proFoodOrder = new ProFoodOrder(proFoodCart.getProFoodNo(), proFoodCart.getFoodNo(), 
					proFoodCart.getSellerEmail(), memberEmail, proFoodCart.getFoodCatANo(),
					proFoodCart.getFoodCatBNo(), proFoodCart.getFoodCatCNo(), proFoodCart.getProNo(),
					proFoodCart.getCoachEmail(), proFoodCart.getFoodPrice(), proFoodCart.getDemandQty(), 
					proFoodCart.getFoodName(), proFoodCart.getFoodImage());
			
			proFoodOrderList.add(proFoodOrder);
			
			System.out.println("PRO FOOD ORDER   " + proFoodOrder);
		}
		
		session.setAttribute("proFoodOrderList", proFoodOrderList);
		
	}



	public void proFoodPayInsert(FoodPay foodPay, int proFoodOrderReceiverNo, Model model, HttpSession session) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        String regDate = sdf.format(Calendar.getInstance().getTime());
		
        ProFoodPay proFoodPay = new ProFoodPay(foodPay.getMemberEmail(), proFoodOrderReceiverNo,
        		foodPay.getFoodPayPrice(), (String)session.getAttribute("FoodPayDivide"),
        		foodPay.getFoodPayCardNo(), foodPay.getFoodPayCardM(), foodPay.getFoodPayCardY(),
        		foodPay.getFoodPayCardCvc(), regDate);
        
		Integer proFoodPayInsertResult = payR.proFoodPayInsert(proFoodPay);
		
		if(proFoodPayInsertResult > 0) {
			System.out.println("PRO FOOD PAY INSERT 성공");
		} else {
			System.out.println("PRO FOOD PAY INSERT 실패");
		}
	}



	public void programFoodOrderList(String[] proNo, HttpSession session) {
		List programCartList = (List)session.getAttribute("programCartList");
		
		System.out.println("PROGRAMFOODORDERLIST !!!!!");
	
		Cart selectedCart = null;
		
		//장바구니에서 선택한 물품들을 새로운 카트리스트에 저장.
		for(int i = 0 ; i < programCartList.size(); i++) {
			cart = (Cart)programCartList.get(i);
			for(int j = 0; j < proNo.length ;j++) {
				if(cart.getProNo()==Integer.parseInt(proNo[j])) {
					
					
					selectedCart = new Cart(cart.getProNo(), cart.getCoachEmail(), cart.getProName(), cart.getProStored(),
							cart.getProContent(), cart.getProPrice());
					
					System.out.println(cart.getProPrice() + "   ~~~~~~PRO PRICE");

					
				}
			}
		System.out.println("CART NULL? " + selectedCart);	
		}
		//장바구니에서 선택한 물품들을 장바구니 항목에서 제거.
		
		for(int i = 0; i < proNo.length; i++) {
			for(int j = 0; j < programCartList.size(); j++) {
				cart = (Cart)programCartList.get(j);
				if(Integer.parseInt(proNo[i]) == cart.getProNo()) {
					programCartList.remove(programCartList.get(j));
				}
			}
		}
		//장바구니세션 다시저장
		session.setAttribute("programCartList", programCartList);
		
		
		
		//-------------------------
		String memberEmail = (String)session.getAttribute("email");
		
		System.out.println("memberEmail" + memberEmail);
		
		//이메일 proNo, coachEmail, orderName, total, image
		 ProOrder proOrder = new ProOrder(memberEmail, cart.getProNo(), cart.getCoachEmail(), 
				 cart.getProName(), cart.getProPrice(), cart.getProStored());
		
		System.out.println(cart.getFoodPrice() + "  PRO ORDER PRICE");
		
		
			session.setAttribute("proOrder", proOrder);

		

		
	}



	public void insertProOrder(ProOrder proOrderCommand, HttpSession session) {
		
		
        ProOrder proOrder = (ProOrder)session.getAttribute("proOrder");
        
        proOrder.setProOrderTotal(proOrderCommand.getProOrderTotal());
        
        Integer proOrderResult = payR.insertProOrder(proOrder);
		
		if(proOrderResult < 1) {
			System.out.println("PRO ORDER 등록실패");

		}
      
		
	
	}

	public void programPayInsert(ProPay proPay, Model model, HttpSession session) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
        String regDate = sdf.format(Calendar.getInstance().getTime());
        proPay.setProPayDate(regDate);
		
        ProOrder proOrder = (ProOrder)session.getAttribute("proOrder");
        
        proPay.setCoachEmail(proOrder.getCoachEmail());
        proPay.setProPayDivide((String)session.getAttribute("FoodPayDivide"));
        
		Integer programPayInsertResult = payR.programPayInsert(proPay);
		if(programPayInsertResult > 0) {
			System.out.println("PAY INSERT 성공");
		} else {
			System.out.println("PAY INSERT 실패");
		}
	}
}
