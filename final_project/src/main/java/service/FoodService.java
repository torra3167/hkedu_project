package service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import category.FoodCatA;
import category.FoodCatB;
import category.FoodCatC;
import command.FoodRegCommand;
import model.AuthInfo;
import model.Food;
import repository.FoodRepository;

@Service
public class FoodService {

	@Autowired
	private FoodRepository foodRepository;
	
	Food food;
	
	public Integer insertFood(FoodRegCommand foodRegCommand, HttpSession session) {
		System.out.println("service insertFood " + foodRegCommand.getFoodName());
		
		//foodNum 구하기
		Integer foodNum = foodRepository.selectFoodNumber();
		System.out.println("service insertFood FOOD NUMBER " + foodNum);
		if(foodNum == 0) {
			foodNum = 1;
		} else {
			foodNum = foodNum + 1;
		}
		System.out.println("service insertFood FOOD NUMBER " + foodNum);
		
		
		//foodSellerEmail 구하기
		AuthInfo ai = (AuthInfo) session.getAttribute("AuthInfo");
		ai.getEmail();
		System.out.println("service insertFood sellerEmail " + ai.getEmail());
		
		
		food = new Food(
				foodNum, 
				ai.getEmail(), 
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
				foodRegCommand.getFoodImage()
		);
		
		return foodRepository.insertFood(food);
	}
	
	/*public void foodCategoryA(FoodCatB bca, Model model) {
		List<FoodCatA> list = foodRepository.foodCatASelect(bca);
		model.addAttribute("list", list);
	}
	
	public void foodCategoryB(Model model) {
		List<ExerciseCatB> list = foodRepository.foodCatBSelect();
		model.addAttribute("list", list);
	}*/
	
	//FoodCatC < FoodCatB < FoodCatA
	public void dominoSelectA(FoodCatB foodCatB, Model model) {
		System.out.println("service " + foodCatB.getFoodCatBName());
		List<FoodCatA> list = foodRepository.foodCatASelect(foodCatB);
		model.addAttribute("list", list);
	}
	
	public void dominoSelectB(FoodCatC foodCatC, Model model) {
		System.out.println("service " + foodCatC.getFoodCatCNo());
		List<FoodCatB> list = foodRepository.foodCatBSelect(foodCatC);
		model.addAttribute("list", list);
	}
	
	public void dominoSelectC(Model model) {
		List<FoodCatC> list = foodRepository.foodCatCSelect();
		model.addAttribute("list", list);
	}

	
}
