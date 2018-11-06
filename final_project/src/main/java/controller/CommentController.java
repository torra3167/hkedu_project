package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Aca;
import model.Bca;
import model.Comment;
import model.Member;
import service.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService cs;
	
	
	
	
	@RequestMapping(value="/form.do", method=RequestMethod.GET)
	public String handleInsert(Model model) {
		
			model.addAttribute("comment", new Comment());
			return "jsp/comment_form";
		
	}
	@RequestMapping(value="/comment_insert", method=RequestMethod.POST)
	public String handleInsert(Comment comment, Model model) {
		Integer result = null;
		
		result = cs.insertComment(comment);
		System.out.println(result + "result!!");
		if(result > 0) {
			model.addAttribute("Comment", comment);
			return "jsp/comment_insert";
		} else {
			return "redirect:/form.do";
		}
	}
	
	@RequestMapping(value="/comment_select", method=RequestMethod.POST)
	public String handleSelect(Comment comment, Model model) {
		System.out.println("SELECT CONTROLLER");
		List<Comment> result = cs.selectComment(comment);
		if(result != null) {
			model.addAttribute("result", result);
			return "jsp/comment_select";
		} else {
			return "redirect:/form.do";

		}
	}	
	
	@RequestMapping(value="/comment_update", method=RequestMethod.POST)
	public String handleUpdate(Comment comment, Model model) {
		System.out.println("UPDATE CONTROLLER");
		Integer i = cs.updateComment(comment);
		if(i > 0) {
			model.addAttribute("i", i);
			return "jsp/comment_update";

		} else {
			return "redirect:/form.do";

		}
	}
	
	

	@RequestMapping(value="/comment_delete", method=RequestMethod.POST)
	public String handleDelete(Comment comment, Model model) {
		System.out.println("DELETE CONTROLLER");
		Integer i = cs.deleteComment(comment);
		if(i > 0) {
			model.addAttribute("i", i);
			return "jsp/comment_delete";
		}
		return "redirect:/form.do";
	}
	
	@RequestMapping(value="/ajax.do", method=RequestMethod.POST)
	public String handleAjax(HttpServletRequest request, Model model) {
		List list = cs.ajaxSelect(request, model);
		return "jsp/ajaxhtml";
	}
	@RequestMapping(value="/ajax.do", method=RequestMethod.GET)
	public String ajaxMain(Model model) {
		
		return "jsp/ajaxmain";
	}
	
	@RequestMapping(value="/main1.do", method=RequestMethod.GET)
	public String ajaxMain2(HttpServletRequest request, Model model) {
		return "ajax/ajaxmain1";
	}
	

	@RequestMapping(value="/main1.do", method=RequestMethod.POST)
	public String handleAjax2(HttpServletRequest request, Model model) {
		System.out.println(request.getParameter("n"));
		List list = cs.ajaxSelect(request, model);
		
		

		return "ajax/ajaxhtml";
	}
	
	@RequestMapping(value="/main2.do", method=RequestMethod.GET)
	public String ajaxMain3(HttpServletRequest request, Model model) {
		return "ajax/ajaxmain2";
	}
	

	@RequestMapping(value="/main2.do", method=RequestMethod.POST)
	public String handleAjax3(HttpServletRequest request, Model model) {
		System.out.println(request.getParameter("n"));
		List list = cs.ajaxSelect(request, model);
		
		

		return "ajax/ajaxhtml";
	}
	
	@RequestMapping(value="login_pro.do", method=RequestMethod.POST) 
	public String postLogin(Member mb, Model model) {
		System.out.println("Login_pro POST controller id" + mb.getId());
		System.out.println("Login_pro POST controller pw" + mb.getPw());
		
		cs.memberSelect(mb, model);
		
		return "login/loginPro";
	}
	
	@RequestMapping(value="login.do", method=RequestMethod.GET) 
	public String getLogin(Model model) {
		
		return "login/loginForm";
	}
	
	@RequestMapping(value="/domino.do", method=RequestMethod.GET)
	public String aca(Model model) {
		cs.dominoSelectA(model);
		return "category/dominoMain";
	}
	
	@RequestMapping(value="/bca.do", method=RequestMethod.POST)
	public String bca(Aca aca, Model model) {
		System.out.println("B category " + aca.getAnum());
		cs.dominoSelectB(aca, model);
		return "category/bca";
	}
	
	@RequestMapping(value="/cca.do", method=RequestMethod.POST)
	public String Cca(Bca bca, Model model) {
		cs.dominoSelectC(bca, model);
		
		return "category/cca";
	}
	
	

	

	
	
	
	
	
}
