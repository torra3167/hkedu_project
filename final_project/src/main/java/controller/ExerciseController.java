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

import service.ExerciseService;

@Controller
public class ExerciseController {

	@Autowired
	private ExerciseService es;
	
	@RequestMapping(value="/exercise_register.gom")
	public String insertExercise(ExerciseCommand exerciseCommand, HttpServletRequest request, Model model) throws Exception{
	     
		model.addAttribute("iPage", "exercise/exercise_register.jsp");
	    return "index";
	}

	@RequestMapping(value="/exercise_register.gom", method=RequestMethod.POST )
	public String ExerciseSubmit(ExerciseCommand exerciseCommand, Model model
			) {
		System.out.println(exerciseCommand.getExerciseImg() + " 이미지");
		System.out.println(exerciseCommand.getExerciseVideo() + " 비디오");
		System.out.println(exerciseCommand.getExerciseName() + " 이름");
		boolean result = es.insertExercise(exerciseCommand, model);
		
	    if(!result) {
			System.out.println("파일이 저장되지않았습니다");
	    	return "exercise_register.gom";
			
		}else {
			System.out.println("파일저장성공!");
			return "index";
		}
		
		
		
		
	}

}
