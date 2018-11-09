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
import model.Seller;
import model.SellerAuthInfo;
import service.SellerService;

//브라우저에 보여줄 뷰의 이름을 전달한다
@Controller
public class SellerController {
	
		@Autowired
		private SellerService sellerService;
		//value에 명시한 문자열로 접근하는 URL을 처리한다
		@RequestMapping(value="/seller_join.gom", method=RequestMethod.GET)
		public String joinForm(Model model) {
			model.addAttribute("iPage", "seller/seller_join.jsp");
			return "index";
			 //메소드가 void타입일 경우 접근하는 URL경로(@RequestMapping에 명시한)에 해당하는 jsp를 찾아 실행시킨다.
			 //리턴 타입이 String일 경우 리턴하는 문자열이 바로 뷰 이름이 되는 것이다.
			 //servlet-context의 view-resolvers와 합친 경로의 jsp를 실행
		}
		
		@RequestMapping(value="/seller_join.gom", method=RequestMethod.POST)
		public String joinSubmit(SellerJoinCommand sellerJoinCommand,  Model model) { //form(jsp)에서 입력한 값담아 오는 객체
			//@ModelAttribute는 브라우저의 요청 시 지정한 파라미터를 문자열화해주고, 뷰로 전달한다.
			Integer result = null;		
			result = sellerService.insertSeller(sellerJoinCommand);
			if(result>0) {
				//return jsp에서 사용할(request.getprameter처럼) command객체를 model에 저장
				model.addAttribute("result", result);
				return "index";
			}else {
				return "redirect:/index";
			}
		}
		
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
		
		@RequestMapping(value="/seller_update.gom", method=RequestMethod.GET)
		public String updateForm(SellerUpdateCommand sellerUpdateCommand, Model model, HttpSession session) {
			SellerAuthInfo sai = (SellerAuthInfo) session.getAttribute("sellerAuthInfo");
			model.addAttribute("sai", sai);
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
}
