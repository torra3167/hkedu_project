package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import command.SellerJoinCommand;
import command.SellerLoginCommand;
import command.SellerUpdateCommand;
import model.AuthInfo;
import model.Seller;
import model.SellerAuthInfo;
import service.SellerService;

@Controller
public class SellerController {
	
		@Autowired
		private SellerService sellerService;
		
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
		
		/*
		@RequestMapping(value="/seller_login.gom", method=RequestMethod.GET)
		public String sellerLogin(SellerLoginCommand sellerLoginCommand, Model model, @CookieValue(value="coachEmail", required=false)Cookie rememberCookie) {
			if(rememberCookie != null) {
				sellerLoginCommand.setSellerEmail(rememberCookie.getValue());
				sellerLoginCommand.setRememberEmail(true);
			}
			model.addAttribute("sellerLoginCommand", new SellerLoginCommand());
			model.addAttribute("iPage", "seller/seller_login.jsp");
			return "index";
		}
		
		@RequestMapping(value="/seller_login.gom", method=RequestMethod.POST)
		public String sellerSubmit(SellerLoginCommand sellerLoginCommand, Model model, HttpSession session, HttpServletResponse response) {
			
			System.out.println("controller " + sellerLoginCommand.getSellerEmail() + "," + sellerLoginCommand.getSellerPw());
			
			SellerAuthInfo sai = sellerService.authenticate(sellerLoginCommand.getSellerEmail(), sellerLoginCommand.getSellerPw());
			session.setAttribute("sellerAuthInfo", sai);
			
			Cookie cookie = new Cookie("sellerEmail", sellerLoginCommand.getSellerEmail());
			
			if(sellerLoginCommand.isRememberEmail()) {
				cookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				cookie.setMaxAge(0);
			}
			
			response.addCookie(cookie);
			
			return "index";
		}
		*/
		
		
		@RequestMapping(value="/seller_update.gom", method=RequestMethod.GET)
		public String updateForm(SellerUpdateCommand sellerUpdateCommand, Model model, HttpSession session) {
			AuthInfo ai = (AuthInfo) session.getAttribute("AuthInfo");
			model.addAttribute("ai", ai);
			model.addAttribute("iPage", "seller/seller_update.jsp");
			return "index";
		}
		
		
		@RequestMapping(value="/seller_update.gom", method=RequestMethod.POST)
		public String updateSubmit(SellerUpdateCommand sellerUpdateCommand, HttpServletRequest httpServletRequest,  Model model) {
			System.out.println("controller form에서 온 httpServletRequest" + httpServletRequest.getParameter("sellerEmail"));
			sellerUpdateCommand.setSellerEmail(httpServletRequest.getParameter("sellerEmail"));
			sellerUpdateCommand.setSellerPw(httpServletRequest.getParameter("sellerPw"));
			sellerUpdateCommand.setSellerPhone(httpServletRequest.getParameter("sellerPhone"));
			Seller seller = new Seller();
			seller.setSellerEmail(sellerUpdateCommand.getSellerEmail());
			seller.setSellerPw(sellerUpdateCommand.getSellerPw());
			seller.setSellerPhone(sellerUpdateCommand.getSellerPhone());
			Integer result = sellerService.updateSeller(seller);
			
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
			AuthInfo ai = (AuthInfo)session.getAttribute("AuthInfo");
			model.addAttribute("divide", ai.getDivide());
			return "index";
		}
}
