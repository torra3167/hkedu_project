package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.ProReviewUpdateCommand;
import command.ProReviewWriteCommand;
import service.ProReviewService;

public class ProReviewController {

	@Autowired
	private ProReviewService prs;
	
	@RequestMapping(value = "/pro_review_update.gom", method = RequestMethod.POST)
	public String programReviewUpdateSubmit(ProReviewUpdateCommand proReviewUpdateCommand) {
		

		
		prs.updateProReview(proReviewUpdateCommand);
		return "redirect:/index";

	}
	
	@RequestMapping(value = "/pro_review_update.gom", method = RequestMethod.GET)
	public String programReviewUpdate(ProReviewUpdateCommand proReviewUpdateCommand, Model model) {
		
		model.addAttribute("iPage", "program/pro_review_update.jsp");
		model.addAttribute("ProReviewUpdateCommand", proReviewUpdateCommand);
		
	    return "index";

	}
	
	@RequestMapping(value = "/pro_review_all_list.gom", method = RequestMethod.GET)
	public String programReviewAllList(Model model) {
		prs.selectProReviewAllList(model);
		
		model.addAttribute("iPage", "program/pro_review_list.jsp");
		return "index";

	}
	
	@RequestMapping(value = "/pro_review_list.gom", method = RequestMethod.GET)
	public String programReviewList(@RequestParam(value="proNo", defaultValue="false") int proNo, Model model) {
//		System.out.println(proNo + "PRONO ");
		prs.selectProReviewListByProNo(proNo, model);
		
		model.addAttribute("iPage", "program/pro_review_list.jsp");
		return "index";

	}
	
	
	
	@RequestMapping(value = "/pro_review_write.gom", method = RequestMethod.POST)
	public String programReviewSubmit(ProReviewWriteCommand proReviewWriteCommand, Model model) {
		
		/*System.out.println(proReviewWriteCommand.getProReviewComment());
		System.out.println(proReviewWriteCommand.getProReviewImage());
		System.out.println(proReviewWriteCommand.getProReviewTitle());
		System.out.println(proReviewWriteCommand.getProReviewScore());
		System.out.println(proReviewWriteCommand.getProNo());
		System.out.println(proReviewWriteCommand.getCoachEmail());*/
		
		prs.programReviewWrite(proReviewWriteCommand, model);
		
		
		return "redirect:/index";

	}
	
	@RequestMapping(value = "/pro_review_write.gom", method = RequestMethod.GET)
	public String programReviewWrite(ProReviewWriteCommand proReviewWriteCommand, Model model) {
		
		
		model.addAttribute("ProReviewWriteCommand", proReviewWriteCommand);
		model.addAttribute("iPage", "program/pro_review_write.jsp");
		return "index";

	}
	
	
}
