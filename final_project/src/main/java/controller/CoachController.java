package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.CoachService;

@Controller
public class CoachController {
	
	@Autowired
	private CoachService cs;
	
	
	@RequestMapping(value="/coach_login.gom", method=RequestMethod.GET )
	public String CoachLogin(Model model) {
		model.addAttribute("iPage", "coach/coach_login.jsp");
		return "index";
	}
}
