package controller;

import java.util.List;

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
import command.FoodReviewAnswerUpdateCommand;
import command.FoodReviewAnswerWriteCommand;
import command.FoodReviewReportWriteCommand;
import command.FoodReviewUpdateCommand;
import command.FoodReviewWriteCommand;
import command.FoodUpdateCommand;
import service.FoodService;

@Controller
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@RequestMapping(value="/food_list.gom", method=RequestMethod.GET)
	public String foodList(Model model) {
		System.out.println("cntlr foodList");
		foodService.selectFoodList(model);
		model.addAttribute("iPage", "food/food_list.jsp");
		return "index";
	}
	
	@RequestMapping(value="/food_reg.gom", method=RequestMethod.POST)
	public String foodRegSubmit(FoodRegCommand foodRegCommand, HttpSession session) { 
		System.out.println("foodRegForm yyyyyyyyyyyyyyyyyyyyyyyyyyy"+foodRegCommand.getFoodNo());
//        System.out.println("cntlr foodRegCommand.getFoodName : " + foodRegCommand.getFoodName());
        foodService.insertFood(foodRegCommand, session);
        System.out.println("food_cntlr foodNo : " + foodRegCommand.getFoodNo());
        return "redirect:/index";
	}
		
	@RequestMapping(value="/bca.gom", method=RequestMethod.POST)
	public String bca(FoodCatB foodCatB, Model model) {
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
//		System.out.println("foodUpdateSubmit foodNo : " + foodUpdateCommand.getFoodNo());
//		System.out.println("foodUpdateSubmit foodName : " + foodUpdateCommand.getFoodName());
		
        foodService.updateFood(foodUpdateCommand);
        return "redirect:/index";
	}
	
	@RequestMapping(value="/food_delete.gom", method=RequestMethod.GET)
    public String foodDelete(@RequestParam("foodNo")int foodNo, Model model) {
		System.out.println("cntlr foodDelete foodNo : " + foodNo);
		foodService.deleteFood(foodNo);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/food_detail.gom", method=RequestMethod.GET)
    public String foodDetail(@RequestParam("foodNo")int foodNo, Model model) {
		System.out.println("cntlr foodDetail foodNo : " + foodNo);
		foodService.selectFood(foodNo, model);
		foodService.selectReviewAndAnswer(foodNo, model);
		model.addAttribute("iPage", "food/food_detail.jsp");
		return "index";
	}
	
	
	@RequestMapping(value="/food_reviewWrite.gom", method=RequestMethod.GET)
    public String foodReviewWriteForm(FoodReviewWriteCommand foodReviewWriteCommand, Model model, HttpSession session) {
		System.out.println("cntlr foodReviewWriteForm foodNo : " + foodReviewWriteCommand.getFoodNo());
		foodService.selectReviewFood(foodReviewWriteCommand);
		if(session.getAttribute("email") != null) {
			model.addAttribute("iPage", "food/food_reviewWrite.jsp");
			return "index";
		}else {
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value="/food_reviewWrite.gom", method=RequestMethod.POST)
	public String foodReviewWriteSubmit(FoodReviewWriteCommand foodReviewWriteCommand, Model model, HttpSession session) { 
		System.out.println("cntlr foodReviewWriteSubmit foodNo : " + foodReviewWriteCommand.getFoodNo());
		System.out.println("cntlr foodReviewWriteSubmit sellerEmail : " + foodReviewWriteCommand.getSellerEmail());
        foodService.insertFoodReview(foodReviewWriteCommand, model, session);
        return "redirect:/index";
	}
	
	
	@RequestMapping(value="/food_reviewUpdate.gom", method=RequestMethod.GET)
    public String foodReviewUpdateForm(FoodReviewUpdateCommand foodReviewUpdateCommand, Model model, HttpSession session) {
		System.out.println("cntlr foodReviewUpdateForm foodReviewNo : " + foodReviewUpdateCommand.getFoodReviewNo());
		System.out.println("cntlr foodReviewUpdateForm foodNo : " + foodReviewUpdateCommand.getFoodNo());
		foodService.selectReviewUpdateFood(foodReviewUpdateCommand);
		if(session.getAttribute("email") != null) {
			model.addAttribute("iPage", "food/food_reviewUpdate.jsp");
			return "index";
		}else {
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value="/food_reviewUpdate.gom", method=RequestMethod.POST)
	public String foodReviewUpdateSubmit(FoodReviewUpdateCommand foodReviewUpdateCommand, Model model, HttpSession session) { 
		System.out.println("cntlr foodReviewUpdateSubmit foodReviewNo : " + foodReviewUpdateCommand.getFoodReviewNo());
		System.out.println("cntlr foodReviewUpdateSubmit sellerEmail : " + foodReviewUpdateCommand.getSellerEmail());
        foodService.updateFoodReview(foodReviewUpdateCommand, model, session);
        return "redirect:/index";
	}
	
	@RequestMapping(value="/food_reviewDelete.gom", method=RequestMethod.GET)
    public String foodReviewDelete(@RequestParam("foodReviewNo")int foodReviewNo, Model model) {
		System.out.println("cntlr foodReviewDelete foodReviewNo : " + foodReviewNo);
		foodService.deleteFoodReview(foodReviewNo);
		return "redirect:/index";
	}
	
	
	
	@RequestMapping(value="/food_reviewAnswerWrite.gom", method=RequestMethod.GET)
    public String foodReviewAnswerWriteForm(FoodReviewAnswerWriteCommand foodReviewAnswerWriteCommand, HttpSession session, Model model) {
		System.out.println("cntlr foodReviewAnswerWrite foodReviewNo : " + foodReviewAnswerWriteCommand.getFoodReviewNo());
		System.out.println("cntlr foodReviewAnswerWrite foodNo : " + foodReviewAnswerWriteCommand.getFoodNo());
		System.out.println("cntlr foodReviewAnswerWrite memberEmail : " + foodReviewAnswerWriteCommand.getMemberEmail());
		foodService.selectReviewAnswerFood(foodReviewAnswerWriteCommand);
		if(session.getAttribute("email") != null) {
			model.addAttribute("iPage", "food/food_reviewAnswerWrite.jsp");
			return "index";
		}else {
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value="/food_reviewAnswerWrite.gom", method=RequestMethod.POST)
	public String foodReviewAnswerWriteSubmit(FoodReviewAnswerWriteCommand foodReviewAnswerWriteCommand, Model model) { 
		System.out.println("cntlr foodReviewAnswerWriteSubmit FoodReviewNo : " + foodReviewAnswerWriteCommand.getFoodReviewNo());
		System.out.println("cntlr foodReviewAnswerWriteSubmit SellerEmail : " + foodReviewAnswerWriteCommand.getSellerEmail());
		System.out.println("cntlr foodReviewAnswerWriteSubmit memberEmail : " + foodReviewAnswerWriteCommand.getMemberEmail());
		foodService.insertFoodReviewAnswer(foodReviewAnswerWriteCommand, model);
        return "redirect:/index";
	}
	

	@RequestMapping(value="/food_reviewAnswerUpdate.gom", method=RequestMethod.GET)
    public String foodReviewAnswerUpdateForm(FoodReviewAnswerUpdateCommand foodReviewAnswerUpdateCommand, Model model, HttpSession session) {
		System.out.println("cntlr foodReviewAnswerUpdateForm foodReviewNo : " + foodReviewAnswerUpdateCommand.getFoodReviewNo());
		System.out.println("cntlr foodReviewAnswerUpdateForm foodNo : " + foodReviewAnswerUpdateCommand.getFoodNo());
		System.out.println("cntlr foodReviewAnswerUpdateForm memberEmail : " + foodReviewAnswerUpdateCommand.getMemberEmail());
		System.out.println("cntlr foodReviewAnswerUpdateForm foodReviewAnswerNo : " + foodReviewAnswerUpdateCommand.getFoodReviewAnswerNo());
		foodService.selectReviewAnswerUpdateFood(foodReviewAnswerUpdateCommand);
		if(session.getAttribute("email") != null) {
			model.addAttribute("iPage", "food/food_reviewAnswerUpdate.jsp");
			return "index";
		}else {
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value="/food_reviewAnswerUpdate.gom", method=RequestMethod.POST)
	public String foodReviewAnswerUpdateSubmit(FoodReviewAnswerUpdateCommand foodReviewAnswerUpdateCommand, Model model) { 
		System.out.println("cntlr foodReviewAnswerUpdateSubmit foodReviewNo : " + foodReviewAnswerUpdateCommand.getFoodReviewNo());
		System.out.println("cntlr foodReviewAnswerUpdateSubmit SellerEmail : " + foodReviewAnswerUpdateCommand.getSellerEmail());
		System.out.println("cntlr foodReviewAnswerUpdateSubmit memberEmail : " + foodReviewAnswerUpdateCommand.getMemberEmail());
		foodService.updateFoodReviewAnswer(foodReviewAnswerUpdateCommand, model);
        return "redirect:/index";
	}
	
	
	
	@RequestMapping(value="/food_reviewAnswerDelete.gom", method=RequestMethod.GET)
    public String foodReviewAnswerDelete(@RequestParam("foodReviewAnswerNo")int foodReviewAnswerNo, Model model) {
		System.out.println("cntlr foodReviewAnswerDelete foodReviewAnswerNo : " + foodReviewAnswerNo);
		foodService.deleteFoodReviewAnswer(foodReviewAnswerNo);
		return "redirect:/index";
	}
	
	
	@RequestMapping(value="/food_reviewReportWrite.gom", method=RequestMethod.GET)
    public String foodReviewReportWriteForm(FoodReviewReportWriteCommand foodReviewReportWriteCommand, Model model, HttpSession session) {
		System.out.println("cntlr foodReviewReportWriteForm foodReviewNo : " + foodReviewReportWriteCommand.getFoodReviewNo());
		System.out.println("cntlr foodReviewReportWriteForm foodNo : " + foodReviewReportWriteCommand.getFoodNo());
		System.out.println("cntlr foodReviewReportWriteForm memberEmail : " + foodReviewReportWriteCommand.getMemberEmail());
		foodService.selectReviewReportFood(foodReviewReportWriteCommand, session);
		if(session.getAttribute("email") != null) {
			model.addAttribute("iPage", "food/food_reviewReportWrite.jsp");
			return "index";
		}else {
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value="/food_reviewReportWrite.gom", method=RequestMethod.POST)
	public String foodReviewReportWriteSubmit(FoodReviewReportWriteCommand foodReviewReportWriteCommand, Model model) { 
		System.out.println("cntlr foodReviewReportWriteSubmit foodReviewNo : " + foodReviewReportWriteCommand.getFoodReviewNo());
		System.out.println("cntlr foodReviewReportWriteSubmit sellerEmail : " + foodReviewReportWriteCommand.getSellerEmail());
		System.out.println("cntlr foodReviewReportWriteSubmit memberEmail : " + foodReviewReportWriteCommand.getMemberEmail());
		System.out.println("cntlr foodReviewReportWriteSubmit foodReportContent : " + foodReviewReportWriteCommand.getFoodReportContent());
		foodService.insertFoodReviewReport(foodReviewReportWriteCommand, model);
        return "redirect:/index";
	}
	
	
	@RequestMapping(value="/food_reviewReportList.gom", method=RequestMethod.GET)
	public String foodReviewReportList(Model model) {
		System.out.println("cntlr foodReviewReportList");
		foodService.selectFoodReviewReportList(model);
		model.addAttribute("iPage", "food/food_reviewReportBoard.jsp");
		return "index";
	}
	
	@RequestMapping(value="/food_reviewReportDetail.gom", method=RequestMethod.GET)
	public String foodReviewReportDetail(@RequestParam("foodReportRegdate")String foodReportRegdate, Model model) {
		System.out.println("cntlr foodReviewReportDetail foodReportRegdate : " + foodReportRegdate);
		foodService.selectFoodReviewReport(foodReportRegdate, model);
		model.addAttribute("iPage", "food/food_reviewReportDetail.jsp");
		return "index";
	}
	
}
