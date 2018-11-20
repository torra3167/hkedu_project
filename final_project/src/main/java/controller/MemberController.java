package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.FindIDCommand;
import command.MemberJoinCommand;
import command.MemberSurveyCommand;
import command.MemberUpdateCommand;
import command.MemberWithdrawalCommand;
import model.Member;
import service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/member_join.gom", method = RequestMethod.GET)
	public String joinForm(Model model) {
		model.addAttribute("iPage", "member/member_register.jsp");
		model.addAttribute("memberJoinCommand", new MemberJoinCommand());
		System.out.println("controller Join");
		return "index";
	}

	@RequestMapping(value = "/member_join.gom", method = RequestMethod.POST)
	public String joinSubmit(MemberJoinCommand memberJoinCommand, Model model) {
		Integer result = null;
		System.out.println("controller JoinSubmit");
		result = memberService.insertMember(memberJoinCommand);
		if (result > 0) {
			model.addAttribute("result", result);
			return "index";
		} else {
			return "redirect:/index";
		}
	}

	@RequestMapping(value = "/findID.gom", method = RequestMethod.GET)
	public String findID(FindIDCommand findIDCommand, Model model) {
		model.addAttribute("iPage", "login/findID.jsp");
		return "index";
	}

	@RequestMapping(value = "/findID.gom", method = RequestMethod.POST)
	public String findIDSubmit(FindIDCommand findIDCommand, Model model) {
		model.addAttribute("iPage", "login/findID_success.jsp");
		System.out.println("findIDSubmit  " + findIDCommand.getMemberName());
		memberService.findID(findIDCommand, model);
		return "index";
	}

	@RequestMapping(value = "/member_myPage.gom", method = RequestMethod.GET)
	public String memberMyPage(Model model, HttpSession session) {
		model.addAttribute("iPage", "member/member_myPage.jsp");
		model.addAttribute("email", session.getAttribute("email").toString());
		return "index";
	}

	@RequestMapping(value = "/member_info.gom", method = RequestMethod.GET)
	public String memberInfo(MemberUpdateCommand memberUpdateCommand, Model model, HttpSession session) {
		model.addAttribute("iPage", "member/member_info.jsp");
		String email = (String) session.getAttribute("email");
		Member member = memberService.memberInfo(email);
		model.addAttribute("member", member);
		return "index";
	}

	@RequestMapping(value = "/member_info.gom", method = RequestMethod.POST)
	public String memberInfoUpdate(MemberUpdateCommand memberUpdateCommand, HttpServletRequest request, Model model) {
		model.addAttribute("iPage", "member/member_update.jsp");
		Integer result = memberService.updateMember(memberUpdateCommand);
		System.out.println("controller " + memberUpdateCommand.getMemberEmail());
		if (result > 0) {
			model.addAttribute("result", result);
			return "index";
		} else {
			return "redirect:/index";
		}
	}

	@RequestMapping(value = "/member_withdrawal.gom", method = RequestMethod.GET)
	public String memberSucession(Model model, HttpSession session) {
		model.addAttribute("iPage", "member/member_secession.jsp");
		System.out.println("controller " + session.getAttribute("email"));
		model.addAttribute("memberWithdrawal", new MemberWithdrawalCommand());
		return "index";
	}

	@RequestMapping(value = "/member_withdrawal.gom", method = RequestMethod.POST)
	public String memberSucessionSubmit(MemberWithdrawalCommand memberWithdrawalCommand, Model model,
			HttpServletRequest request, HttpSession session) {
		model.addAttribute("iPage", "member/member_secession_success.jsp");
		memberWithdrawalCommand.setMemberEmail(session.getAttribute("email").toString());
		memberWithdrawalCommand.setMemberPass(request.getParameter("memberPass"));
		int result = memberService.deleteMember(memberWithdrawalCommand, session);
		if (result > 0) {
			session.invalidate();
			model.addAttribute("result", result);
			System.out.println(result + "탈퇴 완료");
			return "index";
		} else {
			return "redirect:/index";
		}
	}

	@RequestMapping(value = "/member_write_survey1.gom", method = RequestMethod.GET)
	public String Survey1Form(Model model) {
		model.addAttribute("iPage", "survey/survey_1.jsp");
		model.addAttribute("memberSurveyCommand", new MemberSurveyCommand());
		System.out.println("controller Survey1");
		return "index";
	}

	@RequestMapping(value = "/member_write_survey2.gom", method = RequestMethod.GET)
	public String Survey2Form(Model model) {
		model.addAttribute("iPage", "member/login/survey_1.jsp");
		return "member/login/survey_2";
	}

	@RequestMapping(value = "/personalQna.gom", method = RequestMethod.GET)
	public String personalQna(Model model, HttpSession session, HttpServletRequest request) {
		model.addAttribute("iPage", "member/personalQnA_form.jsp");
		String email = (String) session.getAttribute("email");
		String sender = request.getParameter("sender");
		if (sender != null) {
			email = sender;
		}
		model.addAttribute("email", email);
		return "index";
	}

	@RequestMapping(value = "/personalQna.gom", method = RequestMethod.POST)
	public String personalQnaSubmit(Model model, HttpSession session) {
		model.addAttribute("iPage", "member/personalQnA_send.jsp");
		String email = (String) session.getAttribute("email");
		model.addAttribute("sender", email);
		return "index";
	}

	@RequestMapping(value = "/personalQna_answer.gom", method = RequestMethod.GET)
	public String QnAanswer(@RequestParam("app")String receiver,Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("controller "+receiver);
		model.addAttribute("iPage", "member/personalQnA_answer.jsp");
		model.addAttribute("receiver", receiver);
		String id=(String)session.getAttribute("email");
		model.addAttribute("id", id);
		return "index";
	}
	@RequestMapping(value="/personalQna_answer.gom", method=RequestMethod.POST)
	public String QnAanswerSubmit(Model model, HttpSession session) {
		model.addAttribute("iPage", "member/personalQnA_answerSubmit.jsp");
		String sender=(String)session.getAttribute("email");
		model.addAttribute("sender", sender);
		return "index";
	}
}
