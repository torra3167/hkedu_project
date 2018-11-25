package controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.CartOrderCommand;
import model.FoodOrderReceiver;
import model.FoodPay;
import service.PayService;


@Controller
public class PayController {
	
	
	@Autowired
	PayService payS;
	
	
	@RequestMapping(value="/pay_success.gom", method=RequestMethod.POST)
	public String paySuccess(FoodPay foodPay, @RequestParam(value="proFoodOrderReceiverNo", defaultValue="0")int proFoodOrderReceiverNo,  Model model, HttpSession session) {
		
		List cartList = (List)session.getAttribute("FoodOrderList");
		if(proFoodOrderReceiverNo != 0) {
			System.out.println("PAYSUCCESS proRECEIVERNO " + proFoodOrderReceiverNo);
			System.out.println("PAYSUCCESS foodRECEIVER NO " + foodPay.getFoodOrderReceiverNo());
			payS.proFoodPayInsert(foodPay, proFoodOrderReceiverNo, model, session);
		}
		
		if(cartList != null)  {
			payS.payInsert(foodPay, model,session);	

		}
		model.addAttribute("iPage", "pay/pay_success.jsp");
		return "index";
	}
	
	@RequestMapping(value="/food_order_list_insert.gom", method=RequestMethod.POST)
	public String foodOrderListInsert(FoodOrderReceiver foodOrderReceiver, @RequestParam(value="foodPayDivide") String foodPayDivide,  Model model, 
			  HttpSession session) {
		System.out.println("FOODORDER INSERT");
		System.out.println(foodPayDivide);
		//결제방법 세션저장
		session.setAttribute("FoodPayDivide", foodPayDivide);
		
		payS.insertOrderList(foodOrderReceiver, session, model);
		
		model.addAttribute("iPage", "pay/food_pay.jsp");
		return "index";
	}

	@RequestMapping(value="/food_order_list.gom", method=RequestMethod.POST)
	public String orderList(CartOrderCommand cartOrderCommand, FoodOrderReceiver foodOrderReceiver, /*@RequestParam(value="foodNo") String[] foodNo,*/  
			 Model model, HttpSession session) {
		System.out.println("PAY FOOD ORDER LIST");
		
	/*	System.out.println(foodNo + " FOODNO");
		System.out.println(foodNo[0]);
		for(int i = 0; i < foodNo.length; i++) {
			System.out.println("----------");
			System.out.println(i);
		}*/
		
		if(cartOrderCommand.getFoodNo() != null) {
		payS.orderList(cartOrderCommand.getFoodNo(), session, model);
		
		} else if(cartOrderCommand.getProFoodNo() != null) {
			payS.proFoodOrderList(cartOrderCommand.getProFoodNo(), session);
		}
		
		/*List cartList = (List)session.getAttribute("cartList");
		if(cartList == null) {
			cartList = new ArrayList();
			session.setAttribute("cartList", cartList);
			
		}*/
		model.addAttribute("iPage", "pay/food_order_list.jsp");
		return "index";
	}
}
