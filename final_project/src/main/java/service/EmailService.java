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

	public Integer findPW(String email, String phone) {
		Email selectEmail = emailRepository.selectByEmail(email);
		Email selectPhone=emailRepository.selectByPhone(phone);
		if (selectEmail == null) {
			throw new IdPasswordNotMatchingException("아이디가 존재하지않습니다");
		} else {
			int i=0;
			if(selectEmail.equals(selectPhone)) {
				i=1;
			}
			return i;
		}
	}

}
