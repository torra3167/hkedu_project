package service;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import model.Cart;
import model.Food;
import model.FoodProFood;
import model.ProFoodCart;
import repository.CartRepository;

@Service
public class CartService {
	HttpSession session;

	@Autowired
	private CartRepository cartR;

	public void cartList(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		

		session = request.getSession();
		List cartList = (List) session.getAttribute("cartList");
		
		int money = 0;
		int foodTotalAmount = 0;
		if(cartList != null) {
			
		for(Object temp : cartList) {
			Cart cart = (Cart)temp;
			money = cart.getFoodPrice() * cart.getDemandQty();
			foodTotalAmount += money;
		}
		session.setAttribute("foodTotalAmount", foodTotalAmount);
		}
		
		session.setAttribute("cartList", cartList);
		

	}

	public void cartAdd(Model model, int foodNo, int demandQty, HttpServletRequest request,
			HttpServletResponse response) {
		session = request.getSession();
		Food food = cartR.selectSellerFood(foodNo);
		System.out.println("FOOD PRICE" + food.getFoodPrice());
		List cartList = (List) session.getAttribute("cartList");
		
		if (cartList == null) {
			cartList = new ArrayList();
		}

	

		// 상품정보 및 수량을 임시로 저장하기 위한 클래스

		Cart firstCart = null;
		boolean newCart = true;

		for (int i = 0; i < cartList.size(); i++) {
			firstCart = (Cart) cartList.get(i);

			if (food.getFoodName().equals(firstCart.getFoodName())) {
				newCart = false;
				firstCart.setDemandQty(firstCart.getDemandQty() + demandQty);
			}

			 
		}
		
		if (newCart) {
			// 푸드번호,이름,가격,이미지,QTY
			System.out.println("SELLER EMAIL" + food.getSellerEmail());
			firstCart = new Cart(food.getFoodNo(), food.getSellerEmail(), food.getFoodCatANo(), food.getFoodCatBNo(), food.getFoodCatCNo(),
						food.getFoodName(), food.getFoodPrice(), food.getFoodStored(), demandQty);
			
			cartList.add(firstCart);

		}
		
		int money = 0;
		int foodTotalAmount = 0;

		for(Object temp : cartList) {
			Cart cart = (Cart)temp;
			money = cart.getFoodPrice() * cart.getDemandQty();
			foodTotalAmount += money;
		}
		session.setAttribute("foodTotalAmount", foodTotalAmount);
		
		session.setAttribute("cartList", cartList);

	}

	public void cartQtyUp(HttpServletRequest request, Model model, String foodName) {
		// TODO Auto-generated method stub
		session = request.getSession();

		List cartList = (List) session.getAttribute("cartList");

		for (int i = 0; i < cartList.size(); i++) {
			Cart cart = (Cart) cartList.get(i);
			System.out.println(cart.getDemandQty() + "aaaa");
			if (cart.getFoodName().equals(foodName)) {
				cart.setDemandQty(cart.getDemandQty() + 1);
			}
		}

		session.setAttribute("cartList", cartList);
	}

	public void cartQtyDown(HttpServletRequest request, Model model, String foodName) {
		// TODO Auto-generated method stub
		session = request.getSession();

		List cartList = (List) session.getAttribute("cartList");

		for (int i = 0; i < cartList.size(); i++) {
			Cart cart = (Cart) cartList.get(i);

			if (cart.getFoodName().equals(foodName)) {

				if (cart.getDemandQty() > 1) {
					cart.setDemandQty(cart.getDemandQty() - 1);
				}

			}
		}

		session.setAttribute("cartList", cartList);
	}

	public void cartRemove(@ModelAttribute HttpServletRequest request, Model model, String[] foodNums) {
		session = request.getSession();
		List list = (List) session.getAttribute("cartList");

		for (int i = 0; i < foodNums.length; i++) {
			for (int j = 0; j < list.size(); j++) {
				Cart cart = (Cart) list.get(j);
				if (Integer.parseInt(foodNums[i]) == cart.getFoodNo()) {
					System.out.println("식품번호 " + cart.getFoodNo() + " 제거되었습니다");
					list.remove(list.get(j));
				}
			}
		}
		
		session.setAttribute("cartList", list);

	}

	public void proFoodCartAdd(HttpServletRequest request, HttpServletResponse response, ProFoodCart proFoodCart) {
		
		session = request.getSession();
		FoodProFood foodProFood = cartR.selectFoodProFoodByProFoodNo(proFoodCart.getProFoodNo());
		
		List proFoodCartList = (List) session.getAttribute("proFoodCartList");
		
		if(proFoodCartList == null) {
			proFoodCartList = new ArrayList();
		}
		
		ProFoodCart firstProFoodCart = null;
		boolean newProFoodCart = true;
		
		for(Object temp : proFoodCartList) {
			firstProFoodCart = (ProFoodCart)temp;
			
			if(foodProFood.getFoodName().equals(firstProFoodCart.getFoodName())) {
				newProFoodCart = false;
				firstProFoodCart.setDemandQty(firstProFoodCart.getDemandQty() + proFoodCart.getDemandQty());
				
			}
		}
		
		if(newProFoodCart) {
			firstProFoodCart = new ProFoodCart(foodProFood.getProFoodNo(), foodProFood.getFoodNo(),
					foodProFood.getSellerEmail(), foodProFood.getFoodCatANo(), foodProFood.getFoodCatBNo(),
					foodProFood.getFoodCatCNo(), foodProFood.getProNo(), foodProFood.getCoachEmail(), 
					foodProFood.getFoodName(), foodProFood.getFoodPrice(), foodProFood.getFoodStored(),
					proFoodCart.getDemandQty());
			
			proFoodCartList.add(firstProFoodCart);
		}
		
		int proFoodMoney = 0;
		int proFoodSum = 0;
		
		for(Object temp : proFoodCartList) {
			ProFoodCart cart = (ProFoodCart)temp;
			proFoodMoney = cart.getFoodPrice() * cart.getDemandQty();
			proFoodSum += proFoodMoney;
		}
		
		session.setAttribute("proFoodSum", proFoodSum);
		session.setAttribute("proFoodCartList", proFoodCartList);
	}

	public void proCartQtyUp(HttpServletRequest request, Model model, String foodName) {
		session = request.getSession();

		List proFoodCartList = (List) session.getAttribute("proFoodCartList");

		for (int i = 0; i < proFoodCartList.size(); i++) {
			ProFoodCart proCart = (ProFoodCart) proFoodCartList.get(i);
			
			if (proCart.getFoodName().equals(foodName)) {
				proCart.setDemandQty(proCart.getDemandQty() + 1);
			}
		}

		session.setAttribute("proFoodCartList", proFoodCartList);
		
	}

	public void proCartQtyDown(HttpServletRequest request, Model model, String foodName) {
		session = request.getSession();

		List proFoodCartList = (List) session.getAttribute("proFoodCartList");

		for (int i = 0; i < proFoodCartList.size(); i++) {
			ProFoodCart proCart = (ProFoodCart) proFoodCartList.get(i);

			if (proCart.getFoodName().equals(foodName)) {

				if (proCart.getDemandQty() > 1) {
					proCart.setDemandQty(proCart.getDemandQty() - 1);
				}

			}
		}

		session.setAttribute("proFoodCartList", proFoodCartList);
		
	}

	public void proCartRemove(HttpServletRequest request, Model model, String[] foodNums) {
		// TODO Auto-generated method stub
		session = request.getSession();
		List proFoodCartList = (List) session.getAttribute("proFoodCartList");

		for (int i = 0; i < foodNums.length; i++) {
			for (int j = 0; j < proFoodCartList.size(); j++) {
				ProFoodCart proCart = (ProFoodCart) proFoodCartList.get(j);
				if (Integer.parseInt(foodNums[i]) == proCart.getProFoodNo()) {
					System.out.println("프로그램 식품번호 " + proCart.getProFoodNo() + " 제거되었습니다");
					proFoodCartList.remove(proFoodCartList.get(j));
					
				}
			}
		}
		
		session.setAttribute("proFoodCartList", proFoodCartList);
	}

}
