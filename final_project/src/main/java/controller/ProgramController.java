package controller;

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
	    
		ps.insertProgram(programCommand);
		model.addAttribute("iPage", "program/program_register.jsp");
	    return "index";

	}
}

