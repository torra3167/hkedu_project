package service;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import category.FoodCatA;
import category.FoodCatB;
import category.FoodCatC;
import command.FoodRegCommand;
import model.AuthInfo;
import model.Food;
import model.Program;
import model.ProgramExercise;
import repository.FoodRepository;



@Service
public class FoodService {

	@Autowired
	private FoodRepository foodRepository;
	
	Food food;
	
	String originalFile;
	String originalFileExtension;
	String storedFileName;
	MultipartFile multiFile;
	static final String filePath =
//			"C:\\Users\\HKEDU\\Documents\\hkedu_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
			"C:\\Users\\HKEDU\\Documents\\hkedu_project\\final_project\\src\\main\\webapp\\WEB-INF\\resource\\";
	File file = new File(filePath);
	
	public void insertFood(FoodRegCommand foodRegCommand, HttpSession session) {
		System.out.println("service insertFood " + foodRegCommand.getFoodName());
		
		//foodNum
		Integer foodNum = foodRepository.selectFoodNumber();
		System.out.println("service insertFood FOOD NUMBER " + foodNum);
		if(foodNum == 0) {
			foodNum = 1;
		} else {
			foodNum = foodNum + 1;
		}
		System.out.println("service insertFood FOOD NUMBER " + foodNum);
		
		
		//foodSellerEmail
		String ai = (String) session.getAttribute("email");
		System.out.println("service insertFood sellerEmail " + ai);
		
		//foodImage
		multiFile = foodRegCommand.getFoodImage();
		originalFile = multiFile.getOriginalFilename();
		originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
		file = new File(filePath + storedFileName);
		
		try {
			multiFile.transferTo(file);
			
			food = new Food(
					foodNum,
					ai,
					foodRegCommand.getFoodCatANo(), 
					foodRegCommand.getFoodCatBNo(), 
					foodRegCommand.getFoodCatCNo(), 
					foodRegCommand.getFoodName(),
					foodRegCommand.getFoodQuant(),
					foodRegCommand.getFoodExpiryDate(),
					foodRegCommand.getFoodOrigin(),
					foodRegCommand.getFoodSale(),
					foodRegCommand.getFoodFlavor(),
					foodRegCommand.getFoodPrice(),
					foodRegCommand.getFoodCarbo(),
					foodRegCommand.getFoodProtein(),
					foodRegCommand.getFoodFat(),
					foodRegCommand.getFoodCal(), 
					multiFile.getSize(), 
					originalFile, 
					storedFileName
					);
			System.out.println(food + "FOOD");
			
			int k= foodRepository.insertFood(food);
			
			if(k < 1) {
				System.out.println("프로그램 등록실패!");
			} else {
				System.out.println("프로그램 등록성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//FoodCatC < FoodCatB < FoodCatA
	public List<FoodCatC> dominoSelectC(Model model) {
//		System.out.println("service C 실행");
		List<FoodCatC> list = foodRepository.ccaSelect();
//		System.out.println("service C 반환된 list size : " + list.size());
		return list;
//		model.addAttribute("list", list);	//seller_menu 열리는 sellerCntlr에서 생성
	}
	
	public void dominoSelectB(FoodCatB foodCatB, Model model) {
//		System.out.println("service B 실행, FoodCatCNo : " + foodCatB.getFoodCatCNo());
		List<FoodCatB> list = foodRepository.bcaSelect(foodCatB);
//		System.out.println("service B 반환된 list size : " + list.size());
		model.addAttribute("list", list);
	}
	
	public void dominoSelectA(FoodCatA foodCatA, Model model) {
//		System.out.println("service A 실행, FoodCatBNo : " + foodCatA.getFoodCatBNo());
		List<FoodCatA> list = foodRepository.acaSelect(foodCatA);
//		System.out.println("service A 반환된 list size : " + list.size());
		model.addAttribute("list", list);
	}

}
