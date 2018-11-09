package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.ExerciseCommand;
import command.LoginCommand;
import model.AuthInfo;
import service.ExerciseService;

@Controller
public class ExerciseController {

	@Autowired
	private ExerciseService es;
	
	@RequestMapping(value="/exercise_register.gom")
	public String insertBoard(ExerciseCommand exerciseCommand, HttpServletRequest request, Model model) throws Exception{
	     
		model.addAttribute("iPage", "exercise/exercise_register.jsp");
	    return "index";
	}

	@RequestMapping(value="/exercise_register.gom", method=RequestMethod.POST )
	public String CoachSubmit(ExerciseCommand exerciseCommand, Model model, 
			HttpServletRequest request) {
		
		Integer result = es.insertExercise(exerciseCommand);
		
	    if(result>0) {
			
			return "index";
		}else {
			return "exercise_register.gom";
		}
		
		
		
		
	}

}
