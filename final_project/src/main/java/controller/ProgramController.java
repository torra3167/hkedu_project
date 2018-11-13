package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.ProgramCommand;
import service.ProgramService;

@Controller
public class ProgramController {
	@Autowired
	private ProgramService ps;
	
	@RequestMapping(value="/program_register.gom", method=RequestMethod.GET)
	public String programForm(ProgramCommand programCommand, Model model) {
	    
		model.addAttribute("iPage", "program/program_register.jsp");
	    return "index";

	}
	
	@RequestMapping(value="/program_register.gom", method=RequestMethod.POST)
	public String programSubmit(ProgramCommand programCommand, HttpSession session, Model model) {
	    
		String coachEmail = (String)session.getAttribute("email");
		programCommand.setCoachEmail(coachEmail);
		System.out.println(programCommand.getProImg() + " PRO IMG");
		System.out.println(programCommand.getProName() + " PRO NAME");
		System.out.println(programCommand.getCoachEmail() + " COACHEMAIL");
		
		
		ps.insertProgram(programCommand);
	    return "index";

	}
}

