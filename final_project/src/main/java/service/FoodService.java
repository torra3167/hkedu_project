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
import command.FoodUpdateCommand;
import model.AuthInfo;
import model.Food;
import model.Program;
import model.ProgramExercise;
import model.Upload;
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
	
	
	
	
	
	public void sellerFoodList(Model model, String sellerEmail) {
		List<Food> list = foodRepository.sellerFoodList(sellerEmail);  
		
//		for(Object temp : list) {
//			 Food food = (Food)temp;
//			 System.out.println("service foodNo : "+food.getFoodNo());
//		}
		
		model.addAttribute("sellerFoodList", list);
	}
	
	public void insertFood(FoodRegCommand foodRegCommand, HttpSession session) {
		//System.out.println("service insertFood " + foodRegCommand.getFoodName());
		
		//foodNum
		Integer foodNum = foodRepository.selectFoodNumber();
		System.out.println("service insertFood FOOD NUMBER " + foodNum);
		if(foodNum == 0) {
			foodNum = 1;
		} else {
			foodNum = foodNum + 1;
		}
		System.out.println("service insertFood FOOD NUMBER " + foodNum);
		foodRegCommand.setFoodNo(foodNum);
		
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
			System.out.println(food + " : FOOD");
			
			int k = foodRepository.insertFood(food);
			
			if(k < 1) {
				System.out.println("식품 등록실패!");
			} else {
				System.out.println("식품 등록성공!");
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
		model.addAttribute("foodCat", list);
	}
	
	public void dominoSelectA(FoodCatA foodCatA, Model model) {
//		System.out.println("service A 실행, FoodCatBNo : " + foodCatA.getFoodCatBNo());
		List<FoodCatA> list = foodRepository.acaSelect(foodCatA);
//		System.out.println("service A 반환된 list size : " + list.size());
		model.addAttribute("foodCat", list);
	}

	public void selectSellerFood(int foodNo, Model model) {
		// TODO Auto-generated method stub
		Food food = foodRepository.selectSellerFood(foodNo);
		model.addAttribute("sellerFood", food);
	}

	public void updateFood(FoodUpdateCommand foodUpdateCommand) {
		// TODO Auto-generated method stub
		System.out.println("svc : " + foodUpdateCommand.getFoodNo());
		System.out.println("svc : " + foodUpdateCommand.getFoodName());
		System.out.println("svc : " + foodUpdateCommand.getFoodPrice());
		System.out.println("svc : " + foodUpdateCommand.getFoodSale());
		System.out.println("svc : " + foodUpdateCommand.getFoodFlavor());
		System.out.println("svc : " + foodUpdateCommand.getFoodQuant());
		System.out.println("svc : " + foodUpdateCommand.getFoodExpiryDate());
		System.out.println("svc : " + foodUpdateCommand.getFoodOrigin());
		System.out.println("svc : " + foodUpdateCommand.getFoodCarbo());
		System.out.println("svc : " + foodUpdateCommand.getFoodProtein());
		System.out.println("svc : " + foodUpdateCommand.getFoodFat());
		System.out.println("svc : " + foodUpdateCommand.getFoodCal());
		System.out.println("svc : " + foodUpdateCommand.getFoodCatANo());
		System.out.println("svc : " + foodUpdateCommand.getFoodCatBNo());
		System.out.println("svc : " + foodUpdateCommand.getFoodCatCNo());
		
		
		//foodImage
		multiFile = foodUpdateCommand.getFoodImage();
		originalFile = multiFile.getOriginalFilename();
		originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
		file = new File(filePath + storedFileName);
		
		try {
			multiFile.transferTo(file);
			food = new Food();
			food.setFoodNo(foodUpdateCommand.getFoodNo());
			food.setFoodName(foodUpdateCommand.getFoodName());
			food.setFoodPrice(foodUpdateCommand.getFoodPrice());
			food.setFoodSale(foodUpdateCommand.getFoodSale());
			food.setFoodFlavor(foodUpdateCommand.getFoodFlavor());
			food.setFoodQuant(foodUpdateCommand.getFoodQuant());
			food.setFoodExpiryDate(foodUpdateCommand.getFoodExpiryDate());
			food.setFoodOrigin(foodUpdateCommand.getFoodOrigin());
			food.setFoodCarbo(foodUpdateCommand.getFoodCarbo());
			food.setFoodProtein(foodUpdateCommand.getFoodProtein());
			food.setFoodFat(foodUpdateCommand.getFoodFat());
			food.setFoodCal(foodUpdateCommand.getFoodCal());
			food.setFoodCatANo(foodUpdateCommand.getFoodCatANo());
			food.setFoodCatBNo(foodUpdateCommand.getFoodCatBNo());
			food.setFoodCatCNo(foodUpdateCommand.getFoodCatCNo());
			food.setFoodSize(multiFile.getSize());
			food.setFoodOriginal(originalFile);
			food.setFoodStored(storedFileName);
			System.out.println(food + " : FOOD");
			
			int k = foodRepository.updateFood(food);
			
			if(k < 1) {
				System.out.println("식품변경 실패");
			} else {
				System.out.println("식품변경 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
}
