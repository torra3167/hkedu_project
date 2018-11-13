package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import category.FoodCatB;
import category.FoodCatC;
import command.FoodRegCommand;
import service.FoodService;

@Controller
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@RequestMapping(value="/food_reg.gom", method=RequestMethod.GET)
	public String foodRegForm(Model model) {
//		foodService.foodCategoryB(model);
		model.addAttribute("iPage", "food/food_reg.jsp");
		return "index";
	}
	
	@RequestMapping(value="/food_reg.gom", method=RequestMethod.POST)
	public String foodRegSubmit(FoodRegCommand foodRegCommand,  Model model, HttpSession session) { 
		System.out.println("controller form에서 온 foodRegCommand" + foodRegCommand.getFoodName());
		Integer result = null;		
		result = foodService.insertFood(foodRegCommand, session);
		if(result>0) {
			model.addAttribute("result", result);
			return "index";
		}else {
			return "redirect:/index";
		}
	}
	
	/*@RequestMapping(value="/FoodAca.gom", method=RequestMethod.POST)
	public String bca(FoodCatB bca, Model model) {
		
		foodService.foodCategoryA(bca, model);
		return "food/category/food_cat_a";
	}*/
	
	
	@RequestMapping(value="/domino.gom", method=RequestMethod.GET)
	public String domino(Model model) {
		foodService.dominoSelectC(model);
		return "food/food_reg"; 
	}
	
	@RequestMapping(value="/foodCatB.gom", method=RequestMethod.POST)
	public String bca(FoodCatC foodCatC, Model model) {
		System.out.println("B category " + foodCatC.getFoodCatCNo());
		foodService.dominoSelectB(foodCatC, model);
		return "category/food_cat_b";
	}
	
	@RequestMapping(value="/foodCatA.gom", method=RequestMethod.POST)
	public String Cca(FoodCatB foodCatB, Model model) {
		System.out.println("CommentController  Bnum" + foodCatB.getFoodCatBNo());
		foodService.dominoSelectA(foodCatB, model);
		
		return "category/food_cat_a";
	}
	
}
