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
import model.ProOrder;
import model.ProPay;
import service.PayService;


@Controller
public class PayController {
	
	
	@Autowired
	PayService payS;
	
	
	@RequestMapping(value="/program_pay_success.gom", method=RequestMethod.POST)
	public String programPaySuccess(ProPay proPay, Model model, HttpSession session) {
		
		
		
		
			payS.programPayInsert(proPay, model,session);	

		
		model.addAttribute("iPage", "pay/pay_success.jsp");
		return "index";
	}
	
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
	
	
	@RequestMapping(value="/pro_order_list_insert.gom", method=RequestMethod.POST)
	public String proOrderListInsert(ProOrder proOrder, @RequestParam(value="foodPayDivide") String foodPayDivide,  Model model, 
			  HttpSession session) {

	
		
		//결제방법 세션저장
		session.setAttribute("FoodPayDivide", foodPayDivide);
		
		payS.insertProOrder(proOrder, session);
		
		model.addAttribute("iPage", "pay/progarm_pay.jsp");
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
	
	@RequestMapping(value="/program_food_order_list.gom", method=RequestMethod.POST)
	public String proOrderList(CartOrderCommand cartOrderCommand, FoodOrderReceiver foodOrderReceiver, /*@RequestParam(value="foodNo") String[] foodNo,*/  
			 Model model, HttpSession session) {
		System.out.println("PAY FOOD ORDER LIST~~~~~~!!!!!!!!!");
		
	

		 if (cartOrderCommand.getProNo() != null) {
			payS.programFoodOrderList(cartOrderCommand.getProNo(), session);
			model.addAttribute("iPage", "pay/program_order.jsp");

		}
		
		
		return "index";
	}
	
	@RequestMapping(value="/food_order_list.gom", method=RequestMethod.POST)
	public String orderList(CartOrderCommand cartOrderCommand, FoodOrderReceiver foodOrderReceiver, /*@RequestParam(value="foodNo") String[] foodNo,*/  
			 Model model, HttpSession session) {
		System.out.println("PAY FOOD ORDER LIST");
		
	
		if (cartOrderCommand.getFoodNo() != null) {
			payS.orderList(cartOrderCommand.getFoodNo(), session);
			model.addAttribute("iPage", "pay/food_order_list.jsp");

		} else if (cartOrderCommand.getProFoodNo() != null) {
			payS.proFoodOrderList(cartOrderCommand.getProFoodNo(), session);
			model.addAttribute("iPage", "pay/food_order_list.jsp");

	

		}
		
		
		return "index";
	}
}
