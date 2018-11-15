package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import category.FoodCatA;
import category.FoodCatB;
import category.FoodCatC;
import command.FoodRegCommand;
import command.FoodUpdateCommand;
import service.FoodService;

@Controller
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
//	@RequestMapping(value="/food_reg.gom", method=RequestMethod.GET)
//    public String foodRegForm(FoodRegCommand foodRegCommand, Model model) {
//		System.out.println("foodRegForm nnnnnnnnnnnnnnnnnnnnnnnnnnn"+foodRegCommand.getFoodNo());
//		foodService.dominoSelectC(model);
//		model.addAttribute("iPage", "food/food_reg.jsp");
//		return "index";
//	}
	
	@RequestMapping(value="/food_reg.gom", method=RequestMethod.POST)
	public String foodRegSubmit(FoodRegCommand foodRegCommand, HttpSession session) { 
		System.out.println("foodRegForm yyyyyyyyyyyyyyyyyyyyyyyyyyy"+foodRegCommand.getFoodNo());
//        System.out.println("cntlr foodRegCommand.getFoodName : " + foodRegCommand.getFoodName());
        foodService.insertFood(foodRegCommand, session);
        System.out.println("food_cntlr foodNo : " + foodRegCommand.getFoodNo());
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
	
	@RequestMapping(value="/seller_foodDetail.gom", method=RequestMethod.GET)
	public String sellerFoodDetail(@RequestParam("foodNo")int foodNo, Model model) {
//		System.out.println("cntlr sellerFoodDetail");
//		System.out.println("cntlr foodNo : "+foodNo);
		
		foodService.selectSellerFood(foodNo, model);
		
		
		model.addAttribute("iPage", "seller/seller_foodDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value="/food_update.gom", method=RequestMethod.GET)
    public String foodUpdateForm(FoodUpdateCommand foodUpdateCommand, Model model) {
//		System.out.println("foodUpdateForm foodNo : " +  foodUpdateCommand.getFoodNo());
//		System.out.println("foodUpdateForm foodName : " +  foodUpdateCommand.getFoodName());
		
		//등록식품 수정에 사용
		List<FoodCatC> list = foodService.dominoSelectC(model);
		model.addAttribute("foodCat", list);	
		
		model.addAttribute("iPage", "food/food_update.jsp");
		return "index";
	}
	
	@RequestMapping(value="/food_update.gom", method=RequestMethod.POST)
	public String foodUpdateSubmit(FoodUpdateCommand foodUpdateCommand) { 
		System.out.println("foodUpdateSubmit foodNo : " + foodUpdateCommand.getFoodNo());
//		System.out.println("foodUpdateSubmit foodName : " + foodUpdateCommand.getFoodName());
		
        foodService.updateFood(foodUpdateCommand);
        return "index";/*"redirect:/index";*/
	}
	
	
	
}
