package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
