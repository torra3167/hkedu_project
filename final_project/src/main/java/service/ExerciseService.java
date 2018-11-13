package service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import category.ExerciseCatA;
import category.ExerciseCatB;
import command.UploadCommand;
import model.Exercise;
import model.Upload;
import repository.ExerciseRepository;

public class ExerciseService {
	Upload upload;
	Exercise exercise;
	/*"http://localhost:8080/final_project/exercise/file/"*/
	static final String filePath =
//			"C:\\Users\\HKEDU\\Documents\\hkedu_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
			"C:\\Users\\admin\\Documents\\final_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
			File file = new File(filePath);
	String originalFile;
	String originalFileExtension;
	String storedFileName;
	String uploadDivide;
	
	
	MultipartFile multiFile;
	
	
	
	
	@Autowired
	ExerciseRepository er;
	

	public void insertExercise(UploadCommand uploadCommand)  {
		Integer result = er.selectExerciseNumber();
		System.out.println();
		List<MultipartFile> uploadImage 
		= (List<MultipartFile>) uploadCommand.getUploadImage();
		
		//운동 
		exercise = new Exercise(result, uploadCommand.getExerciseCatANumber(),
				uploadCommand.getExerciseCatBNumber(), uploadCommand.getExerciseContent());
		
		int j = er.insertExercise(exercise);
		
		List<Upload> list = new ArrayList<Upload>();
	
	
		for(int i = 0 ; i < uploadImage.size(); i++) {
			
			multiFile = uploadImage.get(i);
			
			originalFile = multiFile.getOriginalFilename();
			
			originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
			storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
			file = new File(filePath + storedFileName);
			
			try {
				multiFile.transferTo(file);
				
				System.out.println("EXERCISE NUMBER " + result);
				
				
				//업로드
				upload = new Upload(result, uploadCommand.getExerciseCatANumber(), uploadCommand.getExerciseCatBNumber(),
						multiFile.getSize(), originalFile, storedFileName, "i");
				
				list.add(upload);
				
				int k = er.insertUpload(list);
				
				
				if(k < 1) {
					System.out.println("멤버등록실패!");
				} else {
					System.out.println("멤버등록성공!");
					
					
				/*	System.out.println(uploadCommand.getExerciseNumber() + "가 업로드한 파일은 ExerciseNumber");
					System.out.println(originalFile + "가 업로드 한 파일입니다. originalFile");
					System.out.println(storedFileName + "로 업로드되었음 storedFileNAME");
					System.out.println("파일사이즈는 " + multiFile.getSize());*/
					
				}
			} catch(Exception e) {
				
			} 
			
			System.out.println("VIDEO " + uploadCommand.getUploadVideo());
			
			multiFile = uploadCommand.getUploadVideo();

			originalFile = multiFile.getOriginalFilename();
			
			originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
			storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
			file = new File(filePath + storedFileName);
			
			try {
				multiFile.transferTo(file);
				upload = new Upload(result, uploadCommand.getExerciseCatANumber(), uploadCommand.getExerciseCatBNumber(),
						multiFile.getSize(), originalFile, storedFileName, "v");
				list.add(upload);
				
				int l = er.insertUpload(list);
				
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
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
		List<Upload> list = er.exerciseList();   
		model.addAttribute("Upload", list);
	}
	
	
}

