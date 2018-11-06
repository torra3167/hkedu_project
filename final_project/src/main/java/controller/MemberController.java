package controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
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
	public String joinForm(MemberJoinCommand memberJoinCommand) {
		
		return "member/member_register";
	}
	
	@RequestMapping(value="/member/join.gom", method=RequestMethod.POST)
	public String joinSubmit(MemberJoinCommand memberJoinCommand,  HttpSession session, HttpServletResponse response) {
		
		return "";
	}
	
	@RequestMapping(value="/member/login.gom", method=RequestMethod.GET)
	public String LoginForm(MemberLoginCommand memberloginCommand) {
		
		return "member/member_login";
	}
}
