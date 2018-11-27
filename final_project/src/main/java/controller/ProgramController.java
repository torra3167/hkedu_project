package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import category.FoodCatC;
import command.ProgramCommand;
import command.ProgramDetailCommand;
import model.ProFood;
import service.ProgramService;

@Controller
public class ProgramController {
	@Autowired
	private ProgramService ps;
	
	

	
	
	@RequestMapping(value = "/program_approve.gom", method = RequestMethod.GET)
	public String proApprove(@RequestParam(value="proNo")int proNo , Model model ) {

		
		ps.proUpdateApprove(model, proNo);

		return "index";

	}
	
	@RequestMapping(value = "/program_reject.gom", method = RequestMethod.GET)
	public String proReject(@RequestParam(value="proNo")int proNo , @RequestParam(value="proDes")String proDes, Model model ) {

		System.out.println(proDes);
		ps.proUpdateReject(model, proNo, proDes);

		return "redirect:/index";

	}
	
	
	
	@RequestMapping(value = "/pro_food_list_detail.gom", method = RequestMethod.GET)
	public String proFoodList(@RequestParam(value="proFoodNo")int proFoodNo , Model model ) {

		
		ps.selectFoodProFoodOneByProFoodNo(model, proFoodNo);
		model.addAttribute("iPage", "pro_food/pro_food_detail.jsp");

		return "index";

	}
	
	@RequestMapping(value = "/pro_food_list.gom", method = RequestMethod.GET)
	public String proFoodList(ProFood proFood, Model model ) {

		
		model.addAttribute("iPage", "pro_food/pro_food_list.jsp");
		ps.selectProFoodList(model);
		return "index";

	}
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
		List<FoodCatC> list = ps.dominoSelectC();
		model.addAttribute("foodCat", list);
		model.addAttribute("iPage", "program/program_register.jsp");
		return "index";

	}

	@RequestMapping(value = "/program_register.gom", method = RequestMethod.POST)
	public String programSubmit(ProgramCommand programCommand, @RequestParam(value="foodNos")String foodNos,  HttpSession session, Model model) {

		System.out.println("CAT NAME " + programCommand.getExerciseCatAName());
		String coachEmail = (String) session.getAttribute("email");

		programCommand.setCoachEmail(coachEmail);

		System.out.println(programCommand.getProImg() + " PRO IMG");
		System.out.println(programCommand.getProName() + " PRO NAME");
		System.out.println(programCommand.getCoachEmail() + " COACHEMAIL");

		String[] selectedFoodNos = foodNos.split("/");
		
		ps.insertProgram(programCommand, selectedFoodNos);
		
		return "redirect:/index";

	}

}
