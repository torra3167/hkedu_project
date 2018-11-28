package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import category.ExerciseCatACatB;
import category.ExerciseCatB;
import command.ExerciseUpdateCommand;
import command.UploadCommand;
import command.UploadUpdateCommand;
import model.ExerciseRecord;
import service.ExerciseService;

@Controller
public class ExerciseController {

	@Autowired
	private ExerciseService es;
	
	
	@RequestMapping(value="/exercise_record_reg.gom", method=RequestMethod.GET)
	public String exerciseRecordReg(ExerciseRecord exerciseRecord, Model model) {
	    
		
		model.addAttribute("iPage", "exercise/exercise_record_reg.jsp");
	    return "index";

	}
	
	@RequestMapping(value="/exercise_record.gom", method=RequestMethod.GET)
	public String exerciseRecord(ExerciseRecord exerciseRecord, Model model, HttpSession session) {
	    
		String memberEmail = (String)session.getAttribute("email");
		es.selectProPayByMemberEmail(memberEmail, model);

		model.addAttribute("iPage", "exercise/exercise_record.jsp");
	    return "index";

	}
	
	@RequestMapping(value="/upload_update.gom", method=RequestMethod.GET)
	public String updateForm(UploadUpdateCommand uploadUpdateCommand, Model model) {
	    
		//카테고리
		ExerciseCatACatB exerciseCatACatB = es.selectExerciseCatNames(uploadUpdateCommand.getExerciseCatANumber(), uploadUpdateCommand.getExerciseCatBNumber()
				,model);
		uploadUpdateCommand.setExerciseCatAName(exerciseCatACatB.getExerciseCatAName());
		uploadUpdateCommand.setExerciseCatBName(exerciseCatACatB.getExerciseCatBName());
		
		
		model.addAttribute("iPage", "upload/upload_update.jsp");
		model.addAttribute("UploadUpdateCommand", uploadUpdateCommand);
	    return "index";

	}
	
	@RequestMapping(value="/upload_update.gom", method=RequestMethod.POST)
	public String updateSubmit(UploadUpdateCommand uploadUpdateCommand) {
		System.out.println(uploadUpdateCommand.getExerciseCatANumber());
		System.out.println(uploadUpdateCommand.getExerciseCatBNumber());
		System.out.println(uploadUpdateCommand.getUploadStored());
		System.out.println(uploadUpdateCommand.getUploadOriginal());
		
		
		
		es.updateUpload(uploadUpdateCommand);
		
	    return "redirect:/index";

	}
	
	@RequestMapping(value="/exercise_update.gom", method=RequestMethod.POST)
	public String exerciseUpdateSubmit(ExerciseUpdateCommand exerciseUpdateCommand, Model model) {
	    
		
		es.exerciseUpdate(exerciseUpdateCommand);
	    return "redirect:/index";

	}
	
	@RequestMapping(value="/exercise_update.gom", method=RequestMethod.GET)
	public String exerciseUpdate(ExerciseUpdateCommand exerciseUpdateCommand, Model model) {
	    System.out.println("EXERCISE UPDATE CON");
		es.exerciseCategoryB(model);
		model.addAttribute("iPage", "exercise/exercise_update.jsp");
		model.addAttribute("ExerciseUpdateCommand", exerciseUpdateCommand);
	    return "index";

	}
	@RequestMapping(value="/exercise_detail.gom", method=RequestMethod.GET)
	public String detail(UploadCommand uploadCommand, Model model) {
	    
/*		es.exerciseSelectOne(exerciseCommand.getExerciseNumber());
		System.out.println(uploadCommand.getExerciseNumber() +  " NUMBER");
*/		model.addAttribute("iPage", "exercise/exercise_detail.jsp");
	    return "index";

	}
	@RequestMapping(value="/exercise_list.gom", method=RequestMethod.GET)
	public String list(Model model) {
	    
		es.exerciseList(model);
		model.addAttribute("iPage", "exercise/exercise_list.jsp");
	    return "index";

	}
	
	@RequestMapping(value="/exercise_register.gom", method=RequestMethod.GET)
	public String insertExercise(UploadCommand uploadCommand, Model model) throws Exception{
	    
		es.exerciseCategoryB(model);
		model.addAttribute("iPage", "exercise/exercise_register.jsp");
	    return "index";

	}

	@RequestMapping(value="/exercise_register.gom", method=RequestMethod.POST )
	public String ExerciseSubmit(UploadCommand uploadCommand, Model model
			) {
		/*int exerciseCatBNumber = Integer.parseInt(request.getParameter("exerciseCatBNumber"));
		int exerciseCatANumber = Integer.parseInt(request.getParameter("exerciseCatANumber"));*/
		
		/*
		System.out.println(uploadCommand.getExerciseCatANumber() + "CATA");
		System.out.println(uploadCommand.getExerciseCatBNumber() + "CATB");*/
		
	
		
		es.insertExercise(uploadCommand);
		
		return "redirect:/index";

		
		
		
		
	}
	
	@RequestMapping(value="/aca.gom", method=RequestMethod.POST)
	public String bca(ExerciseCatB bca, Model model) {
//		System.out.println("B category " + bca.getExerciseCatBNumber());
		
		es.exerciseCategoryA(bca, model);
/*		model.addAttribute("iPage", "exercise/category/exercise_cat_a");
*/		return "exercise/category/exercise_cat_a";
	}
	
	

}
