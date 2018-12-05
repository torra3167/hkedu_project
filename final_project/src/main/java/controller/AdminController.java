package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.SellerApplication;
import service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/admin_sellerApplicationApproval.gom", method=RequestMethod.GET)
	public String sellerApplicationApproval(@RequestParam("sellerEmail")String sellerEmail, Model model) {
		System.out.println("cntlr SellerApplicationApproval sellerEmail : " + sellerEmail);
		adminService.updateSellerDivideS(sellerEmail);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/admin_sellerApplicationDetail.gom", method=RequestMethod.GET)
	public String sellerApplicationDetail(@RequestParam("sellerAppliNo")int sellerAppliNo, Model model) {
		System.out.println("cntlr sellerApplicationDetail sellerAppliNo : " + sellerAppliNo);
		SellerApplication sellerApplication = adminService.selectAppliByAppliNo(sellerAppliNo);
		model.addAttribute("sellerApplication", sellerApplication);
		model.addAttribute("iPage", "seller/seller_applicationDetail.jsp");
		return "index";
	}
	
	@RequestMapping(value="/admin_sellerApplicationReturn.gom", method=RequestMethod.POST)
	public String sellerApplicationReturn(@RequestParam("sellerEmail")String sellerEmail, @RequestParam("returnCause")String returnCause, Model model) {
		System.out.println("cntlr sellerApplicationReturn sellerEmail : " + sellerEmail);
		adminService.updateSellerDivideP(sellerEmail, returnCause);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/admin_sellerApplicationDelete.gom", method=RequestMethod.GET)
	public String adminSellerApplicationDelete(@RequestParam("sellerEmail")String sellerEmail, Model model) {
		System.out.println("cntlr adminSellerApplicationDelete sellerEmail : " + sellerEmail);
		adminService.deleteSellerApplication(sellerEmail);
		return "redirect:/index";
	}
	
//	
	
}
