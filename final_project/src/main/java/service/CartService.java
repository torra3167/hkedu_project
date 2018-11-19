package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import repository.CartRepository;


@Service
public class CartService {
	@Autowired
	private CartRepository cartR;
	
	

	public void cartList(Model model, HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		List cartList = (List)session.getAttribute("cartList");
		
		
		session.setAttribute("cartList", cartList);
				
	}

}
