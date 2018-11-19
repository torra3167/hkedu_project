package service;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
		
		for(Object temp : cartList) {
			Cart cart = (Cart)temp;
			money = cart.getFoodPrice() * cart.getDemandQty();
			foodTotalAmount += money;
		}
		session.setAttribute("foodTotalAmount", foodTotalAmount);
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

		/*
		 * if(cart != null) { for(Object temp : cartList) { Cart cart = (Cart)temp;
		 * if(cart.getFoodNo() == foodNo) { } } }
		 */

		// 상품정보 및 수량을 임시로 저장하기 위한 클래스

		Cart firstCart = null;
		boolean newCart = true;

		for (int i = 0; i < cartList.size(); i++) {
			firstCart = (Cart) cartList.get(i);

			if (food.getFoodName().equals(firstCart.getFoodName())) {
				newCart = false;
				firstCart.setDemandQty(firstCart.getDemandQty() + demandQty);
			}

			/*
			 * if(cart.getFoodNo() == foodNo) { try { request.setCharacterEncoding("utf-8");
			 * response.setContentType("text/html;charset=utf-8"); PrintWriter pw =
			 * response.getWriter(); pw.println("<script>");
			 * pw.println("alert('이미 장바구니에 담겨있는 상품입니다.')");
			 * pw.println("location.href='index'"); pw.println("</script>"); pw.close(); }
			 * catch (Exception e) { e.printStackTrace(); }
			 * 
			 * }
			 
		}

		if (newCart) {
			// 푸드번호,이름,가격,이미지,QTY

			firstCart = new Cart(food.getFoodNo(), food.getFoodName(), food.getFoodPrice(), food.getFoodStored(), demandQty);

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

	public void cartRemove(@ModelAttribute HttpServletRequest request, Model model, int[] foodNums) {
		session = request.getSession();
		List list = (List) session.getAttribute("cartList");

		for (int i = 0; i < foodNums.length; i++) {
			for (int j = 0; j < list.size(); j++) {
				Cart cart = (Cart) list.get(j);
				if (foodNums[i] == cart.getFoodNo()) {
					System.out.println("식품번호 " + cart.getFoodNo() + " 제거되었습니다");
					list.remove(list.get(j));
					
				}
			}
		}
		
		session.setAttribute("cartList", list);

	}

}
