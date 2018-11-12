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
		model.addAttribute("memberJoinCommand",new MemberJoinCommand());
		System.out.println("controller");
		return "index";
	}
	
	@RequestMapping(value="/member_join.gom", method=RequestMethod.POST)
	public String joinSubmit(MemberJoinCommand memberJoinCommand,  Model model) {
		Integer result=null;
		System.out.println("controller");
		result=memberService.insertMember(memberJoinCommand);
		if(result>0) {
			model.addAttribute("result", result);
			return "index";
		}else {
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value="/findID.gom", method=RequestMethod.GET)
	public String findID(Model model) {
		model.addAttribute("iPage", "login/login.jsp");
		return "login/findID";
	}
	
	@RequestMapping(value="/member_write_survey1.gom", method=RequestMethod.GET)
	public String Survey1Form(Model model) {
		model.addAttribute("iPage", "survey/survey_1.jsp");
		return "index";
	}
	
//	@RequestMapping(value="/member_write_survey2.gom", method=RequestMethod.GET)
//	public String Survey2Form(Model model) {
//		model.addAttribute("iPage", "member/login/survey_1.jsp");
//		return "member/login/survey_2";
//	}
}
