package controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import category.ExerciseCatB;
import command.ExerciseCommand;
import service.ExerciseService;

@Controller
public class ExerciseController {

	@Autowired
	private ExerciseService es;
	
	
	
	@RequestMapping(value="/exercise_list.gom", method=RequestMethod.GET)
	public String list(Model model) throws Exception{
	    
		es.exerciseList(model);
		model.addAttribute("iPage", "exercise/exercise_list.jsp");
	    return "index";

	}
	
	@RequestMapping(value="/exercise_register.gom", method=RequestMethod.GET)
	public String insertExercise(ExerciseCommand exerciseCommand, Model model) throws Exception{
	    
		es.exerciseCategoryB(model);
		model.addAttribute("iPage", "exercise/exercise_register.jsp");
	    return "index";

	}

	@RequestMapping(value="/exercise_register.gom", method=RequestMethod.POST )
	public String ExerciseSubmit(ExerciseCommand exerciseCommand, Model model
			) {
		/*ExerciseCommand exerciseCommand = new ExerciseCommand();
		exerciseCommand.setExerciseCatANumber(Integer.parseInt(multiRequest.getParameter("exerciseCatANumber")));
		exerciseCommand.setExerciseCatBNumber(Integer.parseInt(multiRequest.getParameter("exerciseCatBNumber")));
		exerciseCommand.setExerciseFile(multiRequest.getFile("exerciseFile"));*/
		
		
		System.out.println(exerciseCommand.getExerciseFile() + " 파일");
		System.out.println(exerciseCommand.getExerciseCatANumber() + "CATA");
		System.out.println(exerciseCommand.getExerciseCatBNumber() + "CATB");
		
		boolean result = es.insertExercise(exerciseCommand, model);
		
	    if(!result) {
			System.out.println("파일이 저장되지않았습니다");
	    	return "index";
			
		}else {
			System.out.println("파일저장성공!");
			return "index";
		}
		
		
		
		
	}
	
	@RequestMapping(value="/aca.gom", method=RequestMethod.POST)
	public String bca(ExerciseCatB bca, Model model) {
//		System.out.println("B category " + bca.getExerciseCatBNumber());
		
		es.exerciseCategoryA(bca, model);
/*		model.addAttribute("iPage", "exercise/category/exercise_cat_a");
*/		return "exercise/category/exercise_cat_a";
	}

}
