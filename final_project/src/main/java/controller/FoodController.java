package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
import model.AvgReviewScore;
import model.DietRecordFood;
import model.Food;
import model.FoodAndApplication;
import model.FoodNutrient;
import model.FoodReviewAndAnswer;
import model.FoodReviewReport;
import model.MemberSurvey;
import service.FoodService;
import service.MemberService;
import service.SellerService;

@Controller
public class FoodController {
   
   @Autowired
   private FoodService foodService;
   
   @RequestMapping(value="/food_list.gom", method=RequestMethod.GET)
   public String foodList(Model model, HttpSession session) {
      System.out.println("cntlr foodList");
      
      List<FoodAndApplication> foodAppliList = foodService.selectFoodList();
      System.out.println("cntlr foodList foodAppliList.size() : " + foodAppliList.size());
      model.addAttribute("foodAppliList", foodAppliList);
      
      List<FoodAndApplication> coachRecomFoodList = foodService.selectCoachRecomFoodList(session);
      model.addAttribute("coachRecomFoodList", coachRecomFoodList);
      
      List<AvgReviewScore> avgrsList = foodService.selectAvgReviewScore();
      model.addAttribute("avgrsList", avgrsList);
      
      model.addAttribute("iPage", "food/food_list.jsp");

      return "index";
   }
   
   @RequestMapping(value="/food_reg.gom", method=RequestMethod.POST)
   public String foodRegSubmit(FoodRegCommand foodRegCommand, HttpSession session) { 
      System.out.println("cntlr foodRegSubmit getFoodNo : "+foodRegCommand.getFoodNo());
//        System.out.println("cntlr foodRegCommand.getFoodName : " + foodRegCommand.getFoodName());
        foodService.insertFood(foodRegCommand, session);
        System.out.println("food_cntlr foodNo : " + foodRegCommand.getFoodNo());
        return "redirect:/index";
   }
      
   @RequestMapping(value="/bca.gom", method=RequestMethod.POST)
   public String bca(FoodCatB foodCatB, Model model) {
//      System.out.println( "B contoller getFoodCatCNo : " + foodCatB.getFoodCatCNo());
      List<FoodCatB> foodCatList = foodService.dominoSelectB(foodCatB);
      model.addAttribute("foodCat", foodCatList);
      return "food/food_cat_b";
   }
   
   @RequestMapping(value="/cca.gom", method=RequestMethod.POST)
   public String Cca(FoodCatA foodCatA, Model model) {
//      System.out.println("C controller getFoodCatBNo : " + foodCatA.getFoodCatBNo());
      List<FoodCatA> foodCatList2 = foodService.dominoSelectA(foodCatA);
      model.addAttribute("foodCat", foodCatList2);
      return "food/food_cat_a";
   }
   
   @RequestMapping(value = "/food_for_pro_food.gom", method = RequestMethod.POST)
   public String programDetail(@RequestParam(value="foodCategoryANum") int foodCatANo, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

      System.out.println(foodCatANo + " FOODCATANO!!!");
      foodService.selectFoodListByCategoryA(foodCatANo, request, response, session);
      
      return "food/food_selected_proFood";

   }
   
   @RequestMapping(value="/seller_foodDetail.gom", method=RequestMethod.GET)
   public String sellerFoodDetail(@RequestParam("foodNo")int foodNo, Model model) {
//      System.out.println("cntlr sellerFoodDetail");
//      System.out.println("cntlr foodNo : "+foodNo);
      
      Food food = foodService.selectSellerFood(foodNo);
      model.addAttribute("sellerFood", food);
      
      model.addAttribute("iPage", "seller/seller_foodDetail.jsp");
      return "index";
   }
   
   @RequestMapping(value="/food_update.gom", method=RequestMethod.GET)
    public String foodUpdateForm(FoodUpdateCommand foodUpdateCommand, Model model) {
//      System.out.println("foodUpdateForm foodNo : " +  foodUpdateCommand.getFoodNo());
//      System.out.println("foodUpdateForm foodName : " +  foodUpdateCommand.getFoodName());
      
      //등록식품 수정에 사용
      List<FoodCatC> list = foodService.dominoSelectC();
      model.addAttribute("foodCat", list);   
      
      model.addAttribute("iPage", "food/food_update.jsp");
      return "index";
   }
   
   @RequestMapping(value="/food_update.gom", method=RequestMethod.POST)
   public String foodUpdateSubmit(FoodUpdateCommand foodUpdateCommand) { 
//      System.out.println("foodUpdateSubmit foodNo : " + foodUpdateCommand.getFoodNo());
//      System.out.println("foodUpdateSubmit foodName : " + foodUpdateCommand.getFoodName());
      
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
    public String foodDetail(@RequestParam("foodNo")int foodNo, Model model, HttpSession session) {
      System.out.println("cntlr foodDetail foodNo : " + foodNo);
      FoodAndApplication fa = foodService.selectFood(foodNo);
      model.addAttribute("fa", fa);
      List<FoodReviewAndAnswer> foodReviewAndAnswers = foodService.selectReviewAndAnswer(foodNo);
      model.addAttribute("foodReviewAndAnswers", foodReviewAndAnswers);
      
      String memberDivide = foodService.selectMemberDivide((String)session.getAttribute("email"));
      model.addAttribute("memberDivide", memberDivide);
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
        foodService.insertFoodReview(foodReviewWriteCommand, session);
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
        foodService.updateFoodReview(foodReviewUpdateCommand, session);
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
      foodService.insertFoodReviewAnswer(foodReviewAnswerWriteCommand);
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
      foodService.updateFoodReviewAnswer(foodReviewAnswerUpdateCommand);
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
      foodService.insertFoodReviewReport(foodReviewReportWriteCommand);
        return "redirect:/index";
   }
   
   
   @RequestMapping(value="/food_reviewReportList.gom", method=RequestMethod.GET)
   public String foodReviewReportList(Model model) {
      System.out.println("cntlr foodReviewReportList");
      List<FoodReviewReport> foodReviewReports = foodService.selectFoodReviewReportList();
      model.addAttribute("foodReviewReports", foodReviewReports);
      model.addAttribute("iPage", "food/food_reviewReportBoard.jsp");
      return "index";
   }
   
   @RequestMapping(value="/food_reviewReportDetail.gom", method=RequestMethod.GET)
   public String foodReviewReportDetail(@RequestParam("foodReportRegdate")String foodReportRegdate, Model model) {
      System.out.println("cntlr foodReviewReportDetail foodReportRegdate : " + foodReportRegdate);
      FoodReviewReport foodReviewReport = foodService.selectFoodReviewReport(foodReportRegdate);
      model.addAttribute("foodReviewReport", foodReviewReport);
      model.addAttribute("iPage", "food/food_reviewReportDetail.jsp");
      return "index";
   }
   
   @RequestMapping(value="/food_reviewReportDelete.gom", method=RequestMethod.GET)
    public String foodReviewReportDelete(@RequestParam("foodReportRegdate")String foodReportRegdate, Model model) {
      System.out.println("cntlr foodReviewReportDelete foodReportRegdate : " + foodReportRegdate);
      foodService.deleteFoodReviewReport(foodReportRegdate);
      return "redirect:/index";
   }
      
   @RequestMapping(value="/food_dietRecordList.gom", method=RequestMethod.GET)
    public String foodDietRecordFoodList(@RequestParam("dateText")String dateText, Model model, HttpSession session) {
	 //식단기록에 사용할 식품결제내역
//      List<Food> orderedFoodList = foodService.selectOrderedFoodList((String)session.getAttribute("email"));
//      model.addAttribute("orderedFoodList", orderedFoodList);
	  List<DietRecordFood> dietRecordFoodList = foodService.selectDietRecordFoodList((String)session.getAttribute("email"), dateText);
	  model.addAttribute("dateText", dateText);
	  model.addAttribute("dietRecordFoodList", dietRecordFoodList);
      model.addAttribute("iPage", "food/food_dietRecord.jsp");
      return "index";
   }
   
   @RequestMapping(value="/food_openRecord.gom", method=RequestMethod.POST)
   public String foodOpenRecord(Model model, HttpSession session) {
	 //식단기록에 사용할 식품결제내역
     List<Food> orderedFoodList = foodService.selectOrderedFoodList((String)session.getAttribute("email"));
     List<FoodNutrient> foodNutrients = foodService.selectFoodNutrientList();
     System.out.println("cntlr foodOpenRecord size :********** "+foodNutrients.size());
     model.addAttribute("foodNutrients", foodNutrients);
     model.addAttribute("orderedFoodList", orderedFoodList);
     return "food/food_dietRecord2";
  }
   
   
 //식단 입력 중복여부 반환 메소드
   @RequestMapping(value="/food_recordDuplication.gom", method=RequestMethod.POST)
   @ResponseBody
   public String foodRecordDuplication(@RequestParam("selectedOption")String selectedOption, @RequestParam("mealtime")Integer mealtime,  @RequestParam("recordDate")String recordDate, Model model, HttpSession session) {
//	   System.out.println("cntlr foodRecordDuplication recordDate : " + recordDate);
//	   System.out.println("cntlr foodRecordDuplication mealtime : " + mealtime);
//	   System.out.println("cntlr foodRecordDuplication selectedOption : " + selectedOption);
	   String[] sof = selectedOption.split(",");
	   
	   int result = foodService.selectFoodRecord(sof[0], mealtime, recordDate, session);
		if(result == 1) {
			System.out.println("cntlr foodRecordDuplication 중복 기록");
			return "true";
		} else {
			System.out.println("cntlr foodRecordDuplication 중복 아님");
			return "false";
		}
   }
   
   @RequestMapping(value="/food_recordInsert.gom", method=RequestMethod.POST)
   @ResponseBody
   public String foodRecordInsert(@RequestParam("selectedOption")String selectedOption, @RequestParam("quantity")Integer quantity, @RequestParam("mealtime")Integer mealtime, @RequestParam("recordDate")String recordDate, Model model, HttpSession session) {
//      System.out.println("cntlr foodRecordInsert selectOrderedFood : " + selectOrderedFood);
//      System.out.println("cntlr foodRecordInsert mealtime : " + mealtime);
//      String[] sof = selectedOption.split(",");
//      for(int i=0;i<sof.length;i++) {
//          System.out.println(sof[i]+"   ["+i+"]");
//      }
      String dietRecordNo = foodService.insertDietRecord(selectedOption, mealtime, quantity, recordDate, session, model).toString();
      return dietRecordNo;
   }
   
   @RequestMapping(value="/food_recordDelete.gom", method=RequestMethod.POST)
   public String foodRecordDelete(@RequestParam("drNum")Integer drNum, Model model, HttpSession session) {
	   System.out.println("cntlr foodRecordDelete drNum : "+ drNum);
      foodService.deleteDietRecord(drNum);
      return "index";
   }
   
   @RequestMapping(value="/food_recordMain.gom", method=RequestMethod.GET)
   public String foodRecordMain(@RequestParam("dateText")String dateText, Model model, HttpSession session) {
	   System.out.println("cntlr foodRecordMain dateText : "+ dateText);
	   List<DietRecordFood> dietRecordFoodList = foodService.selectDietRecordFoodList((String)session.getAttribute("email"), dateText);
	   model.addAttribute("dietRecordFoodList", dietRecordFoodList);
	   model.addAttribute("dateText", dateText);
	   MemberSurvey ms = foodService.selectMemberWeightHeight(session);
	   model.addAttribute("ms", ms);
	   model.addAttribute("iPage", "food/food_dietRecordMain.jsp");
      return "index";
   }
   
   @RequestMapping(value="/food_nutFoodCatName.gom", method=RequestMethod.POST)
   public String foodNutFoodCatName(@RequestParam("foodNutrientCatName")String foodNutrientCatName, Model model) {
      System.out.println( "cntlr foodNutFoodCatName : " + foodNutrientCatName);
      List<FoodNutrient> selectedfoodNutList = foodService.selectfoodNutListB(foodNutrientCatName);
      model.addAttribute("selectedfoodNutList", selectedfoodNutList);
      return "food/food_nutFoodCatB";
   }
   
   
}
