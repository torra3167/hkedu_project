package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.xml.internal.ws.addressing.v200408.MemberSubmissionWsaClientTube;

import command.FindIDCommand;
import command.MemberJoinCommand;
import command.MemberSurveyCommand;
import command.MemberUpdateCommand;
import command.MemberWithdrawalCommand;
import command.SellerWithdrawalCommand;
import model.AuthInfo;
import model.Member;
import model.MemberAuthInfo;
import service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value="/member_join.gom", method=RequestMethod.GET)
	public String joinForm(Model model) {
		model.addAttribute("iPage", "member/member_register.jsp");
		model.addAttribute("memberJoinCommand",new MemberJoinCommand());
		System.out.println("controller Join");
		return "index";
	}
	
	@RequestMapping(value="/member_join.gom", method=RequestMethod.POST)
	public String joinSubmit(MemberJoinCommand memberJoinCommand,  Model model) {
		Integer result=null;
		System.out.println("controller JoinSubmit");
		result=memberService.insertMember(memberJoinCommand);
		if(result>0) {
			model.addAttribute("result", result);
			return "index";
		}else {
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value="/findID.gom", method=RequestMethod.GET)
	public String findID(FindIDCommand findIDCommand,Model model) {
		model.addAttribute("iPage", "login/findID.jsp");
		return "index";
	}
	
	@RequestMapping(value="/findID.gom", method=RequestMethod.POST)
	public String findIDSubmit(FindIDCommand findIDCommand, Model model) {
		memberService.findID(findIDCommand, model);
		model.addAttribute("iPage", "login/findID_success.jsp");
		return "index";
	}

	@RequestMapping(value="/member_myPage.gom", method=RequestMethod.GET)
	public String memberMyPage(Model model, HttpSession session) {
		model.addAttribute("iPage", "member/member_myPage.jsp");
		model.addAttribute("email", session.getAttribute("email").toString());
		return "index";
	}
	
	@RequestMapping(value="/member_info.gom", method=RequestMethod.GET)
	public String memberInfo(MemberUpdateCommand memberUpdateCommand, Model model, HttpSession session) {
		model.addAttribute("iPage", "member/member_info.jsp");
		String email=(String)session.getAttribute("email");
		Member member=memberService.memberInfo(email);
		model.addAttribute("member", member);
		return "index";
	}
	@RequestMapping(value="/member_info.gom", method=RequestMethod.POST)
	public String memberInfoUpdate(MemberUpdateCommand memberUpdateCommand, HttpServletRequest request, Model model) {
		model.addAttribute("iPage", "member/member_update.jsp");
		Integer result=memberService.updateMember(memberUpdateCommand);
		System.out.println("controller "+memberUpdateCommand.getMemberEmail());
		if(result>0) {
			model.addAttribute("result", result);
			return "index";
		}else {
		return "redirect:/index";
		}
	}
	@RequestMapping(value="/member_withdrawal.gom", method=RequestMethod.GET)
	public String memberSucession( Model model, HttpSession session) {
		model.addAttribute("iPage", "member/member_secession.jsp");
		System.out.println("controller "+session.getAttribute("email"));
		model.addAttribute("memberWithdrawal", new MemberWithdrawalCommand());
		return "index";
	}
	@RequestMapping(value="/member_withdrawal.gom", method=RequestMethod.POST)
	public String memberSucessionSubmit(MemberWithdrawalCommand memberWithdrawalCommand, Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("iPage", "member/member_secession_success.jsp");
		memberWithdrawalCommand.setMemberEmail(session.getAttribute("email").toString());
		memberWithdrawalCommand.setMemberPass(request.getParameter("memberPass"));
		int result=memberService.deleteMember(memberWithdrawalCommand, session);
		if(result>0) {
			session.invalidate();
			model.addAttribute("result", result);
			System.out.println(result+"명 탈퇴 성공");
			return "index";
		}else {
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value="/member_write_survey1.gom", method=RequestMethod.GET)
	public String Survey1Form(Model model) {
		model.addAttribute("iPage", "survey/survey_1.jsp");
		model.addAttribute("memberSurveyCommand",new MemberSurveyCommand());
		System.out.println("controller Survey1");
		return "index";
	}
	
	
//	@RequestMapping(value="/member_write_survey2.gom", method=RequestMethod.GET)
//	public String Survey2Form(Model model) {
//		model.addAttribute("iPage", "member/login/survey_1.jsp");
//		return "member/login/survey_2";
//	}
}
