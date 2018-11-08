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

import command.LoginCommand;
import model.CoachAuthInfo;
import service.CoachService;
import service.MemberService;
import service.SellerService;
import service.LoginService;
@Controller
public class LoginController {
	
	@Autowired
	private LoginService ls;
	private CoachService cs;
	private MemberService ms;
	private SellerService sellerService;
	
	
	@RequestMapping(value="/coach_login.gom", method=RequestMethod.GET)
	public String CoachLogin(LoginCommand loginCommand, Model model, @CookieValue(value="email", required=false)Cookie rememberCookie) {
		if(rememberCookie != null) {
			loginCommand.setEmail(rememberCookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		
		model.addAttribute("iPage", "coach/coach_login.jsp");
		
		return "index";
	}
	
	@RequestMapping(value="/coach_login.gom", method=RequestMethod.POST )
	public String CoachSubmit(LoginCommand loginCommand, Model model, 
			HttpSession session, HttpServletResponse response) {
		
		System.out.println(loginCommand.getEmail());
		System.out.println(loginCommand.getPw());
		
		ls.selectByEmailAndDivide(loginCommand.getEmail(), loginCommand.getPw());
		
		
		
		
		/*CoachAuthInfo cai = cs.authenticate(coachLoginCommand.getCoachEmail(), coachLoginCommand.getCoachPw());
		session.setAttribute("coachAuthInfo", cai);
		Cookie cookie = new Cookie("email", coachLoginCommand.getCoachEmail());
		
		if(coachLoginCommand.isRememberEmail()) {
			cookie.setMaxAge(60 * 60 * 24 * 30);
		} else {
			cookie.setMaxAge(0);
		}
		
		response.addCookie(cookie);*/
		
		return "index";
	}
}
