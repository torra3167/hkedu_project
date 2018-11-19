package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PayController {
	
	@RequestMapping(value="/.gom", method=RequestMethod.GET)
	public String cartForm(Model model) {
		
		model.addAttribute("iPage", "pay/cartList.jsp");
		
		return "index";
	}
}
