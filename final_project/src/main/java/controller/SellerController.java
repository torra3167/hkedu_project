package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.CoachLoginCommand;
import command.SellerJoinCommand;
import command.SellerLoginCommand;
import model.CoachAuthInfo;
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
			//result값 받아오기 위해서 service(CommentService)가 필요하다.
			//위에서 자동주입 했으므로 new로 service의 객체 생성하지 않는다.
			result = sellerService.insertSeller(sellerJoinCommand);
			if(result>0) {
				model.addAttribute("result", result);
				return "index";
			}else {
				return "redirect:/index";
			}
		}
		
		
		
}
