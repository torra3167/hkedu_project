package service;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import model.Aca;
import model.Bca;
import model.Cca;
import model.Comment;
import model.Member;
import repository.CommentSessionRepository;


public class CommentService {
	
	@Autowired
	private CommentSessionRepository csr;
	
	public Integer insertComment(Comment comment) {
		System.out.println("service number " + comment.getCommentNo() );
		System.out.println("service id " + comment.getUserId() );
		System.out.println("service content " + comment.getCommentContent() );
		
		comment.setRegDate(Calendar.getInstance().getTime());
		
		return csr.insertComment(comment);
	}

	public List<Comment> selectComment(Comment comment) {
		// TODO Auto-generated method stub
		System.out.println("SELECT COMMENT" + comment);
		
		return csr.selectCommentByCondtion(comment);
		
	}

	public Integer updateComment(Comment comment) {
		// TODO Auto-generated method stub
		System.out.println("udpate service + " + comment.getCommentNo());
		return 	csr.updateComment(comment);

	}

	public Integer deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		System.out.println("delete service " + comment.getCommentNo());
		return csr.deleteComment(comment);
	}

	public List ajaxSelect(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		Long result = Long.parseLong(request.getParameter("n"));
		System.out.println("ajaxSelect " + result);
		
		List list = null;
		
		list = csr.ajaxSelect(result);
		model.addAttribute("list", list);
		model.addAttribute("result", result);
		return list;

	}

	public void memberSelect(Member mb, Model model) {
		// TODO Auto-generated method stub
		System.out.println("service " + mb.getId());
		System.out.println("service " + mb.getPw());
		
		Member member = csr.memberSelect(mb);
		int i = 0;
		
		if(member != null) {
			if(!mb.getPw().equals(member.getPw())) {
				i = 2;
			} else {
				i = 3;
			}
		} else {
			i = 1;
		} 
	
		model.addAttribute("num", i);
		System.out.println(i+ "num");
		
	}

	public void dominoSelectA(Model model) {
		// TODO Auto-generated method stub
		List<Aca> list = csr.acaSelect();
		
		model.addAttribute("list", list);
		
	}

	public void dominoSelectB(Aca aca, Model model) {
		// TODO Auto-generated method stub
		System.out.println("csr " + aca.getAnum());
		List<Bca> list = csr.bcaSelect(aca);
		
		model.addAttribute("list", list);
		
	}

	public void dominoSelectC(Bca bca, Model model) {
		// TODO Auto-generated method stub
		List<Cca> list = csr.ccaSelect(bca);
		model.addAttribute("list", list);
	}
	
	
}
