package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import exception.IdPasswordNotMatchingException;
import model.AuthInfo;
import model.Food;
import model.Program;
import repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository lr;
	
	

	public AuthInfo selectByEmailAndDivide(String email, String pw) {
		// TODO Auto-generated method stub
		
		AuthInfo authinfo = lr.selectByEmailAndDivide(email);
//		System.out.println(authinfo);
		
		if(authinfo == null) {
			throw new IdPasswordNotMatchingException("아이디가 존재하지않습니다");
		} else {
		
		//일치하는 경우
			/*System.out.println("AUTHINFO EMAIL " + authinfo.getEmail());
			System.out.println("AUTHINFO DIVIDE " + authinfo.getDivide());*/
			
		return new AuthInfo(authinfo.getEmail(), authinfo.getDivide());
		
		}
		
		

		
	}
	
	public void programList(Model model) {
		// TODO Auto-generated method stub
		List<Program> list = lr.programList();
		model.addAttribute("Program", list);
	}

	public void selectFoodList(Model model) {
		// TODO Auto-generated method stub
		List<Food> foodList = lr.selectFoodList();
		System.out.println(foodList.size() + "FOODLIST SIZE");
		model.addAttribute("foodList", foodList);
		
	}

}
