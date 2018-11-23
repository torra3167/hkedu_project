package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import command.ChangePWCommand;
import command.FindIDCommand;
import exception.IdPasswordNotMatchingException;
import exception.MemberNotFoundException;
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

	public Integer findPW(FindIDCommand findIDCommand) {
		FindIDCommand selectEmail = emailRepository.selectByEmail(findIDCommand);
		/*String selectPhone = emailRepository.selectByPhone(phone);*/
		System.out.println("EMAILSERVICE findPW "+selectEmail);
		if (selectEmail == null) {
			throw new IdPasswordNotMatchingException("아이디가 존재하지않습니다");
		}else {
			int i=1;
			return i;
		}
	}

	public Integer changePW(ChangePWCommand changePWCommand) {
		System.out.println("EmailService changePW "+changePWCommand.getEmail());
		System.out.println("EmailService changePW "+changePWCommand.getNewPW());
		Integer result=emailRepository.changePW(changePWCommand);
		System.out.println("리퍼시토리 "+result);
		if(result==0) {
			throw new MemberNotFoundException();
		}
		return result;
	}

}
