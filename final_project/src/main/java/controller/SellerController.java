package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.SellerJoinCommand;
import model.Seller;
import service.SellerService;


@Controller
public class SellerController {
	
		@Autowired
		private SellerService sellerService;
		
		
		@RequestMapping(value="/seller/join.gom", method=RequestMethod.GET)
		public String joinForm(SellerJoinCommand sellerJoinCommand) {
			return "seller/seller_join.jsp";
		}
		
		@RequestMapping(value="/seller_join", method=RequestMethod.POST)
		public String joinSubmit(SellerJoinCommand sellerJoinCommand,  Model model) {
			Integer result = null;
			//result값 받아오기 위해서 service(CommentService)가 필요하다.
			//위에서 자동주입 했으므로 new로 service의 객체 생성하지 않는다.
			result = sellerService.insertSeller(sellerJoinCommand);
			if(result>0) {
				model.addAttribute("result", result);
				return "seller/seller_join.jsp";
			}else {
				return "redirect:/seller/join.gom";
			}
		}
		
		/*@RequestMapping(value="/seller/login.gom", method=RequestMethod.GET)
		public String LoginForm(Seller seller) {
			
			return "seller/seller_login";
		}*/
}
