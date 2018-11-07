package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.CoachLoginCommand;
import command.SellerJoinCommand;
import model.CoachAuthInfo;
import model.Seller;
import service.SellerService;


@Controller
public class SellerController {
	
		@Autowired
		private SellerService sellerService;
		
		
		@RequestMapping(value="/seller_join.gom", method=RequestMethod.GET)
		public String joinForm(Model model) {
			model.addAttribute("sellerJoinCommand", new SellerJoinCommand());
			return "seller/seller_join";
		}
		
		@RequestMapping(value="/seller/join.gom", method=RequestMethod.POST)
		public String joinSubmit(SellerJoinCommand sellerJoinCommand,  Model model) {
			Integer result = null;
			//result값 받아오기 위해서 service(CommentService)가 필요하다.
			//위에서 자동주입 했으므로 new로 service의 객체 생성하지 않는다.
			result = sellerService.insertSeller(sellerJoinCommand);
			if(result>0) {
				model.addAttribute("result", result);
				return "redirect:/index";
			}else {
				return "redirect:/seller/join.gom";
			}
		}
		
		/*@RequestMapping(value="/seller_login.gom", method=RequestMethod.GET)
		public String sellerLogin(sellerLoginCommand coachLoginCommand, Model model, @CookieValue(value="coachEmail", required=false)Cookie rememberCookie) {
			if(rememberCookie != null) {
				coachLoginCommand.setCoachEmail(rememberCookie.getValue());
				coachLoginCommand.setRememberEmail(true);
			}
			
			model.addAttribute("iPage", "coach/coach_login.jsp");
			
			return "index";
		}
		
		@RequestMapping(value="/coach_login.gom", method=RequestMethod.POST )
		public String CoachSubmit(CoachLoginCommand coachLoginCommand, Model model, 
				HttpSession session, HttpServletResponse response) {
			
			CoachAuthInfo cai = cs.authenticate(coachLoginCommand.getCoachEmail(), coachLoginCommand.getCoachPw());
			session.setAttribute("coachAuthInfo", cai);
			Cookie cookie = new Cookie("coachEmail", coachLoginCommand.getCoachEmail());
			
			if(coachLoginCommand.isRememberEmail()) {
				cookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				cookie.setMaxAge(0);
			}
			
			response.addCookie(cookie);
			
			
			return "index";
			
			
		}*/
}
