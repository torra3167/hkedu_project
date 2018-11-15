package controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import category.FoodCatC;
import command.SellerJoinCommand;
import command.SellerLoginCommand;
import command.SellerUpdateCommand;
import command.SellerWithdrawalCommand;
import model.AuthInfo;
import model.Seller;
import model.SellerAuthInfo;
import service.FoodService;
import service.SellerService;

@Controller
public class SellerController {
	
		@Autowired
		private SellerService sellerService;
		
		@Autowired
		private FoodService foodService;
		
		@RequestMapping(value="/seller_join.gom", method=RequestMethod.GET)
		public String joinForm(Model model) {
			model.addAttribute("iPage", "seller/seller_join.jsp");
			return "index";
		}
		
		@RequestMapping(value="/seller_join.gom", method=RequestMethod.POST)
		public String joinSubmit(SellerJoinCommand sellerJoinCommand,  Model model) { 
			Integer result = null;		
			result = sellerService.insertSeller(sellerJoinCommand);
			if(result>0) {
				model.addAttribute("result", result);
				return "index";
			}else {
				return "redirect:/index";
			}
		}
		
		
		@RequestMapping(value="/seller_update.gom", method=RequestMethod.GET)
		public String updateForm(SellerUpdateCommand sellerUpdateCommand, Model model, HttpSession session) {
			AuthInfo ai = (AuthInfo) session.getAttribute("email");
			model.addAttribute("email", ai);
			model.addAttribute("iPage", "seller/seller_update.jsp");
			return "index";
		}
		
		
		@RequestMapping(value="/seller_update.gom", method=RequestMethod.POST)
		public String updateSubmit(SellerUpdateCommand sellerUpdateCommand, HttpServletRequest httpServletRequest,  Model model) {
			System.out.println("controller form에서 온 httpServletRequest" + httpServletRequest.getParameter("sellerEmail"));
			sellerUpdateCommand.setSellerEmail(httpServletRequest.getParameter("sellerEmail"));
			sellerUpdateCommand.setSellerPw(httpServletRequest.getParameter("sellerPw"));
			sellerUpdateCommand.setSellerPhone(httpServletRequest.getParameter("sellerPhone"));
			Integer result = sellerService.updateSeller(sellerUpdateCommand);
			
			if(result>0) {
				model.addAttribute("result", result);
				return "index";
			}else {
				return "redirect:/index";
			}
		}
		
		@RequestMapping(value="/seller_menu.gom", method=RequestMethod.GET)
		public String sellerMenu(Model model, HttpSession session) {
			model.addAttribute("iPage", "seller/seller_menu.jsp");
			//foodReg cate list
			List<FoodCatC> list = foodService.dominoSelectC(model);
			model.addAttribute("foodCat", list);
			
			//seller_foodList
			String sellerEmail = (String) session.getAttribute("email");
			foodService.sellerFoodList(model, sellerEmail);
			
			return "index";
		}
		
		
		@RequestMapping(value="/seller_withdrawal.gom", method=RequestMethod.GET)
		public String sellerWithdrawalForm(SellerWithdrawalCommand sellerWithdrawalCommand, Model model, HttpSession session) {
			AuthInfo ai = (AuthInfo) session.getAttribute("AuthInfo");
			model.addAttribute("ai", ai);
			model.addAttribute("iPage", "seller/seller_withdrawal.jsp");
			return "index";
		}
		
		@RequestMapping(value="/seller_withdrawal.gom", method=RequestMethod.POST)
		public String sellerWithdrawalSubmit(SellerWithdrawalCommand sellerWithdrawalCommand,  Model model, HttpServletRequest httpServletRequest) { 
			sellerWithdrawalCommand.setSellerEmail(httpServletRequest.getParameter("sellerEmail"));
			sellerWithdrawalCommand.setSellerPw(httpServletRequest.getParameter("sellerPw"));
			int result = sellerService.deleteSeller(sellerWithdrawalCommand);
			if(result>0) {
				model.addAttribute("result", result);
				return "index";
			}else {
				return "redirect:/index";
			}
		}
		
		
		@RequestMapping(value="/seller_application.gom", method=RequestMethod.GET)
		public String sellerApplicationForm(Model model) {
			model.addAttribute("iPage", "seller/seller_application.jsp");
			return "index";
		}
}
