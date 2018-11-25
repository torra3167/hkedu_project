package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.ProFoodCart;
import service.CartService;


@Controller
public class CartController {
	
	@Autowired
	CartService cartS;
	
	@RequestMapping(value="/pro_cart_remove.gom", method=RequestMethod.GET)
	public String proRemoveCart(@RequestParam(value="delete", defaultValue="false")String deleteValues, Model model, HttpServletRequest request ) {
		System.out.println("CART REMOVE");
		
		String[] foodNums = deleteValues.split("/"); 
		
		model.addAttribute("iPage", "pay/cart_list.jsp");
		
		cartS.proCartRemove(request, model, foodNums);
		
		return "redirect:/index";
	}
	
	@RequestMapping(value="/pro_cart_qty_down.gom", method=RequestMethod.GET)
	public String proCartQtyDown(@RequestParam(value="foodName", defaultValue="false")String foodName, Model model, HttpServletRequest request ) {
		System.out.println("CART QTY DOWN");
		model.addAttribute("iPage", "pay/cart_list.jsp");
		cartS.proCartQtyDown(request, model, foodName);
		
		return "redirect:/index";
	}
	
	@RequestMapping(value="/pro_cart_qty_up.gom", method=RequestMethod.GET)
	public String proCartQtyUp(@RequestParam(value="foodName", defaultValue="false")String foodName, Model model, HttpServletRequest request ) {
		System.out.println("CART QTY UP");

		model.addAttribute("iPage", "pay/cart_list.jsp");
		cartS.proCartQtyUp(request, model, foodName);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/cart_remove.gom", method=RequestMethod.GET)
	public String removeCart(@RequestParam(value="delete", defaultValue="false")String deleteValues, Model model, HttpServletRequest request ) {
		System.out.println("CART REMOVE");
		
		String[] foodNums = deleteValues.split("/"); 
		
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
	
	//FoodDetail에서 선택한 수량과 항목 장바구니에 추가
	@RequestMapping(value="/cart_addList.gom", method=RequestMethod.POST)
	public String cartFormSubmit(ProFoodCart proFoodCart, @RequestParam(value="demandQty")int demandQty,
			Model model, HttpServletRequest request, HttpServletResponse response ) {
		/*System.out.println("Cartadd list");
		System.out.println("FOODNO " + foodNo);
		System.out.println("demandQty " + demandQty);*/
		
		model.addAttribute("iPage", "pay/cart_list.jsp");
		if(proFoodCart.getFoodNo() == 0) {
			cartS.proFoodCartAdd(request, response, proFoodCart);

		} else {
			cartS.cartAdd(model, proFoodCart.getFoodNo(), demandQty,  request, response);
		}

		return "index";
	}
}

