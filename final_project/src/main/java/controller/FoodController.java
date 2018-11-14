package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import category.FoodCatA;
import category.FoodCatB;
import category.FoodCatC;
import command.FoodRegCommand;
import service.FoodService;

@Controller
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@RequestMapping(value="/food_reg.gom", method=RequestMethod.GET)
    public String foodRegForm(FoodRegCommand foodRegCommand, Model model) {
//		foodService.dominoSelectC(model);
		model.addAttribute("iPage", "food/food_reg.jsp");
		return "index";
	}
	
	@RequestMapping(value="/food_reg.gom", method=RequestMethod.POST)
	public String foodRegSubmit(FoodRegCommand foodRegCommand,  Model model, HttpSession session) { 
        System.out.println("cntlr foodRegCommand.getFoodName : " + foodRegCommand.getFoodName());
        foodService.insertFood(foodRegCommand, session);
        return "redirect:/index";
	}
		
	@RequestMapping(value="/bca.gom", method=RequestMethod.POST)
	public String bca(FoodCatB foodCatB, Model model, HttpServletRequest request) {
//		System.out.println( "B contoller getFoodCatCNo : " + foodCatB.getFoodCatCNo());
		foodService.dominoSelectB(foodCatB, model);
		
		return "food/food_cat_b";
	}
	
	@RequestMapping(value="/cca.gom", method=RequestMethod.POST)
	public String Cca(FoodCatA foodCatA, Model model) {
//		System.out.println("C controller getFoodCatBNo : " + foodCatA.getFoodCatBNo());
		foodService.dominoSelectA(foodCatA, model);
		
		return "food/food_cat_a";
	}
	
	
}
