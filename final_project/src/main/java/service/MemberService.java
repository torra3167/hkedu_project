package service;

import org.springframework.beans.factory.annotation.Autowired;

import model.Member;
import repository.MemberRepository;

public class MemberService {
	@Autowired
	private MemberRepository mr;
	
	
	public Integer insertMember(Member member) {
		return mr.insertMember(member);
	}
	
}
