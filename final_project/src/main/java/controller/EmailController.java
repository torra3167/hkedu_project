/*package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import email.EmailSender;
import model.Member;
import service.EmailService;

@Controller
public class EmailController {
	EmailSender emailSender;
	EmailService emailService;
	
	@RequestMapping(value="/findPW.gom", method=RequestMethod.GET)
	public String sendEmail(Model model) throws Exception {
		model.addAttribute("iPage", "login/findPW.jsp");
		model.addAttribute("emailCommand", new EmailCommand());
		return "index";
	}
	@RequestMapping(value="/findPW.gom", method=RequestMethod.POST)
	public String sendEmailAction(EmailCommand emailCommand, Model model, Member member, HttpServletRequest request) throws Exception {
		model.addAttribute("iPage", "login/findPW_success.jsp");
		emailCommand.setMemberEmail(request.getParameter("memberEmail"));
		emailCommand.setMemberName(request.getParameter("memberName"));
		System.out.println("controller emailAction success "+emailCommand.getMemberEmail());
//		member.setMemberPass(request.getParameter(""));
		int result=emailService.sendEmail(emailCommand);
		
		emailSender.sendEmail(emailCommand);
		if(result>0) {
			System.out.println("controller emailAction success 2 "+emailCommand.getMemberEmail());
			model.addAttribute("result", result);
			return "index";
		}else {
		return "redirect:/index";
		}
	}
}
*/