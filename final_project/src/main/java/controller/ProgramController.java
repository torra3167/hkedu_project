package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.ProReviewUpdateCommand;
import command.ProReviewWriteCommand;
import command.ProgramCommand;
import command.ProgramDetailCommand;
import service.ProgramService;

@Controller
public class ProgramController {
	@Autowired
	private ProgramService ps;
	
	
	
	@RequestMapping(value = "/pro_review_update.gom", method = RequestMethod.GET)
	public String programReviewUpdate(ProReviewUpdateCommand proReviewUpdateCommand, Model model) {
		
		model.addAttribute("iPage", "program/pro_review_update.jsp");
		model.addAttribute("ProReviewUpdateCommand", proReviewUpdateCommand);
	    return "index";

	}
	
	@RequestMapping(value = "/pro_review_all_list.gom", method = RequestMethod.GET)
	public String programReviewAllList(Model model) {
		ps.selectProReviewAllList(model);
		
		model.addAttribute("iPage", "program/pro_review_list.jsp");
		return "index";

	}
	
	@RequestMapping(value = "/pro_review_list.gom", method = RequestMethod.GET)
	public String programReviewList(@RequestParam(value="proNo", defaultValue="false") int proNo, Model model) {
		System.out.println(proNo + "PRONO ");
		ps.selectProReviewListByProNo(proNo, model);
		
		model.addAttribute("iPage", "program/pro_review_list.jsp");
		return "index";

	}
	
	
	
	@RequestMapping(value = "/pro_review_write.gom", method = RequestMethod.POST)
	public String programReviewSubmit(ProReviewWriteCommand proReviewWriteCommand, Model model) {
		
		System.out.println(proReviewWriteCommand.getProReviewComment());
		System.out.println(proReviewWriteCommand.getProReviewImage());
		System.out.println(proReviewWriteCommand.getProReviewTitle());
		System.out.println(proReviewWriteCommand.getProReviewScore());
		System.out.println(proReviewWriteCommand.getProNo());
		System.out.println(proReviewWriteCommand.getCoachEmail());
		
		ps.programReviewWrite(proReviewWriteCommand, model);
		
		
		return "redirect:/index";

	}
	
	@RequestMapping(value = "/pro_review_write.gom", method = RequestMethod.GET)
	public String programReviewWrite(ProReviewWriteCommand proReviewWriteCommand, Model model) {
		
		
		model.addAttribute("ProReviewWriteCommand", proReviewWriteCommand);
		model.addAttribute("iPage", "program/pro_review_write.jsp");
		return "index";

	}
	
	
	
	@RequestMapping(value = "/program_detail.gom", method = RequestMethod.GET)
	public String programDetail(ProgramDetailCommand programDetailCommand/*, @RequestParam(value="proNo", defaultValue="false") int proNo*/, Model model ) {
		System.out.println(programDetailCommand.getProNo() + "PRONO by command! ");
		System.out.println(programDetailCommand.getProContent() + " PROCONTENT");
		
		
		model.addAttribute("iPage", "program/program_detail.jsp");
		model.addAttribute("ProgramDetailCommand", programDetailCommand);
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
