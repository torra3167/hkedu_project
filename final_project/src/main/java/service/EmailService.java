package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.IdPasswordNotMatchingException;
import model.Email;
import repository.EmailRepository;

@Service
public class EmailService {

	@Autowired
	private EmailRepository emailRepository;

	public Integer findSellerID(String email) {
		System.out.println("EMAILSERVICE FindSellerID " + email);
		Integer i = emailRepository.countSellerID(email);
		System.out.println("EmailService " + i);
		return i;
	}

	public String findPW(String email, String pw) {
		Email selectEmail = emailRepository.selectByEmail(email);
		if (selectEmail == null) {
			throw new IdPasswordNotMatchingException("아이디가 존재하지않습니다");
		} else {
			String keyEmail=selectEmail.getEmail();
			return keyEmail;

		}

	}

}
