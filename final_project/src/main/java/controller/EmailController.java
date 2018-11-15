/*package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.EmailCommand;
import email.EmailSender;
import email.EmailService;

@Controller
public class EmailController {
	EmailSender emailSender;
	EmailService emailService;
	@RequestMapping(value="/email_send.gom", method=RequestMethod.GET)
	public String sendEmail(Model model, EmailCommand emailCommand) throws Exception {
		model.addAttribute("iPage", "login/findPW.jsp");
		System.out.println("controller emailAction "+emailCommand.getReceiver());
		model.addAttribute("emailSender", new EmailCommand());
		return "index";
	}
	@RequestMapping(value="/email_send.gom", method=RequestMethod.POST)
	public String sendEmailAction(Model model, EmailCommand emailCommand, HttpServletRequest request) throws Exception {
		model.addAttribute("iPage", "login/findPW_success.jsp");
		emailCommand.setReceiver(request.getParameter("emailReceiver"));
		System.out.println("controller emailAction success "+emailCommand.getReceiver());
		int result=emailService.sendEmail(emailCommand);
		if(result>0) {
			model.addAttribute("result", result);
			return "index";
		}else {
		return "redirect:/index";
		}
	}
}
*/