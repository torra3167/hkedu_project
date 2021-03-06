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
import org.springframework.web.bind.annotation.ResponseBody;

import category.FoodCatC;
import command.SellerApplicationWriteCommand;
import command.SellerJoinCommand;
import command.SellerUpdateCommand;
import command.SellerWithdrawalCommand;
import model.Food;
import model.FoodOrder;
import model.FoodOrderReceiverPay;
import model.SellerApplication;
import service.FoodService;
import service.SellerService;

@Controller
public class SellerController {
	
		@Autowired
		private SellerService sellerService;
		
		@Autowired
		private FoodService foodService;
		
		@RequestMapping(value="/seller_join.gom", method=RequestMethod.GET)
		public String joinForm(Model model) {
			model.addAttribute("iPage", "seller/seller_join.jsp");
			return "index";
		}
		
		@RequestMapping(value="/seller_join.gom", method=RequestMethod.POST)
		public String joinSubmit(SellerJoinCommand sellerJoinCommand,  Model model) { 
			Integer result = null;		
			result = sellerService.insertSeller(sellerJoinCommand);
			if(result>0) {
				model.addAttribute("result", result);
				return "index";
			}else {
				return "redirect:/index";
			}
		}
		
		
		@RequestMapping(value="/seller_update.gom", method=RequestMethod.GET)
		public String updateForm(SellerUpdateCommand sellerUpdateCommand, Model model, HttpSession session) {
			sellerUpdateCommand.setSellerEmail((String) session.getAttribute("email"));
			model.addAttribute("email", sellerUpdateCommand.getSellerEmail());
			model.addAttribute("iPage", "seller/seller_update.jsp");
			return "index";
		}
		
		
		@RequestMapping(value="/seller_update.gom", method=RequestMethod.POST)
		public String updateSubmit(SellerUpdateCommand sellerUpdateCommand, HttpServletRequest httpServletRequest,  Model model) {
			System.out.println("cntlr updateSubmit sellerEmail : " + httpServletRequest.getParameter("sellerEmail"));
			sellerUpdateCommand.setSellerEmail(httpServletRequest.getParameter("sellerEmail"));
			sellerUpdateCommand.setSellerPw(httpServletRequest.getParameter("sellerPw"));
			sellerUpdateCommand.setSellerPhone(httpServletRequest.getParameter("sellerPhone"));
			Integer result = sellerService.updateSeller(sellerUpdateCommand);
			
			if(result>0) {
				model.addAttribute("result", result);
				return "index";
			}else {
				return "redirect:/index";
			}
		}
		
		@RequestMapping(value="/seller_menu.gom", method=RequestMethod.GET)
		public String sellerMenu(Model model, HttpSession session) {
			//foodReg cate list
			List<FoodCatC> list = foodService.dominoSelectC();
			model.addAttribute("foodCat", list);
			
			//seller_foodList
			String sellerEmail = (String) session.getAttribute("email");
			List<Food> FoodList = foodService.sellerFoodList(sellerEmail);
			model.addAttribute("sellerFoodList", FoodList);
			
			//seller_orderBoard
			List<FoodOrder> orderedFoodList = foodService.selectSellerOrderedFoodList(sellerEmail);
			model.addAttribute("orderedFoodList", orderedFoodList);
			
			//food_orderStatistics
			List<FoodOrderReceiverPay> fosDayList = foodService.selectFoodOrderStatDay(sellerEmail);
			model.addAttribute("fosDayList", fosDayList);
			List<FoodOrderReceiverPay> fosMonthList = foodService.selectFoodOrderStatMonth(sellerEmail);
			model.addAttribute("fosMonthList", fosMonthList);
			
			
			
			model.addAttribute("iPage", "seller/seller_menu.jsp");
			return "index";
		}
		
		
		@RequestMapping(value="/seller_withdrawal.gom", method=RequestMethod.GET)
		public String sellerWithdrawalForm(SellerWithdrawalCommand sellerWithdrawalCommand, Model model, HttpSession session) {
			sellerWithdrawalCommand.setSellerEmail((String) session.getAttribute("email"));
			model.addAttribute("iPage", "seller/seller_withdrawal.jsp");
			return "index";
		}
		
		@RequestMapping(value="/seller_withdrawal.gom", method=RequestMethod.POST)
		public String sellerWithdrawalSubmit(SellerWithdrawalCommand sellerWithdrawalCommand,  Model model, HttpServletRequest httpServletRequest, HttpSession session) { 
			sellerWithdrawalCommand.setSellerEmail(httpServletRequest.getParameter("sellerEmail"));
			sellerWithdrawalCommand.setSellerPw(httpServletRequest.getParameter("sellerPw"));
			int result = sellerService.deleteSeller(sellerWithdrawalCommand);
			if(result>0) {
/*				model.addAttribute("result", result);
*/				session.invalidate();
/*				model.addAttribute("iPage", "seller/seller_withdrawalResult.jsp");
*/				return "redirect:/index";
			}else {
				return "redirect:/index";
			}
			
		}
		
		
		@RequestMapping(value="/seller_application.gom", method=RequestMethod.GET)
		public String sellerApplicationForm(SellerApplicationWriteCommand sellerApplicationWriteCommand, Model model) {
			model.addAttribute("iPage", "seller/seller_application.jsp");
			return "index";
		}
		
		@RequestMapping(value="/seller_application.gom", method=RequestMethod.POST)
		public String sellerApplicationSubmit(SellerApplicationWriteCommand sellerApplicationWriteCommand, HttpSession session, Model model) { 
			sellerService.insertSellerApplication(sellerApplicationWriteCommand, session);
			return "index";
		}
		
		@RequestMapping(value="/seller_applicationList.gom", method=RequestMethod.GET)
		public String sellerApplicationList(Model model) {
			System.out.println("cntlr sellerApplicationList");
			List<SellerApplication> sellerApplicationList = sellerService.selectSellerApplicationList();
			model.addAttribute("sellerApplicationList", sellerApplicationList);
			model.addAttribute("iPage", "seller/seller_applicationBoard.jsp");
			return "index";
		}
		
		@RequestMapping(value="/seller_lookUpApplication.gom", method=RequestMethod.GET)
		public String sellerLookUpApplication(Model model, HttpSession session) {
			System.out.println("cntlr sellerLookUpApplication");
			SellerApplication sellerApplication = sellerService.selectSellerApplication((String)session.getAttribute("email"));
			model.addAttribute("sellerApplication", sellerApplication);
			model.addAttribute("iPage", "seller/seller_applicationDetail.jsp");
			return "index";
		}
		
		
		@RequestMapping(value="/seller_applicationDelete.gom", method=RequestMethod.GET)
	    public String sellerApplicationDelete(@RequestParam("sellerAppliNo")int sellerAppliNo, Model model, HttpSession session) {
			System.out.println("cntlr sellerApplicationDelete sellerAppliNo : " + sellerAppliNo);
			sellerService.deleteSellerApplication(sellerAppliNo, session);
			return "redirect:/index";
		}
		
		@RequestMapping(value="/seller_appliBnDuplication.gom", method=RequestMethod.POST)
		@ResponseBody
		public String sellerAppliBnDuplication(@RequestParam("applicBn")int applicBn) { 
			int result = sellerService.selectAppliBn(applicBn);
			String dup = "";
			if(result>0) {
				dup = "true";
			}else {
				dup = "false";
			}
			return dup;
		}
		
		@RequestMapping(value="/seller_emailDuplication.gom", method=RequestMethod.POST)
		@ResponseBody
		public String sellerEmailDuplication(@RequestParam("sellerEmail")String sellerEmail) { 
			int result = sellerService.selectSellerEmail(sellerEmail);
			String dup = "";
			if(result>0) {
				dup = "true";
			}else {
				dup = "false";
			}
			return dup;
		}
}
