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

import command.CoachUpdateCommand;
import model.Coach;
import service.AdminService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/coach_list.gom", method = RequestMethod.GET)
	public String memberList(Model model, HttpSession session) {
		model.addAttribute("iPage", "admin/coach_list.jsp");
		String id = (String) session.getAttribute("email");
		List<Coach> coachList=adminService.coachList();
		model.addAttribute("id", id);
		model.addAttribute("coachList", coachList);
		System.out.println("CONTROLLER CoachList GET");
		return "index";
	}
	
	@RequestMapping(value = "/coach_delete.gom", method = RequestMethod.GET)
	public String memberListDelete(@RequestParam("email")String email, Model model, HttpSession session) {
		model.addAttribute("iPage", "admin/member_delete.jsp");
		System.out.println("CONTROLLER memberListDelete "+email);
		int result = adminService.coachDelete(email);
		if (result > 0) {
			model.addAttribute("result", result);
			System.out.println("CONTROLLER CoachList Delete POST "+result);
			return "index";
		} else {
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value = "/coach_detail.gom", method = RequestMethod.GET)
	public String memberListDetail(@RequestParam("email")String email, HttpServletRequest request, Model model, HttpSession session) {
		model.addAttribute("iPage", "admin/coach_detail.jsp");
		Coach coach=adminService.coachInfo(email);
		model.addAttribute("coach", coach);
		String id=(String)session.getAttribute("email");
		model.addAttribute("id", id);
		System.out.println("CONTROLLER CoachList GET");
		return "index";
	}
	
	@RequestMapping(value = "/coach_detail.gom", method = RequestMethod.POST)
	public String memberListUpdate(CoachUpdateCommand coachUpdateCommand, HttpServletRequest request, Model model) {
		model.addAttribute("iPage", "member/member_update.jsp");
		Integer result = adminService.updateCoach(coachUpdateCommand);
		System.out.println("CONTROLLER MemberInfoUpdate POST "+coachUpdateCommand.getCoachEmail());
		if (result > 0) {
			model.addAttribute("result", result);
			return "index";
		} else {
			return "redirect:/index";
		}
	}
}
