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
import model.MemberSurvey;
import service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	/*회원가입*/
	@RequestMapping(value = "/member_join.gom", method = RequestMethod.GET)
	public String joinForm(Model model) {
		model.addAttribute("iPage", "member/member_register.jsp");
		model.addAttribute("memberJoinCommand", new MemberJoinCommand());
		System.out.println("CONTROLLER Join GET");
		return "index";
	}

	@RequestMapping(value = "/member_join.gom", method = RequestMethod.POST)
	public String joinSubmit(MemberJoinCommand memberJoinCommand, Model model) {
		Integer result = null;
		System.out.println("CONTROLLER Join POST");
		result = memberService.insertMember(memberJoinCommand);
		if (result > 0) {
			model.addAttribute("result", result);
			return "index";
		} else {
			return "redirect:/index";
		}
	}
	
	/*ID찾기*/
	@RequestMapping(value = "/findID.gom", method = RequestMethod.GET)
	public String findID(FindIDCommand findIDCommand, Model model) {
		model.addAttribute("iPage", "login/findID.jsp");
		System.out.println("CONTROLLER FindID GET");
		return "index";
	}

	@RequestMapping(value = "/findID.gom", method = RequestMethod.POST)
	public String findIDSubmit(FindIDCommand findIDCommand, Model model) {
		model.addAttribute("iPage", "login/findID_success.jsp");
		System.out.println("CONTROLLER FindIDSubmit POST "+findIDCommand.getMemberName());
		memberService.findID(findIDCommand, model);
		return "index";
	}
	
	/*마이페이지 접속*/
	@RequestMapping(value = "/member_myPage.gom", method = RequestMethod.GET)
	public String memberMyPage(Model model, HttpSession session) {
		model.addAttribute("iPage", "member/member_myPage.jsp");
		model.addAttribute("email", session.getAttribute("email").toString());
		System.out.println("CONTROLLER MyPage GET");
		return "index";
	}
	
	/*회원정보 열람 및 수정*/
	@RequestMapping(value = "/member_info.gom", method = RequestMethod.GET)
	public String memberInfo(MemberUpdateCommand memberUpdateCommand, Model model, HttpSession session) {
		model.addAttribute("iPage", "member/member_info.jsp");
		String email = (String) session.getAttribute("email");
		Member member = memberService.memberInfo(email);
		model.addAttribute("member", member);
		System.out.println("CONTROLLER MemberInfo GET");
		return "index";
	}
	
	@RequestMapping(value = "/member_info.gom", method = RequestMethod.POST)
	public String memberInfoUpdate(MemberUpdateCommand memberUpdateCommand, HttpServletRequest request, Model model) {
		model.addAttribute("iPage", "member/member_update.jsp");
		Integer result = memberService.updateMember(memberUpdateCommand);
		System.out.println("CONTROLLER MemberInfoUpdate POST "+memberUpdateCommand.getMemberEmail());
		if (result > 0) {
			model.addAttribute("result", result);
			return "index";
		} else {
			return "redirect:/index";
		}
	}

	/*회원탈퇴*/
	@RequestMapping(value = "/member_withdrawal.gom", method = RequestMethod.GET)
	public String memberSucession(Model model, HttpSession session) {
		model.addAttribute("iPage", "member/member_secession.jsp");
		System.out.println("CONTROLLER Withdrawalmember_write_survey1.gom GET "+session.getAttribute("email"));
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
			System.out.println("CONTROLLER MemberWithdrawal POST "+result);
			return "index";
		} else {
			return "redirect:/index";
		}
	}
	
	/*회원 문의*/
	@RequestMapping(value = "/personalQna.gom", method = RequestMethod.GET)
	public String personalQna(Model model, HttpSession session, HttpServletRequest request) {
		model.addAttribute("iPage", "member/personalQnA_form.jsp");
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		System.out.println("CONTROLLER PersonalQnA GET");
		return "index";
	}

	@RequestMapping(value = "/personalQna.gom", method = RequestMethod.POST)
	public String personalQnaSubmit(Model model, HttpSession session, HttpServletRequest request) {
		model.addAttribute("iPage", "member/personalQnA_send.jsp");
		String email = (String) session.getAttribute("email");
		String sender = request.getParameter("sender");
		if (email == null && sender != null) {
			email = sender;
		}
		model.addAttribute("sender", email);
		System.out.println("CONTROLLER PersonalQnA POST "+email);
		return "index";
	}
	
	/*관리자 답변*/
	@RequestMapping(value = "/personalQna_answer.gom", method = RequestMethod.GET)
	public String QnAanswer(@RequestParam("app")String receiver,Model model, HttpServletRequest request, HttpSession session) {
		model.addAttribute("iPage", "member/personalQnA_answer.jsp");
		model.addAttribute("receiver", receiver);
		String id=(String)session.getAttribute("email");
		/*String id="kdahae1129@gmail.com";*/
		model.addAttribute("id", id);
		System.out.println("CONTROLLER PersonalQnA Answer GET");
		return "index";
	}
	@RequestMapping(value="/personalQna_answer.gom", method=RequestMethod.POST)
	public String QnAanswerSubmit(Model model, HttpSession session) {
		System.out.println("CONTROLLER PersonalQnA Answer POST start");
		model.addAttribute("iPage", "member/personalQnA_answerSubmit.jsp");
		String sender=(String)session.getAttribute("email");
		model.addAttribute("sender", sender);
		System.out.println("CONTROLLER PersonalQnA Answer POST "+sender);
		return "index";
	}
	
	/*설문지 1*/
	@RequestMapping(value = "/member_write_survey1.gom", method = RequestMethod.GET)
	public String Survey1Form(MemberSurveyCommand memberSurveyCommand, Model model, HttpSession session) {
		model.addAttribute("iPage", "survey/survey_1.jsp");
		model.addAttribute("memberSurveyCommand", memberSurveyCommand);
		String email=(String)session.getAttribute("email");
		model.addAttribute("email", email);
		System.out.println("CONTROLLER Survey1 GET");
		return "index";
	}
	
	@RequestMapping(value = "/member_write_survey1.gom", method = RequestMethod.POST)
	public String Survey1Submit(MemberSurveyCommand memberSurveyCommand, Model model, HttpServletRequest request, HttpSession session) {
		System.out.println("controller"+memberSurveyCommand.getMemberEmail());
		model.addAttribute("iPage", "survey/survey_success.jsp");
		System.out.println("CONTROLLER Survey1 POST "+request.getParameter("survNo"));
		String email=memberSurveyCommand.getMemberEmail();
		System.out.println(email);
		String id=(String)session.getAttribute("email");
		model.addAttribute("email",id);
		if(email==null || email.equals("") ) {
			System.out.println("email confirm");
			memberSurveyCommand.setMemberEmail("1");
		}
		Integer result = memberService.insertSurvey1(memberSurveyCommand);
		System.out.println("aaaaaa" + result);
		if (result > 0) {
			model.addAttribute("result", result);
			return "index";
		} else {
			return "redirect:/index";
		}
	}
	
	/*설문지 2*/
	@RequestMapping(value = "/member_write_survey2.gom", method = RequestMethod.GET)
	public String Survey2Form(MemberSurveyCommand memberSurveyCommand, Model model, HttpSession session) {
		model.addAttribute("iPage", "survey/survey_2.jsp");
		System.out.println("CONTROLLER Survey2 GET");
		String email = (String) session.getAttribute("email");
		model.addAttribute("email",email);
		model.addAttribute("memberSurveyCommand", memberSurveyCommand);
		return "index";
	}
	
	@RequestMapping(value = "/member_write_survey2.gom", method = RequestMethod.POST)
	public String Survey2Submit(MemberSurveyCommand memberSurveyCommand, Model model, HttpSession session,HttpServletRequest request) {
		model.addAttribute("iPage", "survey/survey_success2.jsp");
		String email=(String)session.getAttribute("email");
		model.addAttribute("email", email);
		System.out.println("CONTROLLER Survey2 POST "+request.getParameter("memberEmail"));
		Integer result=memberService.updateSurvey2(memberSurveyCommand);
		System.out.println("controller "+result);
		if(result>0) {
			model.addAttribute("result", result);
			return "index";
		}else {
			return "redirect:/index";
		}
	}

	
}
