package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.IdPasswordNotMatchingException;
import model.Coach;
import model.CoachAuthInfo;
import repository.CoachRepository;

@Service
public class CoachService {
	@Autowired
	private CoachRepository cr;
	
	public CoachAuthInfo authenticate(String email, String pw) {
		Coach coach = cr.selectByEmail(email);
		System.out.println("COACH " + coach.getCoachName());
		// 이메일이 존재하지 않는경우
		if(coach == null) {
			throw new IdPasswordNotMatchingException("아이디가 존재하지않습니다");
		}
		//비밀번호 틀린경우
		if(!coach.getCoachPw().equals(pw)) {
			throw new IdPasswordNotMatchingException("패스워드가 일치하지 않습니다");
		}
		//일치하는 경우
		return new CoachAuthInfo(coach.getCoachEmail(), coach.getCoachName());
	}

}
