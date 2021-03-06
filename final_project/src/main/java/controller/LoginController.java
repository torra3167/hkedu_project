package controller;

import java.util.List;

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

import command.LoginCommand;
import model.AuthInfo;
import model.FoodAndApplication;
import service.LoginService;
import service.SellerService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService ls;
	
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model, HttpSession session) {
		
		session.setAttribute("sender", "kdahae1129@gmail.com");
		
		//프로그램리스트
		ls.programList(model);
		ls.selectFoodList(model);
		return "index";
	}
	
	@RequestMapping(value="/login.gom", method=RequestMethod.GET)
	public String CoachLogin(LoginCommand loginCommand, Model model, @CookieValue(value="email", required=false)Cookie rememberCookie) {
		if(rememberCookie != null) {
			loginCommand.setEmail(rememberCookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		
		model.addAttribute("iPage", "login/login.jsp");
		return "index";
	}
	
	@RequestMapping(value="/login.gom", method=RequestMethod.POST )
	public String loginSubmit(LoginCommand loginCommand, Model model, 
			HttpSession session, HttpServletResponse response) {
		/*System.out.println(loginCommand.getEmail());
		System.out.println(loginCommand.getPw());*/
		AuthInfo ai = ls.selectByEmailAndDivide(loginCommand.getEmail(), loginCommand.getPw());
		session.setAttribute("divide", ai.getDivide());
		//인증
		session.setAttribute("email", ai.getEmail());
		
		Cookie cookie = new Cookie("email", loginCommand.getEmail());
		if(loginCommand.isRememberEmail()) {
			cookie.setMaxAge(60 * 60 * 24 * 30);
		} else {
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		
		
		return "redirect:/index";
	}
	
	@RequestMapping(value="/logout.gom", method=RequestMethod.GET)
	public String logout(HttpSession session) {		
		session.invalidate();
		return "redirect:/index";
	}
}
