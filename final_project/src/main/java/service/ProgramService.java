package service;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import category.ExerciseCatA;
import category.ExerciseCatB;
import command.ProgramCommand;
import model.Program;
import model.ProgramExercise;
import repository.ProgramRepository;

@Service
public class ProgramService {
	String originalFile;
	String originalFileExtension;
	String storedFileName;
	Program program;
	ProgramExercise programExercise;
	MultipartFile multiFile;
	static final String filePath =
			"C:\\Users\\HKEDU\\Documents\\hkedu_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
//			"C:\\Users\\admin\\Documents\\final_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
	File file = new File(filePath);
	
	@Autowired
	ProgramRepository pr;

	
	public void insertProgram(ProgramCommand programCommand) {
		// TODO Auto-generated method stub
		
		//프로그램번호
		Integer result = pr.selectProgramNumber();
		
		System.out.println(result + " selectProgramNumber");
		
		//카테고리조건출력
		String exerciseCatAName = programCommand.getExerciseCatAName();
		String[] exerciseCatANames =  exerciseCatAName.split("/");
		
		List<ExerciseCatA> list = pr.selectCatByExerciseCatAName(exerciseCatANames);
		for(Object temp : list) {
			ExerciseCatA categoryA = (ExerciseCatA)temp;
			System.out.println(categoryA.getExerciseCatANumber() + " A");
			System.out.println(categoryA.getExerciseCatBNumber() + " B");
			System.out.println("-------------");
			
		}
		//List<DTO> 1:다 인서트. 하나의 프로그램번호에 여러개의 운동
		
		
		//파일저장
		multiFile = programCommand.getProImg();
		originalFile = multiFile.getOriginalFilename();
		originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
		file = new File(filePath + storedFileName);
		
		try {
			
			
			multiFile.transferTo(file);
			
			//프로그램 생성자
			//프로그램번호, 코치이메일, 프로그램이름, 사이즈, 오리지널, 저장된
			
			program = new Program(result, programCommand.getCoachEmail(), programCommand.getProName(), multiFile.getSize(), originalFile, storedFileName);
			System.out.println(program + "PROGRAM");
			program.setProRegdate(Calendar.getInstance().getTime());
			
			System.out.println(Calendar.getInstance().getTime() + "시간시간");
			
			int k= pr.insertProgram(program);
			
			if(k < 1) {
				System.out.println("프로그램 등록실패!");
			} else {
				System.out.println("프로그램 등록성공!");
			}
			
			//프로그램 운동
			//프로그램번호, 코치이메일, 운동번호, 카테고리A번호,카테고리B번호
			programExercise = new ProgramExercise(result, programCommand.getCoachEmail());
			int j = pr.insertProgramExercise(programExercise);
			
			if(j < 1) {
				System.out.println("프로그램운동 등록실패!");
			} else {
				System.out.println("프로그램운동 등록성공!");
			}
		
		} catch (Exception e) {
			
		}
		
	}


	public void exerciseCategoryB(Model model) {
		// TODO Auto-generated method stub
		List<ExerciseCatB> list = pr.exerciseCatBSelect();
		model.addAttribute("list", list);
	}
			
	public void exerciseCategoryA(ExerciseCatB bca, Model model) {
		// TODO Auto-generated method stub
		List<ExerciseCatA> list = pr.exerciseCatASelect(bca);
		model.addAttribute("list", list);
	}
	
}
