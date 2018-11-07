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
import model.CoachAuthInfo;
import service.CoachService;

@Controller
public class CoachController {
	
	@Autowired
	private CoachService cs;
	
	
	@RequestMapping(value="/coach_login.gom", method=RequestMethod.GET)
	public String CoachLogin(CoachLoginCommand coachLoginCommand, Model model, @CookieValue(value="coachEmail", required=false)Cookie rememberCookie) {
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
		
		
	}
}
