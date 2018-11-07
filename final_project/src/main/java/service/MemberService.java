package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Member;
import repository.MemberRepository;
@Service
public class MemberService {
	@Autowired
	private MemberRepository mr;
	
	
	public Integer insertMember(Member member) {
		return mr.insertMember(member);
	}
	
}
