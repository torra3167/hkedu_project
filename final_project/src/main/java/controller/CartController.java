package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.CartService;


@Controller
public class CartController {
	
	@Autowired
	CartService cartS;
	
	@RequestMapping(value="/cart_remove.gom", method=RequestMethod.POST)
	public String removeCart(@RequestParam(value="foodName", defaultValue="false")String foodName, @RequestParam(value="delete", defaultValue="false")int[] foodNums, Model model, HttpServletRequest request ) {
		System.out.println("CART REMOVE");
		
		model.addAttribute("iPage", "pay/cart_list.jsp");
		
		cartS.cartRemove(request, model, foodNums);
		
		return "redirect:/index";
	}
	
	@RequestMapping(value="/cart_qty_down.gom", method=RequestMethod.GET)
	public String cartQtyDown(@RequestParam(value="foodName", defaultValue="false")String foodName, Model model, HttpServletRequest request ) {
		System.out.println("CART QTY DOWN");
		model.addAttribute("iPage", "pay/cart_list.jsp");
		cartS.cartQtyDown(request, model, foodName);
		
		return "redirect:/index";
	}
	
	@RequestMapping(value="/cart_qty_up.gom", method=RequestMethod.GET)
	public String cartQtyUp(@RequestParam(value="foodName", defaultValue="false")String foodName, Model model, HttpServletRequest request ) {
		System.out.println("CART QTY UP");

		model.addAttribute("iPage", "pay/cart_list.jsp");
		cartS.cartQtyUp(request, model, foodName);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/cart_list.gom", method=RequestMethod.POST)
	public String cartListSumbit(Model model, HttpServletRequest request ) {
		//삭제
		model.addAttribute("iPage", "pay/cart_list.jsp");
		
		return "index";
	}
	
	@RequestMapping(value="/cart_list.gom", method=RequestMethod.GET)
	public String cartList(Model model, HttpServletRequest request ) {
		
		model.addAttribute("iPage", "pay/cart_list.jsp");
		cartS.cartList(model, request);
		System.out.println("CART LIST");
		return "index";
	}
	
	/*@RequestMapping(value="/cart_addList.gom", method=RequestMethod.POST)
	public String cartFormSubmit(@RequestParam(value="foodNo")int foodNo, Model model, HttpServletRequest request ) {
		
		
		model.addAttribute("iPage", "pay/cart_list.jsp");
		return "index";
	}*/
	
	//FoodDetail에서 선택한 수량과 항목 장바구니에 추가
	@RequestMapping(value="/cart_addList.gom", method=RequestMethod.POST)
	public String cartFormSubmit(@RequestParam(value="foodNo", defaultValue="false")int foodNo, @RequestParam(value="demandQty", defaultValue="false")int demandQty,
			Model model, HttpServletRequest request, HttpServletResponse response ) {
		System.out.println("Cartadd list");
		System.out.println("FOODNO " + foodNo);
		System.out.println("demandQty " + demandQty);
		model.addAttribute("iPage", "pay/cart_list.jsp");
		cartS.cartAdd(model, foodNo, demandQty,  request, response);
		
		return "index";
	}
}

