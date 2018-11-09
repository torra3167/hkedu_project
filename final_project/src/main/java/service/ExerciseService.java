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
import model.ExerciseUpload;
import model.MemberSurvey;
import repository.ExerciseRepository;

public class ExerciseService {
	
	@Autowired
	ExerciseRepository er;
	
	
	static final String filePath = 
			"C:\\Users\\HKEDU\\Documents\\hkedu_project\\final_project\\src\\main\\webapp\\WEB-INF\\exercise\\file\\";
	File file = new File(filePath);
	String originalFile;
	String originalFileExtension;
	String storedFileName;
	String image;
	String video;
	String name;
	int exerciseNumber;
	MultipartFile multipartFile;
	
	public boolean insertExercise(ExerciseCommand exerciseCommand, Model model)  {
		ExerciseUpload eu;
		image = exerciseCommand.getExerciseImg();
		video = exerciseCommand.getExerciseVideo();
		name = exerciseCommand.getExerciseName();
		originalFile = multipartFile.getOriginalFilename();
		originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
		file = new File(filePath + storedFileName);
		try {
			multipartFile.transferTo(file);
			eu = new ExerciseUpload(exerciseNumber, multipartFile.getSize(), originalFile, storedFileName);
			
			int i = er.insertExercise(eu);
			
			if(i < 1) {
				System.out.println("멤버등록실패!");
			} else {
				System.out.println("멤버등록성공!");
				
				System.out.println(exerciseNumber + "가 업로드한 파일은 studentNumber");
				System.out.println(originalFile + "가 업로드 한 파일입니다. originalFile");
				System.out.println(storedFileName + "로 업로드되었음 storedFileNAME");
				System.out.println("파일사이즈는 " + multipartFile.getSize());
				model.addAttribute("ExerciseUpload", eu);
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
	
	
}

