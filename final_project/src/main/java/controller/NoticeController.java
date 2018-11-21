package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import command.NoticeInsertCommand;
import service.NoticeService;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value = "/notice_insert.gom", method = RequestMethod.GET)
	public String joinForm(Model model) {
		model.addAttribute("iPage", "noticeBoard/notice_insert.jsp");
		model.addAttribute("noticeInsertCommand", new NoticeInsertCommand());
		System.out.println("CONTROLLER Insert GET");
		return "index";
	}
	@RequestMapping(value = "/notice_insert.gom", method = RequestMethod.POST)
	public String joinSubmit(NoticeInsertCommand noticeInsertCommand, Model model) {
		Integer result = null;
		System.out.println("CONTROLLER Insert POST");
		result = noticeService.insertNotice(noticeInsertCommand);
		if (result > 0) {
			model.addAttribute("result", result);
			return "index";
		} else {
			return "redirect:/index";
		}
	}
}
