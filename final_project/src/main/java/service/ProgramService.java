package service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import category.ExerciseCatA;
import category.ExerciseCatB;
import category.FoodCatC;
import command.ProgramCommand;
import command.ProgramDetailCommand;
import model.Program;
import model.ProgramExercise;
import model.ProgramExerciseUpload;
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
//			"C:\\Users\\FUTURE\\Documents\\hkedu_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
			"C:\\Users\\HKEDU\\Documents\\hkedu_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
//			"C:\\Users\\admin\\Documents\\hkedu_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
			File file = new File(filePath);
			
	@Autowired
	ProgramRepository pr;

	public void insertProgram(ProgramCommand programCommand) {
		// TODO Auto-generated method stub
		
		// 프로그램번호
		Integer programNumber = pr.selectProgramNumber();

		System.out.println(programNumber + " selectProgramNumber");
		
		// 운동프로그램식품등록 
		
		
		pr.selectFoodAndInsertProFood(programCommand, programNumber);
		
		// 파일저장
		multiFile = programCommand.getProImg();
		originalFile = multiFile.getOriginalFilename();
		originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
		file = new File(filePath + storedFileName);

		try {

			multiFile.transferTo(file);

			// 프로그램 생성자
			// 프로그램번호, 코치이메일, 프로그램이름, 사이즈, 오리지널, 저장된, 내용

			program = new Program(programNumber, programCommand.getCoachEmail(), programCommand.getProName(),
					multiFile.getSize(), originalFile, storedFileName, programCommand.getProContent());
			System.out.println(program + "PROGRAM");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
	        String regDate = sdf.format(Calendar.getInstance().getTime());
			program.setProRegdate(regDate);


			int k = pr.insertProgram(program);

			if (k < 1) {
				System.out.println("프로그램 등록실패!");
			} else {
				System.out.println("프로그램 등록성공!");
			}

			// 카테고리조건출력
			String exerciseCatAName = programCommand.getExerciseCatAName();
			String[] exerciseCatANames = exerciseCatAName.split("/");

			List<ExerciseCatA> list = pr.selectCatByExerciseCatAName(exerciseCatANames);
			for (Object temp : list) {
				ExerciseCatA categoryA = (ExerciseCatA) temp;
				System.out.println(categoryA.getExerciseCatANumber() + " A");
				System.out.println(categoryA.getExerciseCatBNumber() + " B");
				System.out.println("-------------");

			}
			
			System.out.println("LISTSIZE " + list.size());
			List<ProgramExercise> programList = new ArrayList<ProgramExercise>();
			
			for (int i = 0; i < list.size(); i++) {
				System.out.println(i +  "i");
				ExerciseCatA categoryA = list.get(i);
				System.out.println(categoryA.getExerciseCatAName());
				System.out.println(categoryA.getExerciseCatANumber());
				System.out.println(categoryA.getExerciseCatBNumber());

				// 각각의 카테고리번호에 따른 운동번호출력
				Integer exerciseNumber = pr.selectExerciseNumberByCategory(categoryA.getExerciseCatANumber());
				System.out.println(exerciseNumber + " exerciseNumber");
				// 프로그램 운동
				// 프로그램번호, 코치이메일, 운동번호, A카테고리번호, B카테고리번호
				programExercise = new ProgramExercise(programNumber, programCommand.getCoachEmail(), exerciseNumber,
						categoryA.getExerciseCatANumber(), categoryA.getExerciseCatBNumber());
				
				programList.add(programExercise);
			}
			
			// List<DTO> 1:다 인서트. 하나의 프로그램번호에 여러개의 운동
			
			int j = pr.insertProgramExercise(programList);
			if (j < 1) {
				System.out.println("프로그램운동 등록실패!");
			} else {
				System.out.println("프로그램운동 등록성공!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void exerciseCategoryB(Model model) {
		// TODO Auto-generated method stub
		List<ExerciseCatB> list = pr.exerciseCatBSelect();
		model.addAttribute("exerciselist", list);
	}

	public void exerciseCategoryA(ExerciseCatB bca, Model model) {
		// TODO Auto-generated method stub
		List<ExerciseCatA> list = pr.exerciseCatASelect(bca);
		model.addAttribute("exerciselist", list);
	}

	public void programList(Model model) {
		// TODO Auto-generated method stub
		List<Program> list = pr.programList();
		model.addAttribute("Program", list);
	}

	public void programDetail(ProgramDetailCommand programDetailCommand, Model model) {
		// TODO Auto-generated method stub
		List<ProgramExercise> list = pr.selectByProgramNumber(programDetailCommand.getProNo());
		model.addAttribute("ProgramExercise", list);
		
		
		List<ProgramExerciseUpload> programExerciseUpload = pr.selectProgramExerciseUpload(programDetailCommand.getProNo());
		/*exerciseUpload.setProContent(programDetailCommand.getProContent());
		exerciseUpload.setProNo(programDetailCommand.getProNo());*/
		
		for(Object temp : programExerciseUpload) {
			ProgramExerciseUpload peu = (ProgramExerciseUpload)temp;
			System.out.println(peu.getExerciseContent() + "SERVICE EXERCISECONTENT!!!");
		}
		
		model.addAttribute("ProgramExerciseUpload", programExerciseUpload);
		model.addAttribute("ProgramDetailCommand", programDetailCommand);
		
	}

	public List<FoodCatC> dominoSelectC() {
		List<FoodCatC> list = pr.ccaSelect();
		return list;
	}

}
