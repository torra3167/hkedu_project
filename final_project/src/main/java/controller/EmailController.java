package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.ChangePWCommand;
import command.FindIDCommand;
import service.EmailService;

@Controller
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@RequestMapping(value = "/sellerQnA.gom", method = RequestMethod.GET)
	public String sellerQnA(Model model, HttpSession session, HttpServletRequest request) {
		model.addAttribute("iPage", "seller/sellerQnA_form.jsp");
		String email = (String) session.getAttribute("email");
		System.out.println(email);
		model.addAttribute("email", email);
		System.out.println("CONTROLLER SellerQnA GET");
		Integer result=emailService.findSellerID(email);
		model.addAttribute("result", result);
		System.out.println("controller "+result);
		return "index";
	}

	@RequestMapping(value = "/sellerQnA.gom", method = RequestMethod.POST)
	public String sellerQnASubmit(Model model, HttpSession session, HttpServletRequest request) {
		model.addAttribute("iPage", "seller/sellerQnA_submit.jsp");
		String email = (String) session.getAttribute("email");
		model.addAttribute("sender", email);
		System.out.println("CONTROLLER SellerQnA POST "+email);
		return "index";
	}
	
	@RequestMapping(value = "/findPW.gom", method = RequestMethod.GET)
	public String findPW(FindIDCommand findIDCommand, Model model, HttpSession session, HttpServletRequest request) {
		model.addAttribute("iPage", "login/findPW.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/findPW.gom", method = RequestMethod.POST)
	public String findPWSubmit(FindIDCommand findIDCommand, Model model, HttpSession session, HttpServletRequest request) {
		model.addAttribute("iPage", "login/findPW_success.jsp");
		System.out.println("controller "+findIDCommand.getEmail());
		System.out.println("controller "+findIDCommand.getPhone());
		String email=findIDCommand.getEmail();
		Integer result=emailService.findPW(findIDCommand);
		System.out.println("result="+result);
		model.addAttribute("result", result);
		model.addAttribute("email", email);
		return "index";
	}
	
	@RequestMapping(value = "/changePW.gom", method = RequestMethod.GET)
	public String changePW(ChangePWCommand changePWCommand, @RequestParam("app")String email, Model model, HttpSession session) {
		model.addAttribute("iPage", "login/changePW.jsp");
		model.addAttribute("email", email);
		model.addAttribute("changePWCommand", new ChangePWCommand());
		String id=(String)session.getAttribute("email");
		model.addAttribute("id", id);
		System.out.println("controller changePW get");
		return "index";
	}
	
	@RequestMapping(value = "/changePW.gom", method = RequestMethod.POST)
	public String changePWSubmit(ChangePWCommand changePWCommand, @RequestParam("app")String email, Model model) {
		model.addAttribute("iPage", "login/changePW.jsp");
		Integer result=emailService.changePW(changePWCommand);
		System.out.println("controller changepw "+result);
		model.addAttribute("email", email);
		return "index";
	}
	@RequestMapping(value = "/changePWMember.gom", method = RequestMethod.GET)
	public String changePWMember(ChangePWCommand changePWCommand, Model model, HttpSession session) {
		model.addAttribute("iPage", "login/changePW_success.jsp");
		String email=(String)session.getAttribute("email");
		String id=(String)session.getAttribute("email");
		model.addAttribute("id", id);
		model.addAttribute("email", email);
		model.addAttribute("changePWCommand", new ChangePWCommand());
		System.out.println("controller changePW get");
		return "index";
	}
	
	@RequestMapping(value = "/changePWMember.gom", method = RequestMethod.POST)
	public String changePWSubmitMember(ChangePWCommand changePWCommand, Model model, HttpSession session) {
		model.addAttribute("iPage", "login/changePW_success.jsp");
		Integer result=emailService.changePW(changePWCommand);
		System.out.println("controller changepw "+result);
		String email=(String)session.getAttribute("email");
		model.addAttribute("email", email);
		model.addAttribute("result", result);
		return "index";
	}
	
}
