package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.IdPasswordNotMatchingException;
import model.AuthInfo;

import repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository lr;
	
	

	public AuthInfo selectByEmailAndDivide(String email, String pw) {
		// TODO Auto-generated method stub
		AuthInfo authinfo = lr.selectByEmailAndDivide(email);
		System.out.println(authinfo);
		
		if(authinfo == null) {
			throw new IdPasswordNotMatchingException("아이디가 존재하지않습니다");
		} else {
		
		//일치하는 경우
			System.out.println("AUTHINFO" + authinfo.getEmail());
			System.out.println("AUTHINFO" + authinfo.getDivide());
			System.out.println("AUTHINFO" + authinfo.getName());	
			
		return new AuthInfo(authinfo.getEmail(), authinfo.getDivide(), authinfo.getName());
		
		}
		
		

		
	}

}
