package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import command.ProgramCommand;
import command.ProgramDetailCommand;
import service.ProgramService;

@Controller
public class ProgramController {
	@Autowired
	private ProgramService ps;
	
	
	@RequestMapping(value = "/program_detail.gom", method = RequestMethod.GET)
	public String programDetail(ProgramDetailCommand programDetailCommand, Model model ) {
//		System.out.println(programDetailCommand.getProNo() + "PRONO by command! ");
//		System.out.println(programDetailCommand.getProContent() + " PROCONTENT");
		
		model.addAttribute("iPage", "program/program_detail.jsp");
		ps.programDetail(programDetailCommand, model);
		return "index";

	}

	@RequestMapping(value = "/program_list.gom", method = RequestMethod.GET)
	public String programList(Model model) {

		ps.programList(model);
		model.addAttribute("iPage", "program/program_list.jsp");
		return "index";

	}

	@RequestMapping(value = "/program_register.gom", method = RequestMethod.GET)
	public String programForm(ProgramCommand programCommand, Model model) {

//		ps.exerciseCategoryB(model);
		model.addAttribute("iPage", "program/program_register.jsp");
		return "index";

	}

	@RequestMapping(value = "/program_register.gom", method = RequestMethod.POST)
	public String programSubmit(ProgramCommand programCommand, HttpSession session, Model model) {

		System.out.println("CAT NAME " + programCommand.getExerciseCatAName());
		String coachEmail = (String) session.getAttribute("email");

		programCommand.setCoachEmail(coachEmail);

		System.out.println(programCommand.getProImg() + " PRO IMG");
		System.out.println(programCommand.getProName() + " PRO NAME");
		System.out.println(programCommand.getCoachEmail() + " COACHEMAIL");

		ps.insertProgram(programCommand);
		
		return "redirect:/index";

	}

}
