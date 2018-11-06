package controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.MemberJoinCommand;
import command.MemberLoginCommand;
import service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService ms;
	
	
	@RequestMapping(value="/member/join.gom", method=RequestMethod.GET)
	public String joinForm(Model model) {
		model.addAttribute("iPage", "member/member_register.jsp");
		return "index";
	}
	
	@RequestMapping(value="/member/join.gom", method=RequestMethod.POST)
	public String joinSubmit(MemberJoinCommand memberJoinCommand,  HttpSession session, HttpServletResponse response) {
		
		return "index";
	}
	
	@RequestMapping(value="/member/login.gom", method=RequestMethod.GET)
	public String LoginForm(Model model) {
		
		model.addAttribute("iPage", "member/member_login.jsp");
		return "index";
	}
}
