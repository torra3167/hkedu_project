package service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import category.ExerciseCatA;
import category.ExerciseCatB;
import command.ExerciseCommand;
import model.Exercise;
import repository.ExerciseRepository;

public class ExerciseService {
	Exercise exercise;
	/*"http://localhost:8080/final_project/exercise/file/"*/
	static final String filePath =
			"C:\\Users\\Future\\Desktop\\프로젝트\\hkedu_project\\final_project\\src\\main\\webapp\\resource\\";
	File file = new File(filePath);
	String originalFile;
	String originalFileExtension;
	String storedFileName;
	
	MultipartFile exerciseFile;
	
	
	
	
	@Autowired
	ExerciseRepository er;
	

	public boolean insertExercise(ExerciseCommand exerciseCommand, Model model)  {
		Integer result = er.selectExerciseNumber();
		System.out.println("EXERCISE NUMBER " + result);
		if(result == 0) {
			result = 1;
		} else {
			result = result + 1;
		}
		System.out.println("EXERCISE NUMBER " + result);

		
		
		exerciseFile = exerciseCommand.getExerciseFile();
		System.out.println(exerciseFile + " EXERCISEFILE");
	
		originalFile = exerciseFile.getOriginalFilename();
		originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
		file = new File(filePath + storedFileName);
		try {
			exerciseFile.transferTo(file);
			exercise = new Exercise(result, exerciseCommand.getExerciseCatANumber(), exerciseCommand.getExerciseCatBNumber(),
					exerciseFile.getSize(), originalFile, storedFileName, "i");
			
			
			int i = er.insertExercise(exercise);
			
			if(i < 1) {
				System.out.println("멤버등록실패!");
			} else {
				System.out.println("멤버등록성공!");
				
				System.out.println(exercise.getExerciseNumber() + "가 업로드한 파일은 ExerciseNumber");
				System.out.println(originalFile + "가 업로드 한 파일입니다. originalFile");
				System.out.println(storedFileName + "로 업로드되었음 storedFileNAME");
				System.out.println("파일사이즈는 " + exerciseFile.getSize());
				return true;
			}
		} catch(Exception e) {
			
		}
		
		return false;
	}

	public void exerciseCategoryB(Model model) {
		// TODO Auto-generated method stub
		List<ExerciseCatB> list = er.exerciseCatBSelect();
		model.addAttribute("list", list);
	}
	
	public void exerciseCategoryA(ExerciseCatB bca, Model model) {
		// TODO Auto-generated method stub
		List<ExerciseCatA> list = er.exerciseCatASelect(bca);
		model.addAttribute("list", list);
	}

	public void exerciseList(Model model) {
		// TODO Auto-generated method stub
		List<Exercise> list = er.exerciseList();   
		model.addAttribute("Exercise", list);
	}
	
	
}

