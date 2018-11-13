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
	public void dominoSelectA(FoodCatA foodCatA, Model model) {
		// TODO Auto-generated method stub
		List<FoodCatA> list = foodRepository.acaSelect(foodCatA);
		System.out.println("C service getFoodCatCNo : " + foodCatA.getFoodCatBNo());

		model.addAttribute("list", list);
		System.out.println("service A " + list.size());
	}

	public void dominoSelectB(FoodCatB foodCatB, Model model) {
		// TODO Auto-generated method stub
		System.out.println("B service getFoodCatCNo : " + foodCatB.getFoodCatCNo());
		List<FoodCatB> list = foodRepository.bcaSelect(foodCatB);
		
		model.addAttribute("list", list);
		System.out.println("service B " + list.size());
	}

	public void dominoSelectC(Model model) {
		// TODO Auto-generated method stub
		System.out.println("service C");
		List<FoodCatC> list = foodRepository.ccaSelect();
		System.out.println("service C " + list.size());
		model.addAttribute("list", list);
	}

	
}
