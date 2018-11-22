package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import command.ProReviewReportUpdateCommand;
import command.ProReviewReportWriteCommand;

import service.ProReviewReportService;

@Controller
public class ProReviewReportController {

	@Autowired
	private ProReviewReportService prrs;
	
	@RequestMapping(value="/pro_review_report_write.gom", method=RequestMethod.GET)
	public String proReviewReportWrite(ProReviewReportWriteCommand proReviewReportWriteCommand,Model model) {
		model.addAttribute("iPage", "program/pro_review_report_write.jsp");
		model.addAttribute("ProReviewReportWriteCommand", proReviewReportWriteCommand);
		
	    return "index";
	}
	
	@RequestMapping(value="/pro_review_report_update.gom", method=RequestMethod.GET)
	public String proReviewReportWrite(ProReviewReportUpdateCommand proReviewReportUpdateCommand,Model model) {
		model.addAttribute("iPage", "program/pro_review_report_update.jsp");
		model.addAttribute("ProReviewReportUpdateCommand", proReviewReportUpdateCommand);
		
	    return "index";
	}
	
	
	
}
