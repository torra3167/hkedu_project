package controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.FoodOrderReceiver;
import model.FoodPay;
import service.PayService;


@Controller
public class PayController {
	
	
	@Autowired
	PayService payS;
	
	
	@RequestMapping(value="/pay_success.gom", method=RequestMethod.POST)
	public String paySuccess(FoodPay foodPay, Model model, HttpSession session) {
		
		payS.payInsert(foodPay, model,session);	
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
	public String orderList(FoodOrderReceiver foodOrderReceiver, @RequestParam(value="foodNo") String[] foodNo, /*@RequestParam(value="foodQuant") String[] foodQuant,*/ 
			 Model model, HttpSession session) {
		System.out.println("PAY FOOD ORDER LIST");
		
	/*	System.out.println(foodNo + " FOODNO");
		System.out.println(foodNo[0]);
		for(int i = 0; i < foodNo.length; i++) {
			System.out.println("----------");
			System.out.println(i);
		}*/
		
		
		payS.orderList(foodNo, session, model);
		
		
		model.addAttribute("iPage", "pay/food_order_list.jsp");
		return "index";
	}
}
