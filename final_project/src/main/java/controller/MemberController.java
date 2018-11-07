package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.MemberJoinCommand;
import service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value="/member_join.gom", method=RequestMethod.GET)
	public String joinForm(Model model) {
		model.addAttribute("iPage", "member/member_register.jsp");
		return "index";
	}
	
	@RequestMapping(value="/member_join.gom", method=RequestMethod.POST)
	public String joinSubmit(MemberJoinCommand memberJoinCommand,  Model model) {
		Integer result=null;
		result=memberService.insertMember(memberJoinCommand);
		if(result>0) {
			model.addAttribute("result", result);
			return "member/member_join.jsp";
		}else {
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value="/member_login.gom", method=RequestMethod.GET)
	public String LoginForm(Model model) {
		return "member/member_login";
	}
	
	@RequestMapping(value="/member_write_servey1.gom", method=RequestMethod.GET)
	public String Survey1Form(Model model) {
		return "login/survey_1";
	}
}
